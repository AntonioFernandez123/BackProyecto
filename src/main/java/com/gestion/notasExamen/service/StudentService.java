package com.gestion.notasExamen.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.gestion.notasExamen.dto.StudenCsvRepresentation;
import com.gestion.notasExamen.dto.StudentDTO;
import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.entity.StudentEntity;
import com.gestion.notasExamen.mapper.StudentMapper;
import com.gestion.notasExamen.repository.StudentRepository;
import com.gestion.notasExamen.repository.SubjectRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentService {

  @Autowired
  private SubjectRepository subjectRepository;

  @Autowired
  private StudentMapper studentMapper;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private PasswordEncoder pass;

  public List<StudentDTO> getAllStudents() {
    return studentMapper.StudentEntityListToStudentDTOList(studentRepository.findAll());
  }

  public StudentDTO getStudentById(Long id) {
    return studentMapper.StudentEntityToStudentDTO(studentRepository.getReferenceById(id));
  }

  public void createStudent(StudentResponseDTO student) {

    StudentEntity stu = studentMapper.StudentResponseDTOToStudentEntity(student);

    String passEncoder = pass.encode(stu.getPassword());
    stu.setPassword(passEncoder);

    studentRepository.save(stu);
  }

  public Integer createStudentCSV(MultipartFile file) throws IOException {
    Set<StudentEntity> students = parseCsv(file);
    studentRepository.saveAll(students);
    return students.size();
  }

  private Set<StudentEntity> parseCsv(MultipartFile file) throws IOException {
    try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
      HeaderColumnNameMappingStrategy<StudenCsvRepresentation> strategy =
          new HeaderColumnNameMappingStrategy<>();
      strategy.setType(StudenCsvRepresentation.class);
      CsvToBean<StudenCsvRepresentation> csvToBean =
          new CsvToBeanBuilder<StudenCsvRepresentation>(reader)
              .withMappingStrategy(strategy)
              .withIgnoreEmptyLine(true)
              .withIgnoreLeadingWhiteSpace(true)
              .build();
      return csvToBean.parse()
          .stream()
          .map(csvLine -> StudentEntity.builder()
              .name(csvLine.getName())
              .lastName(csvLine.getLastName())
              .dni(csvLine.getDni())
              .email(csvLine.getEmail())
              .userName(csvLine.getUserName())
              .password(csvLine.getPassword())
              .role(csvLine.getRole())
              .build()
          )
          .collect(Collectors.toSet());
    }
  }

  public void updateStudent(StudentResponseDTO student) {
    studentRepository.save(studentMapper.StudentResponseDTOToStudentEntity(student));
  }

  public void deleteStudent(Long id) {
    if (studentRepository.getReferenceById(id) != null) {
      studentRepository.deleteById(id);
    }
  }

  public List<StudentDTO> getAllStudentInSubject(Long idSubject) {
    if (subjectRepository.existsById(idSubject)) {
      return studentMapper.StudentEntityListToStudentDTOList(studentRepository.findAllBySubjectId(idSubject));
    }
    return null;
  }

//    public void deleteStudentFromSubject(Long idSubject, Long idStudent){
//        if (subjectRepository.existsById(idSubject) && studentRepository.existsById(idStudent)){
//
//        }
//    }

}

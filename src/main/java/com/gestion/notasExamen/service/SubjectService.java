package com.gestion.notasExamen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.dto.SubjectDTO;
import com.gestion.notasExamen.entity.StudentEntity;
import com.gestion.notasExamen.entity.SubjectEntity;
import com.gestion.notasExamen.mapper.StudentMapper;
import com.gestion.notasExamen.mapper.SubjectMapper;
import com.gestion.notasExamen.repository.GradeRepository;
import com.gestion.notasExamen.repository.StudentRepository;
import com.gestion.notasExamen.repository.SubjectRepository;
import com.gestion.notasExamen.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;
    
    public List<SubjectDTO> getAllSubjects(){
        return subjectMapper.SubjectEntityListToSubjectDTOList(subjectRepository.findAll());
    }

    public SubjectDTO getSubjectById(Long id) {
        return subjectMapper.SubjectEntityToSubjectDTO(subjectRepository.getReferenceById(id));
    }

    public void createSubject(SubjectDTO subject) {
        subjectRepository.save(subjectMapper.SubjectDTOToSubjectEntity(subject));
    }

    public void updateSubject(SubjectDTO subject) {
        subjectRepository.save(subjectMapper.SubjectDTOToSubjectEntity(subject));
    }

    public void deleteSubject(Long id) {
        if(subjectRepository.getReferenceById(id) != null) {
            subjectRepository.deleteById(id);
        }
    }

    public List<SubjectDTO> getAllSubjectsWithTeacherAndGradeId(Long idTeacher, Long idGrade){
        if (teacherRepository.existsById(idTeacher) && gradeRepository.existsById(idGrade)){
            return subjectMapper.SubjectEntityListToSubjectDTOList(subjectRepository.findAllByTeacherAndGradeId(idTeacher,idGrade));
        }
        return null;
    }

    public void addStudentsToSubject(List<StudentResponseDTO> students, Long idSubject) {
        SubjectEntity subject = subjectRepository.getReferenceById(idSubject);
        System.out.println(subject);
        List<StudentEntity> listAlu = new ArrayList<>();

        if (subject != null) {
            for (StudentResponseDTO student : students) {
                StudentEntity alu = studentMapper.StudentResponseDTOToStudentEntity(student);
                listAlu.add(alu);
            }
            subject.setStudents(listAlu);
            subjectRepository.save(subject);
        }
    }


//    public void addStudentsToSubject(List<StudentResponseDTO> students, Long idSubject) {
//        SubjectEntity subject = subjectRepository.getReferenceById(idSubject);
//        System.out.println(subject);
//        List<StudentEntity> listAlu = new ArrayList<>();
//
//        if (subject != null) {
//            for (StudentResponseDTO student : students) {
//                StudentEntity alu;
//                Optional<StudentEntity> existingStudent = studentRepository.findByUserName(student.getUserName());
//
//                if (existingStudent.isPresent()){
//                    alu = existingStudent.get();
////                    alu = studentMapper.StudentResponseDTOToStudentEntity(student);
//                }
//                else{
//                    studentService.createStudent(student);
//                    alu = studentRepository.findByUserName(student.getUserName()).get();
////                    alu = studentMapper.StudentResponseDTOToStudentEntity(student);
//                }
//                listAlu.add(alu);
//            }
//            subject.setStudents(listAlu);
//            subjectRepository.save(subject);
//        }
//     }

}

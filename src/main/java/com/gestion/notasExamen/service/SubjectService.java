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
import com.gestion.notasExamen.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private static final Logger log = LoggerFactory.getLogger(SubjectService.class);
    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private Student_SubjectRepository studentSubjectRepository;
    
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

    public void addStudentsToSubject(List<StudentResponseDTO> students, Long idSubject) {
        Optional<SubjectEntity> subject = subjectRepository.findById(idSubject);
        List<StudentEntity> listAlu = new ArrayList<>();

        if (subject!= null) {
            for (StudentResponseDTO student : students) {
                StudentEntity alu = studentMapper.StudentResponseDTOToStudentEntity(student);
                listAlu.add(alu);
            }
            subject.get().setStudents(listAlu);
            subjectRepository.save(subject.get());
            addstudentSubject(subject.get());

        }
     }

     private void addstudentSubject(SubjectEntity subjectEntity){
         Student_SubjectEntity studentSubjectEntity = null;
        for(StudentEntity student: subjectEntity.getStudents()){
            studentSubjectEntity = new Student_SubjectEntity();
            studentSubjectEntity.setStudentSubjectEntityId(
                    Student_SubjectEntityId.builder().idSubject(subjectEntity.getIdSubject())
                            .idStudent(student.getIdStudent()).build());
            studentSubjectRepository.save(studentSubjectEntity);
        }
     }

}

package com.testing4everyone.studentsystem.service;

import com.testing4everyone.studentsystem.model.Student;
import com.testing4everyone.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(String studentId){
        return studentRepository.findById(Integer.valueOf(studentId));
    }

    @Override
    public Optional<Student>getStudentByName(String studentName){
        return studentRepository.findByName(studentName);
    }

    @Override
    public Student updateStudentInfoById(String studentId, Student studentName){
        Student studentUpdate =  studentRepository.getOne(Integer.valueOf(studentId));
        String studentNameStr = studentName.getName();
        String studentAddressStr = studentName.getAddress();
        studentUpdate.setName(studentNameStr);
        studentUpdate.setAddress(studentAddressStr);
        return studentRepository.save(studentUpdate);
    }

    @Override
    public void deleteStudentId(String studentId){
        studentRepository.deleteById(Integer.valueOf(studentId));
    }
}

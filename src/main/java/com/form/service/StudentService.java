package com.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.form.model.Student;
import com.form.repository.StudentRepository;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    public Page<Student> getAllStudents(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable);
    }
    
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
    
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }
    
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
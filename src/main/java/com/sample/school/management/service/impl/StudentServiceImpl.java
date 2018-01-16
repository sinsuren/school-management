package com.sample.school.management.service.impl;

import com.sample.school.management.dao.StudentDao;
import com.sample.school.management.datatypes.StudentRegistrationRequest;
import com.sample.school.management.repository.Student;
import com.sample.school.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by surender.s on 16/01/18.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public void register(StudentRegistrationRequest request) {
        studentDao.create(Student.builder()
                .age(request.getAge())
                .gender(request.getGender()).name(request.getName())
                .build());
    }
}

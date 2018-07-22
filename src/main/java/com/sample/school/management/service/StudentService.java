package com.sample.school.management.service;

import com.sample.school.management.datatypes.StudentRegistrationRequest;
import com.sample.school.management.repository.Student;

/**
 * Created by surender.s on 16/01/18.
 */
public interface StudentService {
    Student register(StudentRegistrationRequest request);
}

package com.sample.school.management.test;

import com.sample.school.management.dao.StudentDao;
import com.sample.school.management.datatypes.StudentRegistrationRequest;
import com.sample.school.management.enums.Gender;
import com.sample.school.management.service.StudentService;
import org.junit.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by surender.s on 22/07/18.
 */
@SpringBootTest
public class StudentTest {

    @Mock
    private StudentService studentService;

    @Mock
    private StudentDao studentDao;

    @Test
    public void registerStudentTest()  {

        StudentRegistrationRequest studentRegistrationRequest = StudentRegistrationRequest.builder()
                .age(1L)
                .gender(Gender.FEMALE)
                .name("abcd")
                .build();

        studentService.register(studentRegistrationRequest);

    }
}

package com.sample.school.management.resource;

import com.codahale.metrics.annotation.Timed;
import com.sample.school.management.datatypes.StudentRegistrationRequest;
import com.sample.school.management.repository.Student;
import com.sample.school.management.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by surender.s on 16/01/18.
 */
@Slf4j
@RestController
@RequestMapping(value = "/students")
public class StudentResource {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = {MediaType.APPLICATION_XML_VALUE })
    @Transactional
    @Timed
    public ResponseEntity createStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest) {
        Student student = null;
        try {
            student = studentService.register(studentRegistrationRequest);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        studentRegistrationRequest.setId(student.getId());
        return ResponseEntity.ok(studentRegistrationRequest);
    }

}

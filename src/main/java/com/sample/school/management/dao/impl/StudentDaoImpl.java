package com.sample.school.management.dao.impl;

import com.sample.school.management.dao.StudentDao;
import com.sample.school.management.repository.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by surender.s on 16/01/18.
 */
@Repository
public class StudentDaoImpl extends AbstractDao<Student, Long> implements StudentDao {

    public StudentDaoImpl(EntityManager entityManager) {
        super(entityManager, Student.class);
    }

    @Override
    public Student create(Student student) {
        return insert(student);
    }
}

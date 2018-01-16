package com.sample.school.management.repository;

import com.sample.school.management.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Created by surender.s on 16/01/18.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="student")
public class Student extends BasicEntity {

    @Column(name = "name", nullable = false)
    private String name ;

    @Column(name = "age", nullable = false)
    private Long age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender" , nullable = false)
    private Gender gender;
}

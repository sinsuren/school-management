package com.sample.school.management.datatypes;

import com.sample.school.management.enums.Gender;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by surender.s on 16/01/18.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(name = "student")
public class StudentRegistrationRequest {

    @XmlAttribute
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long age;

    @NotNull
    private Gender gender;
}

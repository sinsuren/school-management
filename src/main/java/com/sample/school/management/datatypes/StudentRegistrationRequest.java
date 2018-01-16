package com.sample.school.management.datatypes;

import com.sample.school.management.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by surender.s on 16/01/18.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegistrationRequest {
    @NotNull
    private String name;

    @NotNull
    private Long age;

    @NotNull
    private Gender gender;
}

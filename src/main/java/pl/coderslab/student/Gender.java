package pl.coderslab.student;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum Gender {
    MALE,
    FEMALE;

    Gender(String info) {
    }
}

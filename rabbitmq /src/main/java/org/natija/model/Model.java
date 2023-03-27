package org.natija.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Model {
    private String name;
    private String lastname;
    private Integer age;

    public String toString() {
        return String.
                format("Name: %s \n" +
                        "Lastname: %s \n" +
                        "Age: %s",
                        name, lastname, age
                 );
    }
}

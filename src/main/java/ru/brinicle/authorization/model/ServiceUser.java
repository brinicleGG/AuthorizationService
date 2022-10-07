package ru.brinicle.authorization.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceUser {

    private Long id;

    private String firstName;

    private String lastName;
}

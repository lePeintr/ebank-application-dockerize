package net.joel.account_service.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}

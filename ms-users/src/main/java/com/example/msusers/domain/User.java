package com.example.msusers.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    //esta entidad la modelan ustedes de acuerdo a los atributos que vayan a necesitar

    private String id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private List<Bill> userBills;
}

package com.practice.rest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class User {
    @Id
    private String id;

    private String name;

    private String email;

}

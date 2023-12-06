package com.example.o2o.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="Info")
public class Information {
    @Id
    private String ide;
    private String birth;
    private String name;
    private String phone;
    private String mail;
    private String main;
    private int grade;
    private String state;
}

package com.example.o2o.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="rest")
public class Rest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String start;
    private String end;
    private String reason;
    private String memId;
    private String accept;
}

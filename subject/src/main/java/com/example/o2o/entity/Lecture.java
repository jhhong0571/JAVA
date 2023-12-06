package com.example.o2o.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="lecture")
public class Lecture {
    @Id
    private String id;
    private String name;
    private String num;
}

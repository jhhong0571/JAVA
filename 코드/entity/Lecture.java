package com.example.people.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString()
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private Long profId;

    @Column
    private String syliabus;

    @Column
    private Long grade;

    @Column
    private Long credit;

    @Column
    private Long place;

}

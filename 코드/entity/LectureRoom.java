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
@Table(name = "lectureroom")
public class LectureRoom {
    @Id
    @GeneratedValue
    private Long id;
}

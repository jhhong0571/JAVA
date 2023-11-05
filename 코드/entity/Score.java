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
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue
    private Long stid;

    @Column
    private Long leid;

    @Column
    private Long score;

}
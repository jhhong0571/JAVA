package com.example.o2o.entity;
import com.example.o2o.domain.Member;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="score")
public class memScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long score;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
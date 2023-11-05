package com.example.people.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString()
@Table(name = "userinfo")
public class UserInfo {
    @Id
    @GeneratedValue
    private Long id;//학번

    @Column
    private String name;//이름

    @Column
    private Date birth;//생일

    @Column
    private Long grade;//학년

    @Column
    private String email;//이메일

    @Column
    private String department;//학과

    @Column
    private String address;//주소

    @Column
    private String password;//비밀번호

    @Column
    private String state;//상태(휴학)
}

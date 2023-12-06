package com.example.o2o;

import com.example.o2o.domain.Role;
import com.example.o2o.repo.MemberRepository;
import com.example.o2o.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Member 데이터 생성")
    void save() {

        // admin 계정
        // given
        Member admin = new Member();
        admin.setId("admin");
        admin.setName("어드민");
        admin.setRole(Role.ADMIN);
        admin.setPassword(passwordEncoder.encode("1234"));

        // when
        Member savedMember1 = memberRepository.save(admin);
        // then
        assertEquals(admin.getName(), savedMember1.getName());


        //member 계정
        Member member = new Member();
        member.setId("member");
        member.setName("멤버");
        member.setRole(Role.MEMBER);
        member.setPassword(passwordEncoder.encode("1234"));
        // when
        Member savedMember2 = memberRepository.save(member);
        // then
        assertEquals(member.getName(), savedMember2.getName());

        //member 계정
        Member membe = new Member();
        membe.setId("20193346");
        membe.setName("멤버");
        membe.setRole(Role.MEMBER);
        membe.setPassword(passwordEncoder.encode("1234"));
        // when
        Member savedMembe2 = memberRepository.save(membe);
        // then
        assertEquals(membe.getName(), savedMembe2.getName());


    }
}
package com.example.o2o.service;

import com.example.o2o.config.SecurityUser;
import com.example.o2o.domain.Member;
import com.example.o2o.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optional = memberRepo.findById(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException(username + " 사용자 없음");
        } else {
            Member member = optional.get();
            System.out.println(member.getRole());
            return new SecurityUser(member);
        }
    }
}

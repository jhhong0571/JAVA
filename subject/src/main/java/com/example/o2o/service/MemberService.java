package com.example.o2o.service;

import com.example.o2o.domain.Member;
import com.example.o2o.entity.Information;
import com.example.o2o.entity.Rest;
import com.example.o2o.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final InformationRepo informationRepo;
    private final MemberRepository memberRepository;
    private final RestRepo restRepo;

    @Autowired
    public MemberService(InformationRepo informationRepo, MemberRepository memberRepository, RestRepo restRepo){
        this.informationRepo=informationRepo;
        this.memberRepository=memberRepository;
        this.restRepo=restRepo;
    }
    public Information getInformationById(String name){return informationRepo.findByIde(name);}
    public Member getMemberById(String name){return memberRepository.findById(name).orElse(null);}
    public Member pwchange(String id, String pw){
        Member mem = memberRepository.findById(id).orElse(null);
        assert mem != null;
        mem.setPassword(passwordEncoder.encode(pw));
        return memberRepository.save(mem);
    }
    public Information infochange(String ide, String phone, String mail){
        Information inf = informationRepo.findByIde(ide);
        inf.setPhone(phone);
        inf.setMail(mail);
        return informationRepo.save(inf);
    }

    public List<Rest> getAllMemsRest(String name) {
        return restRepo.findAllByMemId(name);
    }

    public void createRest(Rest rest) {
        restRepo.save(rest);
    }

    public void deleteRest(Long id) {
        restRepo.delete(restRepo.findById(id));
    }
}

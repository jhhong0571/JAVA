package com.example.people.service;

import com.example.people.entity.UserInfo;
import com.example.people.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserInfoRepository userinfoRepository;

    public UserInfo login(Long id, String password) {
        Optional<UserInfo> userinfo = userinfoRepository.findById(id);
        if (userinfo.isPresent() && userinfo.get().getPassword().equals(password)) {
            return userinfo.get();
        }
        return null;
    }
}
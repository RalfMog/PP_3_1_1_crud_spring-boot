package com.kata.academy.spring.boot_3_1_1.service;


import com.kata.academy.spring.boot_3_1_1.model.User;
import com.kata.academy.spring.boot_3_1_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id){
        return userRepository.getOne(id);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @Override
    @Transactional
    public User saveUser(User user){
        return userRepository.save(user);
    }
    
    @Override
    @Transactional
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}

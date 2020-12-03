package com.crehana.demo.service.impl;

import com.crehana.demo.exception.ResourceNotFoundException;
import com.crehana.demo.model.User;
import com.crehana.demo.repository.UserRepository;
import com.crehana.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() { return this.userRepository.findAll(); }

    @Override
    public Page<User> getAllUsersPage(Pageable pageable) { return this.userRepository.findAll(pageable); }

    @Override
    public Page<User> getAllUsersByMembershipId(Long memberId, Pageable pageable) {
        return this.userRepository.findByMembershipId(memberId, pageable);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with id"+ userId + "nor found"));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User with username"+ username + "not found"));
    }
}

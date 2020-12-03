package com.crehana.demo.service;

import com.crehana.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    Page<User> getAllUsersPage(Pageable pageable);
    Page<User> getAllUsersByMembershipId(Long memberId, Pageable pageable);
    User getUserById(Long userId);
    User getUserByUsername(String username);
}

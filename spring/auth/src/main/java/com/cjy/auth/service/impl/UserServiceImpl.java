package com.cjy.auth.service.impl;

import com.cjy.auth.entity.User;
import com.cjy.auth.repository.UserRepository;
import com.cjy.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Page<User> getUserList(Pageable page) {
        return userRepository.findAll(page);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Long save(User user) {
        return userRepository.save(user).getUserId();
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}

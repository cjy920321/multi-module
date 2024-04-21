package com.cjy.auth.service;

import com.cjy.auth.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User getUserById(Long userId);

    Page<User> getUserList(Pageable page);

    List<User> getAllUser();
    
    Long save(User user);

    void delete(Long userId);
}

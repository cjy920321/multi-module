package com.cjy.auth.service;

import com.cjy.auth.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User getUserById(Long userId);

    Page<User> getUserList(Pageable page);
    
    Long save(User user);

    void delete(Long userId);
}

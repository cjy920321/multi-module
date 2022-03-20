package com.cjy.auth.controller;

import com.cjy.auth.entity.User;
import com.cjy.auth.service.UserService;
import com.cjy.base.util.ParamUtil;
import com.cjy.common.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public Response<User> getOne(@PathVariable Long userId) {
        return Response.success(userService.getUserById(userId));
    }

    @GetMapping
    public Response<Page<User>> getList(Integer pageNumber, Integer pageSize) {
        return Response.success(userService.getUserList(ParamUtil.buildPage(pageNumber, pageSize)));
    }

    @PostMapping
    public Response<Long> save(@RequestBody User user) {
        return Response.success(userService.save(user));
    }

    @DeleteMapping("/{userId}")
    public Response<String> delete(@PathVariable Long userId) {
        userService.delete(userId);
        return Response.success();
    }
}

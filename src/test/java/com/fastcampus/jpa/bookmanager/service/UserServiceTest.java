package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Martin
 * @since 2021/05/13
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        userService.put();

//        System.out.println(">>> " + userRepository.findByEmail("newUser@fastcampus.com"));
        userRepository.findAll().forEach(System.out::println);
    }

}

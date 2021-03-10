package com.fastcampus.jpa.bookmanager.repository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

/**
 * @author Martin
 * @since 2021/03/10
 */
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() { // create, read, update, delete
        User user = new User();
        user.setEmail("slow");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);
    }
}

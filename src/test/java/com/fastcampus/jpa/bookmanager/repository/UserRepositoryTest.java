package com.fastcampus.jpa.bookmanager.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.fastcampus.jpa.bookmanager.domain.Address;
import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.domain.UserHistory;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Martin
 * @since 2021/03/10
 */
@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    void crud() { // create, read, update, delete
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        userRepository.save(user);
    }

    @Test
    void select() {
//        System.out.println(userRepository.findByName("dennis"));
//
//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
//
//        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@fastcampus.com"));
//
//        System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
//        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));

        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "dennis"));

        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println("findByIdIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));

        System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "art" + "%"));
    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Order.desc("id"), Order.asc("email"))));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Order.desc("id"), Order.asc("email"))));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Order.desc("id"), Order.asc("email"))));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("martin", PageRequest.of(1, 1, Sort.by(Order.desc("id")))).getTotalElements());
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("martin");
        user.setEmail("martin2@fastcampus.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin");

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin2@fastcampus.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("martin-new@fastcampus.com");
        user.setName("martin-new");

        userRepository.save(user);

        user.setName("martin-new-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("david");
        user.setEmail("david@fastcampus.com");
        user.setGender(Gender.MALE);
        userRepository.save(user);

        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@fastcampus.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

//        List<UserHistory> result = userHistoryRepository.findByUserId(
//            userRepository.findByEmail("daniel@fastcampus.com").getId());

        List<UserHistory> result = userRepository.findByEmail("daniel@fastcampus.com").getUserHistories();

        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());
    }

    @Test
    void embedTest() {
        userRepository.findAll().forEach(System.out::println);

        User user = new User();
        user.setName("steve");
        user.setHomeAddress(new Address("서울시", "강남구", "강남대로 364 미왕빌딩", "06241"));
        user.setCompanyAddress(new Address("서울시", "성동구", "성수이로 113 제강빌딩", "04794"));

        userRepository.save(user);

        User user1 = new User();
        user1.setName("joshua");
        user1.setHomeAddress(null);
        user1.setCompanyAddress(null);

        userRepository.save(user1);

        User user2 = new User();
        user2.setName("jordan");
        user2.setHomeAddress(new Address());
        user2.setCompanyAddress(new Address());

        userRepository.save(user2);

//        entityManager.clear();

        userRepository.findAll().forEach(System.out::println);
        userHistoryRepository.findAll().forEach(System.out::println);

        userRepository.findAllRawRecord().forEach(a -> System.out.println(a.values()));

        assertAll(
            () -> assertThat(userRepository.findById(7L).get().getHomeAddress()).isNull(),
            () -> assertThat(userRepository.findById(8L).get().getHomeAddress()).isInstanceOf(Address.class)
        );
    }
}

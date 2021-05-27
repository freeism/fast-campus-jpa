package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Martin
 * @since 2021/03/31
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();
}

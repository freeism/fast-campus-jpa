package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Martin
 * @since 2021/03/31
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}

package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Martin
 * @since 2021/04/21
 */
public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
}

package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Martin
 * @since 2021/04/21
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}

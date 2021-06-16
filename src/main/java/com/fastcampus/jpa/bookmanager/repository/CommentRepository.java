package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Martin
 * @since 2021/06/16
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}

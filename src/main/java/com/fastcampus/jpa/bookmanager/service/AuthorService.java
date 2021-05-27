package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Author;
import com.fastcampus.jpa.bookmanager.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Martin
 * @since 2021/05/27
 */
@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional(propagation =  Propagation.NESTED)
    public void putAuthor() {
        Author author = new Author();
        author.setName("martin");

        authorRepository.save(author);

//        throw new RuntimeException("오류가 발생하였습니다. transaction은 어떻게 될까요?");
    }
}

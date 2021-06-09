package com.fastcampus.jpa.bookmanager.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Martin
 * @since 2021/06/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookNameAndCategory {
    private String name;
    private String category;
}

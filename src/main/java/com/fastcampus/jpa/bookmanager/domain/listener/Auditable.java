package com.fastcampus.jpa.bookmanager.domain.listener;

import java.time.LocalDateTime;

/**
 * @author Martin
 * @since 2021/03/31
 */
public interface Auditable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}

package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Martin
 * @since 2021/03/31
 */
@Data
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Auditable {
    @CreatedDate
    @Column(columnDefinition = "datetime(6) default now(6) comment '생성시간'", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "datetime(6) default now(6) comment '수정시간'", nullable = false)
    private LocalDateTime updatedAt;
}

package com.fastcampus.jpa.bookmanager.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Martin
 * @since 2021/03/17
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;    // 시

    private String district;    // 구

    @Column(name = "address_detail")
    private String detail;  // 상세주소

    private String zipCode; // 우편번호
}

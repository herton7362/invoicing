package com.herton.module.basicdata.member.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Setter
@Getter
public class MemberCard extends BaseEntity {
    @Column(length = 20)
    private String cardNumber;
    @Column(length = 36)
    private String memberCardTypeId;
    @Column(length = 36)
    private String memberId;
    @Column(length = 11, precision = 13, scale = 2)
    private Double balance;
    @Column(length = 11)
    private Integer points;
    @Column(length = 3, precision = 3, scale = 2)
    private Double discount;
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date expireDate;
    private String password;
}

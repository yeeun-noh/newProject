package com.example.board.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends BaseTimeEntity {

    @CreatedBy
    @Column(name = "CREATED_NAME", updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "UPDATED_NAME")
    private String updatedBy;

}

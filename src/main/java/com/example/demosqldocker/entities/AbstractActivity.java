package com.example.demosqldocker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractActivity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    public Long id;

    @CreatedDate
    @Column(name = "created_at",nullable = false)
    @JsonIgnore
    private Instant createdAt = Instant.now();

    @LastModifiedDate
    @Column(name = "modified_at",nullable = false)
    @JsonIgnore
    private Instant modifiedAt = Instant.now();
}

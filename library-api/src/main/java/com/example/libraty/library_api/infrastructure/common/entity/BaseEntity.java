package com.example.libraty.library_api.infrastructure.common.entity;

import com.example.libraty.library_api.domain.common.model.BaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @CreationTimestamp
    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(name = "modified")
    private Date modified;

    @Column(name = "status", nullable = false)
    private String status;

    protected BaseEntity() { }

    protected BaseEntity(UUID id, String status) {
        this.id = id;
        this.status = status;
    }

    public BaseModel toBaseModel() {
        return new BaseModel(id, created, modified, status);
    }
}

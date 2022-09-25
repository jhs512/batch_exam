package com.ll.exam.app351.app.product.entity;

import com.ll.exam.app351.app.base.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductOption extends BaseEntity {
    @EqualsAndHashCode.Include
    private String color;
    @EqualsAndHashCode.Include
    private String size;

    private Integer price;

    @ManyToOne(fetch = LAZY)
    private Product product;

    public ProductOption(String name, String size) {
        this.color = name;
        this.size = size;
    }
}

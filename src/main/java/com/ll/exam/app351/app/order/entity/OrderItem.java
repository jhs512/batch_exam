package com.ll.exam.app351.app.order.entity;

import com.ll.exam.app351.app.base.entity.BaseEntity;
import com.ll.exam.app351.app.product.entity.ProductOption;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class OrderItem extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Order order;

    @ManyToOne(fetch = LAZY)
    private ProductOption productOption;

    private Integer count;
}

package com.ll.exam.app351.app.order.entity;

import com.ll.exam.app351.app.base.entity.BaseEntity;
import com.ll.exam.app351.app.member.entity.Member;
import com.ll.exam.app351.app.product.entity.ProductOption;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Table(name = "orders")
public class Order extends BaseEntity {
    @ManyToOne
    private Member member;

    @Builder.Default
    @OneToMany(mappedBy = "order", cascade = ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    public void addOrderItem(ProductOption productOption) {
        OrderItem orderItem = OrderItem.builder()
                .productOption(productOption)
                .order(this)
                .build();
        orderItems.add(orderItem);
    }
}

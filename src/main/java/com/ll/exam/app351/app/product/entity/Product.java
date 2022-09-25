package com.ll.exam.app351.app.product.entity;

import com.ll.exam.app351.app.base.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor
public class Product extends BaseEntity {
    private String name;

    private Integer price;

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = ALL, orphanRemoval = true)
    private Set<ProductOption> productOptions = new LinkedHashSet<>();

    public void addOption(ProductOption productOption) {
        productOption.setProduct(this);
        productOption.setPrice(getPrice());
        productOptions.add(productOption);
    }
}

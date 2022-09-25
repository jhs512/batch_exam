package com.ll.exam.app351.app.product;

import com.ll.exam.app351.app.product.entity.Product;
import com.ll.exam.app351.app.product.entity.ProductOption;
import com.ll.exam.app351.app.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Product create(String name, int price, List<ProductOption> productOptions) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .build();

        productRepository.save(product);

        if (productOptions != null) {
            productOptions.stream()
                    .forEach(productOption -> product.addOption(productOption));
        }

        return product;
    }
}

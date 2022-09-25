package com.ll.exam.app351.app.order;

import com.ll.exam.app351.app.member.entity.Member;
import com.ll.exam.app351.app.order.entity.Order;
import com.ll.exam.app351.app.order.exception.ProductOptionNotFoundException;
import com.ll.exam.app351.app.order.repository.OrderRepository;
import com.ll.exam.app351.app.product.entity.ProductOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderSerivce {
    private final OrderRepository orderRepository;

    public Order create(Member member, Set<ProductOption> productOptions) {
        Order order = Order.builder()
                .member(member)
                .build();

        if (productOptions == null) {
            throw new ProductOptionNotFoundException();
        }

        productOptions.forEach(productOption -> order.addOrderItem(productOption));

        orderRepository.save(order);

        return order;
    }
}

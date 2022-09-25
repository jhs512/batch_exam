package com.ll.exam.app351.app.base;

import com.ll.exam.app351.app.member.entity.Member;
import com.ll.exam.app351.app.member.service.MemberService;
import com.ll.exam.app351.app.order.OrderSerivce;
import com.ll.exam.app351.app.order.entity.Order;
import com.ll.exam.app351.app.product.ProductService;
import com.ll.exam.app351.app.product.entity.Product;
import com.ll.exam.app351.app.product.entity.ProductOption;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@Configuration
@Profile("dev")
public class DevInitData {
    @Bean
    public CommandLineRunner initData(MemberService memberService, ProductService productService, OrderSerivce orderService) {
        return args -> {
            String password = "{noop}1234";
            Member member1 = memberService.join("user1", password, "user1@test.com");
            Member member2 = memberService.join("user2", password, "user2@test.com");
            Member member3 = memberService.join("user3", password, "user3@test.com");
            Member member4 = memberService.join("user4", password, "user4@test.com");

            Product product1 = productService.create("상품명1", 3000, Arrays.asList(new ProductOption("레드", "44"), new ProductOption("레드", "55"), new ProductOption("블루", "44"), new ProductOption("블루", "55")));
            Product product2 = productService.create("상품명2", 3500, Arrays.asList(new ProductOption("레드", "44"), new ProductOption("레드", "55"), new ProductOption("블루", "44"), new ProductOption("블루", "55")));

            Set<ProductOption> productOptions = product2.getProductOptions();

            Order order1 = orderService.create(member2, productOptions);
        };
    }
}

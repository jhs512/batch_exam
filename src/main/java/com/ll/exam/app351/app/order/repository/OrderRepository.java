package com.ll.exam.app351.app.order.repository;


import com.ll.exam.app351.app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

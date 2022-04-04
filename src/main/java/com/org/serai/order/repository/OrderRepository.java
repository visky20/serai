package com.org.serai.order.repository;

import com.org.serai.order.model.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<PizzaOrder, Long> {

    //@Query(value = "SELECT * FROM PIZZA_ORDER WHERE USER_ID = :userId", nativeQuery = true)
    @Query(value = "SELECT ID,NAME,PRICE,QUANTITY,P.PIZZA_ORDERS_USER_ID, U.USER_ID, U.ACTIVE, U.PASSWORD, U.ROLES,U.USER_NAME FROM " +
            "PIZZA_ORDER P, USER U WHERE U.USER_ID = P.PIZZA_ORDERS_USER_ID AND U.USER_NAME = :userName", nativeQuery = true)
    List<PizzaOrder> findAllOrdersByUserName(@Param("userName") String userName);
}

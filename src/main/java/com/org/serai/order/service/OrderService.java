package com.org.serai.order.service;

import com.org.serai.order.model.PizzaOrder;
import com.org.serai.order.model.User;
import com.org.serai.order.repository.OrderRepository;
import com.org.serai.order.repository.UserRepository;
import com.org.serai.order.restadvice.CustomServieException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    public PizzaOrder saveOrder(PizzaOrder orders) {/*
        Optional<User> user = userRepository.findByUserName(orders.getUser().getUserName());
        if (user.isPresent()) {
            orders.getUser().setId(user.get().getId());
        } else {
            orders.getUser().setPassword("password");
            orders.getUser().setRoles("USER");
            orders.setUser(userRepository.save(orders.getUser()));
        }*/
        return orderRepository.save(orders);
    }

    public List<PizzaOrder> fetchAllOrder() {
        return orderRepository.findAll();
    }

    public List<PizzaOrder> fetchAllOrderForUserId(String userName) {
        List<PizzaOrder> orders = orderRepository.findAllOrdersByUserName(userName);
        if (null == orders || orders.isEmpty()) {
            throw new CustomServieException("Order not found for userName: " + userName);
        }
        return orders;

    }

}

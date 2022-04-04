package com.org.serai.order.service;

import com.org.serai.order.model.PizzaOrder;
import com.org.serai.order.model.User;
import com.org.serai.order.repository.OrderRepository;
import com.org.serai.order.repository.UserRepository;
import com.org.serai.order.restadvice.CustomServieException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Data
@Slf4j
public class UserService implements Serializable {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User placeOrder(User user) {
        try {
            //Optional<User> optionalUser = userRepository.findByUserName(user.getUserName());
            /*if (optionalUser.isPresent()) {
                user.getPizzaOrders().forEach(pizzaOrder -> pizzaOrder.setPizzaOrdersUserId(optionalUser.get().getId()));
                List<PizzaOrder> pizzaOrders = orderRepository.saveAll(user.getPizzaOrders());
                optionalUser.get().setPizzaOrders(pizzaOrders);
                return optionalUser.get();
            }*/
            return userRepository.save(user);
        } catch (Exception exception) {
            log.error("", exception);
            throw new CustomServieException(exception.getMessage());
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOderDetailsByUserName(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("User Details Not found: " + userName));
        return userRepository.findByUserName(userName).get();


    }

}

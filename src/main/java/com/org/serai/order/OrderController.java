package com.org.serai.order;

import com.org.serai.order.model.OrderRequest;
import com.org.serai.order.model.PizzaOrder;
import com.org.serai.order.model.User;
import com.org.serai.order.restadvice.CustomServieException;
import com.org.serai.order.service.OrderService;
import com.org.serai.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController implements ErrorController {

    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home() {
        return "<h1>Hello Welcome to Pizza online order !!</h1>";
    }


    @RequestMapping("/error")
    String error() {
        return "<h1> Invalid Request !!<h1>";
    }

    @GetMapping("/access-denied")
    public String getAccessDenied() {
        return "/error/accessDenied";
    }

    @GetMapping("/getAllOrder")
    public ResponseEntity<List<PizzaOrder>> getAllOrders() {
        return new ResponseEntity<>(orderService.fetchAllOrder(), HttpStatus.OK);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<List<PizzaOrder>> getOrder(@RequestParam(name = "userName") String userName) {
        try {
            List<PizzaOrder> pizzaOrders = orderService.fetchAllOrderForUserId(userName);
            return new ResponseEntity<List<PizzaOrder>>(pizzaOrders, HttpStatus.OK);

        } catch (Exception e) {
            throw new CustomServieException("Order not found for userName:" + userName);

        }
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {

        try {
            return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomServieException("Users not found");

        }

    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        try {
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomServieException("Error while creating user");
        }
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<User> placeOrder(@RequestBody OrderRequest orderRequest) {

        try {
            return new ResponseEntity<>(userService.placeOrder(orderRequest.getUser()), HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomServieException("Error while creating user");
        }
    }

    @GetMapping("/findAllOrders")
    public List<User> findAllOrders() {
        return userService.findAll();

    }

    @GetMapping("/findByUser")
    public User findOderDetailsByUserName(@RequestParam(name = "userName") String userName) {
        return userService.findOderDetailsByUserName(userName);

    }


}

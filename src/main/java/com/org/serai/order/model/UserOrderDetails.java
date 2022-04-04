package com.org.serai.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserOrderDetails {

    String userName;
    List<PizzaOrder> pizzaOrders;
}

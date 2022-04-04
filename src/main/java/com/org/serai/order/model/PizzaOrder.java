package com.org.serai.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "PIZZA_ORDER")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;

}

package com.org.serai.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;
    private String userName;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private boolean active;
    private String roles;
    @OneToMany(targetEntity = PizzaOrder.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "USER_ID")
    private List<PizzaOrder> pizzaOrders;

}

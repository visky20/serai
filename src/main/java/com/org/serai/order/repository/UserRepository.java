package com.org.serai.order.repository;

import com.org.serai.order.model.User;
import com.org.serai.order.model.UserOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByUserName(String userName);

}

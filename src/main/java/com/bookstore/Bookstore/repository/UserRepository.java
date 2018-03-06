package com.bookstore.Bookstore.repository;

import com.bookstore.Bookstore.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{

    User findByUsername(String username);
}

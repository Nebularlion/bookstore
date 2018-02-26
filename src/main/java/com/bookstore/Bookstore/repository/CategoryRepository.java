package com.bookstore.Bookstore.repository;

import com.bookstore.Bookstore.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long>{

    List<Category> findByName(String name);

}

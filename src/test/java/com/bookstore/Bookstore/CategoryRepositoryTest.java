package com.bookstore.Bookstore;


import com.bookstore.Bookstore.model.Book;
import com.bookstore.Bookstore.model.Category;
import com.bookstore.Bookstore.repository.CategoryRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Before
    public void setUp() {
        Category category = new Category();

        category.setName("Sci-Fi");

        repository.save(category);
    }

    @After
    public void tearDown() {
        List<Category> categories = (List<Category>) repository.findAll();

        for (Category category : categories) {
            repository.delete(category.getId());
        }

    }

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = repository.findByName("Sci-Fi");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Sci-Fi");
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("Botany");
        repository.save(category);
        assertThat(category.getId()).isNotNull();
    }
}
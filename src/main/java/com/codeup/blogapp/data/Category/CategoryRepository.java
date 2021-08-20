package com.codeup.blogapp.data.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public class CategoryRepository {

    public interface CategoriesRepository extends JpaRepository<Category, Long> {

    }
}

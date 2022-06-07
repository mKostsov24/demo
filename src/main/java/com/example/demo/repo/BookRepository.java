package com.example.demo.repo;

import com.example.demo.model.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    List<Books> findByNameStartingWithIgnoreCase(String name);

    @Query(value = "SELECT lower(LEFT(name, 1)) as name, COUNT(id) AS count FROM books GROUP BY lower(LEFT(name, 1))",
            nativeQuery = true)
    List<Object[]> findCountOfBook();
}

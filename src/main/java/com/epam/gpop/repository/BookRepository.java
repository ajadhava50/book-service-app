package com.epam.gpop.repository;

import com.epam.gpop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}

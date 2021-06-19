package com.epam.gpop.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
@Data
public class BookDto {

    private Long book_id;
    private String name;
    private Double price;
    private String author;
    private Date created;
    private Date updated;

}

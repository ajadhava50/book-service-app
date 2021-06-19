package com.epam.gpop.controller;

import com.epam.gpop.dto.BookDto;
import com.epam.gpop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
@RestController
@RefreshScope
@RequestMapping("/health")
public class HealthController {

    @Value("${health.check.message}")
    private String healthCheckMsg;

    public String getHealth(){

        return healthCheckMsg;
    }
}
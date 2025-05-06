package com.agroconnect.frogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test-db-connection")
    public String testDbConnection() {
        try {
            // Execute a simple query to check the connection
            String result = jdbcTemplate.queryForObject("SELECT 1", String.class);
            return "Database connection is successful. Test query result: " + result;
        } catch (Exception e) {
            // Catch any exception and return an error message
            return "Error: Unable to connect to the database. " + e.getMessage();
        }
    }
}

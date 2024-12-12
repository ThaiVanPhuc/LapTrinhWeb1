package com.example.DoAnKTHP.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {
    public static void main(String[] args) {
        // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // String hashedPassword = encoder.encode("phuc2406");
        // boolean matches = encoder.matches("phuc2406", hashedPassword);
        System.out.println(new BCryptPasswordEncoder().encode("phuc2406"));
    }
}

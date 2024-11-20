package com.example.DoAnKTHP.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean isUserLoggedIn(HttpSession session) {
        return session.getAttribute("USERS") != null;
    }
}

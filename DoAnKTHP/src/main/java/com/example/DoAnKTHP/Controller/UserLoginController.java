package com.example.DoAnKTHP.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DoAnKTHP.Repository.RoleRepository;
import com.example.DoAnKTHP.Repository.UserRepository;
import com.example.DoAnKTHP.Repository.UserRoleRepository;
import com.example.DoAnKTHP.models.Role;
import com.example.DoAnKTHP.models.User;
import com.example.DoAnKTHP.models.User_Role;

import org.springframework.ui.Model;

@Controller
public class UserLoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String handleSignup(User user, Model model) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("message", "Username đã tồn tại!");
            return "signup";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);
        user.setCreatedAt(formattedNow);
        user.setUpdatedAt(formattedNow);
        userRepository.save(user);

        User_Role userRoleMapping = new User_Role();
        userRoleMapping.setUser(user);
        userRoleMapping.setRole(userRole);
        userRoleRepository.save(userRoleMapping);
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String showSignup() {
        return "signup";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
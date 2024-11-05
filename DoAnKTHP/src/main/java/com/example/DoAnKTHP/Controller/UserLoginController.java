package com.example.DoAnKTHP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DoAnKTHP.Repository.LichLopRepository;
import com.example.DoAnKTHP.models.LichLop;
import com.example.DoAnKTHP.models.UserGV;
import com.example.DoAnKTHP.service.UserGVService;
import com.example.DoAnKTHP.service.LichDeXuatService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    @Autowired
    private UserGVService userGVService;

    @Autowired
    private LichDeXuatService lichDeXuatService;

    @GetMapping("/signup")
    public String showSignup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password, @RequestParam String email,
            ModelMap model) {
        UserGV existingUser = userGVService.findUserByUsername(username);
        if (existingUser != null) {
            model.addAttribute("message", "Tên đăng nhập đã tồn tại!");
            return "signup";
        }

        UserGV newUser = new UserGV();
        newUser.setUserName(username);
        newUser.setPassWord(password);
        userGVService.saveUser(newUser);
        model.addAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("USERS");
        return "redirect:/login";
    }

    @GetMapping("/")
    public String showLogin(ModelMap model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, ModelMap model,
            HttpSession session) {
        UserGV user = userGVService.findUserByUsername(username);
        if (user == null || !user.getPassWord().equals(password)) {
            model.addAttribute("ERROR", "Username hoặc Password không chính xác");
            return "login";
        }
        session.setAttribute("USERS", user);
        return "redirect:/select-class"; // Chuyển đến trang chọn lớp
    }

    private LichLopRepository lichLopRepository;

    public List<LichLop> getClassesForTeacher(String username) {
        return lichLopRepository.findByTeacherUsername(username);
    }

    @GetMapping("/select-class")
    public String showSelectClass(ModelMap model, HttpSession session) {
        UserGV user = (UserGV) session.getAttribute("USERS");
        if (user == null) {
            return "redirect:/login"; // Nếu chưa đăng nhập, quay lại trang login
        }

        model.addAttribute("classes", getClassesForTeacher(user.getUserName()));
        return "select-class"; // Trang chọn lớp
    }

    @PostMapping("/generate-schedule")
    public String generateSchedule(@RequestParam String classId, ModelMap model, HttpSession session) {
        UserGV user = (UserGV) session.getAttribute("USERS");
        if (user == null) {
            return "redirect:/login"; // Nếu chưa đăng nhập, quay lại trang login
        }

        model.addAttribute("schedule", lichDeXuatService.laylichDeXuat(classId, session));
        return "schedule"; // Trang hiển thị lịch đề xuất
    }
}

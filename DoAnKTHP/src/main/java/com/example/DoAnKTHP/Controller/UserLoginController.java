package com.example.DoAnKTHP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DoAnKTHP.models.LichLop;
import com.example.DoAnKTHP.models.GiangVien;
import com.example.DoAnKTHP.service.UserGVService;
import com.example.DoAnKTHP.service.LichDeXuatService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    @Autowired
    private UserGVService userGVService;

    @Autowired
    private LichDeXuatService lichDeXuatService;

    // Trang đăng ký
    @GetMapping("/")
    public String showSignup() {
        return "signup";
    }

    // Xử lý đăng ký
    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password, @RequestParam String email,
            ModelMap model) {
        GiangVien existingUser = userGVService.findUserByUsername(username);
        if (existingUser != null) {
            model.addAttribute("message", "Tên đăng nhập đã tồn tại!");
            return "signup";
        }

        GiangVien newUser = new GiangVien();
        newUser.setUserName(username);
        newUser.setPassWord(password);
        userGVService.saveUser(newUser);
        model.addAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
        return "login";
    }

    // Trang đăng nhập
    @GetMapping("/login")
    public String showLogin(ModelMap model) {
        return "login";
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, ModelMap model,
            HttpSession session) {
        GiangVien user = userGVService.findUserByUsername(username);
        if (user == null || !user.getPassWord().equals(password)) {
            model.addAttribute("ERROR", "Username hoặc Password không chính xác");
            return "login";
        }
        session.setAttribute("USERS", user);
        return "redirect:/select-class"; // Chuyển đến trang chọn lớp
    }

    // Đăng xuất
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("USERS");
        return "redirect:/";
    }

    // Lấy danh sách lớp của giảng viên
    private List<LichLop> getClassesForTeacher(String username) {
        // Giả sử bạn đã có method lấy lớp của giảng viên trong service
        return lichDeXuatService.getClassesForTeacher(username); // Cần implement trong service
    }

    // Trang chọn lớp
    @GetMapping("/select-class")
    public String showSelectClass(ModelMap model, HttpSession session) {
        GiangVien user = (GiangVien) session.getAttribute("USERS");
        if (user == null) {
            return "redirect:/"; // Nếu chưa đăng nhập, quay lại trang login
        }

        model.addAttribute("classes", getClassesForTeacher(user.getUserName())); // Truyền danh sách lớp cho giảng viên
        return "index"; // Trang chọn lớp
    }

    // Tạo lịch dạy cho lớp đã chọn
    @PostMapping("/generate-schedule")
    public String generateSchedule(@RequestParam String classId, ModelMap model, HttpSession session) {
        GiangVien user = (GiangVien) session.getAttribute("USERS");
        if (user == null) {
            return "redirect:/"; // Nếu chưa đăng nhập, quay lại trang login
        }

        // Lấy lịch đề xuất từ service
        model.addAttribute("schedule", lichDeXuatService.laylichDeXuat(classId, session));
        return "schedule"; // Trang hiển thị lịch đề xuất
    }
}

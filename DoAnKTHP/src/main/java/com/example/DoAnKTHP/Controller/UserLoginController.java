// package com.example.DoAnKTHP.Controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.ModelMap;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.example.DoAnKTHP.models.LichLop;
// import com.example.DoAnKTHP.models.GiangVien;
// import com.example.DoAnKTHP.service.UserGVService;
// import com.example.DoAnKTHP.service.LichDeXuatService;

// import jakarta.servlet.http.HttpSession;

// @Controller
// public class UserLoginController {

// @Autowired
// private UserGVService userGVService;

// @GetMapping("/")
// public String showSignup() {
// return "signup";
// }

// @PostMapping("/signup")
// public String signup(@RequestParam String username, @RequestParam String
// password, @RequestParam String email,
// ModelMap model) {
// GiangVien existingUser = userGVService.findUserByUsername(username);
// if (existingUser != null) {
// model.addAttribute("message", "Tên đăng nhập đã tồn tại!");
// return "signup";
// }

// GiangVien newUser = new GiangVien();
// newUser.setTenGiangVien(username);
// newUser.setMatkhauGv(password);
// userGVService.saveUser(newUser);
// model.addAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
// return "login";
// }

// @GetMapping("/login")
// public String showLogin(ModelMap model) {
// return "login";
// }

// @PostMapping("/login")
// public String login(@RequestParam String username, @RequestParam String
// password, ModelMap model,
// HttpSession session) {
// GiangVien user = userGVService.findUserByUsername(username);
// if (user == null || !user.getPassWord().equals(password)) {
// model.addAttribute("ERROR", "Username hoặc Password không chính xác");
// return "login";
// }
// session.setAttribute("USERS", user);
// return "redirect:/dexuat-lich";
// }

// // Đăng xuất
// @GetMapping("/logout")
// public String logout(HttpSession session) {
// session.removeAttribute("USERS");
// return "redirect:/";
// }
// }

package scu.cj.community.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import scu.cj.community.exception.CustomizeErrorCode;
import scu.cj.community.exception.CustomizeException;
import scu.cj.community.mapper.UserMapper;
import scu.cj.community.model.User;
import scu.cj.community.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : lkk
 * @date : 22:48 2019/12/14
 * @creed: Talk is cheap,show me the code
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String toLogin(){
        return "login.html";
    }

    @PostMapping("/login")
    public String Login(@RequestParam(value = "studentId") String studentId ,
                        @RequestParam(value = "pass") String password,
                        HttpServletResponse response,
                        Model model){
//        User user = new User();
//        user.setId((long) 2);
//        user.setAccountId("37283635");
//        user.setName("lkk");
//        user.setToken("o4ip0yNOJdqCFkeCOweaMg==");
        User user = userService.validationUser(studentId, password);
        if(user==null){
            model.addAttribute("error", "账户名或者密码错误");
            return "/login";
        }
//        System.out.println(username);
//        System.out.println(password);
        Cookie cookie = new Cookie("token",user.getToken());
        System.out.println("cookie放置成功");
        response.addCookie(cookie);

        return "redirect:/";
    }

}

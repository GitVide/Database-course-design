package scu.cj.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import scu.cj.community.model.User;
import scu.cj.community.service.UserService;

import java.util.List;

@Controller
public class UserSearchController {
    @Autowired
    private UserService userService;

    @GetMapping("/userSearch")
    public String userSearch(@RequestParam(name = "search", required = false) String search, Model model) {
        List<User> userList = userService.findUserBySearch(search);
        model.addAttribute("userList",userList);
        model.addAttribute("sectionName","搜索用户");
        return "user_search_list";
    }
}

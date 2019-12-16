package scu.cj.community.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import scu.cj.community.cache.TagCache;
import scu.cj.community.dto.PaginationDTO;
import scu.cj.community.model.Question;
import scu.cj.community.model.QuestionRepresent;
import scu.cj.community.model.User;
import scu.cj.community.service.NotificationService;
import scu.cj.community.service.QuestionService;
import scu.cj.community.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lkk
 * @date : 14:21 2019/12/16
 * @creed: Talk is cheap,show me the code
 */
@Controller
public class BackstageController {

    @Autowired
    private UserService userService;


    @Autowired
    private QuestionService questionService;



    @GetMapping("/backstage")
    public String toBackstage(){
        return  "/backstage.html";
    }


    @GetMapping("/backstage/{action}")
    public String getInfor(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          Model model) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        if ("manageUser".equals(action)) {
            model.addAttribute("section", "manageUser");
            model.addAttribute("sectionName", "用户管理");
            List<User> users = userService.findAllUser();
            model.addAttribute("users",users);

        } else if ("manageQuestion".equals(action)) {
            model.addAttribute("section", "manageQuestion");
            model.addAttribute("sectionName", "话题管理");
            List<QuestionRepresent> questions = questionService.getAllQuestion();
            model.addAttribute("questions",questions);
        }

        return "/backstage";
    }

    @DeleteMapping("/backstage/{action}/{id}")
    public String deleteQuestion( HttpServletRequest request,
                           @PathVariable(name = "action") String action,
                           @PathVariable(name = "id")Long id,
                           Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        if ("manageQuestion".equals(action)) {
//            model.addAttribute("section", "manageQuestion");
//            model.addAttribute("sectionName", "话题管理");
//            List<QuestionRepresent> questions = questionService.getAllQuestion();
//            model.addAttribute("questions",questions);
            questionService.deleteById(id);
            System.out.println("yes");
            System.out.println(id);
            return "redirect:/backstage/manageQuestion";
        }

        return "redirect:/backstage";
    }

    @PostMapping("/backstage/{action}/{id}/{situation}")
    public String updateRecommand( HttpServletRequest request,
                           @PathVariable(name = "action") String action,
                           @PathVariable(name = "id")Long id,
                           @PathVariable(name = "situation") String recommand,
                           Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        if ("manageQuestion".equals(action)) {
            if (recommand.equals("0")){
                questionService.updateRecommandById(id,"1");

            }
            else{
                questionService.updateRecommandById(id,"0");

            }
//            model.addAttribute("section", "manageQuestion");
//            model.addAttribute("sectionName", "话题管理");
//            List<QuestionRepresent> questions = questionService.getAllQuestion();
//            model.addAttribute("questions",questions);
//            questionService.deleteById(id);
//            System.out.println("yes");
//            System.out.println(id);
            return "redirect:/backstage/manageQuestion";
        }

        return "redirect:/backstage";
    }

    @GetMapping("/edit/{id}")
    public  String toEdit(  @PathVariable(name = "id")Long id,
                            Model model){

        User user = userService.getUserById(id);
        model.addAttribute("id",user.getId());
        model.addAttribute("name",user.getName());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("bio",user.getBio());

        return  "/editUserInfor.html";
    }

    @PostMapping("/edit")
    public String doEdit(
            @RequestParam(value = "register-username", required = false) String name,
            @RequestParam(value = "register-password", required = false) String password,
            @RequestParam(value = "register-passwords", required = false) String passwords,
            @RequestParam(value = "bio", required = false) String bio,
            @RequestParam(value = "id", required = false) Long id,
            HttpServletRequest request,
            Model model) {

        User user = userService.getUserById(id);
        model.addAttribute("id",user.getId());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("name",user.getName());
        model.addAttribute("bio",user.getBio());

        if (name.length()<2 || name.length()>10) {
            model.addAttribute("error", "用户名不正确");
            return "/editUserInfor.html";
        }
        if (password.length()<6 ||password.length()>10) {
            model.addAttribute("error", "密码不正确");
            return "/editUserInfor.html";
        }
        if (!password.equals(passwords)) {
            model.addAttribute("error", "两次输入的密码不相同");
            return "/editUserInfor.html";
        }
        userService.updateUserInfo(name,password,bio,id);

        return "redirect:/backstage/manageUser";
    }


}

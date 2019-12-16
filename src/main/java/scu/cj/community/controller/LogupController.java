package scu.cj.community.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import scu.cj.community.dto.ResultDTO;
import scu.cj.community.exception.CustomizeErrorCode;
import scu.cj.community.model.User;
import scu.cj.community.service.UserService;
import scu.cj.community.utils.TokenProccessor;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author : lkk
 * @date : 18:56 2019/12/15
 * @creed: Talk is cheap,show me the code
 */
@Controller
public class LogupController {

    @Autowired
    private UserService userService;

    @GetMapping("/logup")
    public String toLogUp(){
        return "/logup.html";
    }

    @ResponseBody
    @PostMapping("/logup")
    public Object logUp(@RequestBody String s, Model model){

        System.out.println(s);
        Map<String, Object> mapdata = JSONObject.parseObject(s);

        User user = new User();
        user.setName((String) mapdata.get("name"));
        user.setPassword((String) mapdata.get("password"));
        user.setStudentId((String) mapdata.get("id"));
        user.setToken(TokenProccessor.getInstance().makeToken());
        String [] userImage = {
                "https://b-ssl.duitang.com/uploads/item/201807/14/20180714190256_ycylw.jpeg",
                "http://img.duoziwang.com/2018/13/03181135670321.jpg",
                "https://b-ssl.duitang.com/uploads/item/201806/12/20180612192153_cjoyb.thumb.700_0.jpg",
                "http://img.jk51.com/img_jk51/370477306.jpeg",
                "http://b-ssl.duitang.com/uploads/item/201605/24/20160524182828_VAyhZ.jpeg",
                "http://b-ssl.duitang.com/uploads/item/201605/24/20160524182836_e2R3B.jpeg"
        };
        //随机生成头像
        user.setAvatarUrl(userImage[new Random().nextInt(5)]);
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        user.setIsSuper("0");

        if(!userService.findIfStudentIdExits(user.getStudentId())){
//            model.addAttribute("error","用户ID已经存在");
//            System.out.println("出错");
            return ResultDTO.errorOf(CustomizeErrorCode.USER_EXITS);
        }
        else{
            userService.insertNewUser(user);
            return ResultDTO.okOf();
        }

    }
}

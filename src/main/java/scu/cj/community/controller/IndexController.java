package scu.cj.community.controller;

import scu.cj.community.cache.HotTagCache;
import scu.cj.community.dto.PaginationDTO;
import scu.cj.community.model.Question;
import scu.cj.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private HotTagCache hotTagCache;


    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "10") Integer size,
                        @RequestParam(name = "search", required = false) String search,
                        @RequestParam(name = "tag", required = false) String tag,
                        @RequestParam(name = "sort", required = false) String sort,
                        HttpServletResponse response) {
        PaginationDTO pagination = questionService.list(search, tag, sort, page, size);
        List<Question> recommands = questionService.getRecommand();
        List<String> tags = hotTagCache.getHots();
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        model.addAttribute("tag", tag);
        model.addAttribute("recommands",recommands);
        model.addAttribute("tags", tags);
        model.addAttribute("sort", sort);
        return "index";
    }
}

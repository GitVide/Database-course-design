package scu.cj.community.cache;

import scu.cj.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("javascript", "php", "css", "html", "html5", "java", "node.js", "python", "c++", "c", "golang", "objective-c", "typescript", "shell", "swift", "c#", "sass", "ruby", "bash", "less", "asp.net", "lua", "scala", "coffeescript", "actionscript", "rust", "erlang", "perl"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("学习");
        framework.setTags(Arrays.asList("考研", "考博", "四级", "六级", "CSP等级考试", "期末考试", "大作业分享", "计算机等级考试", "英语", "数学","文学","历史","经验"));
        tagDTOS.add(framework);


        TagDTO server = new TagDTO();
        server.setCategoryName("社交");
        server.setTags(Arrays.asList("约自习", "经验分享", "寻人", "找女朋友", "找男朋友", "找大神", "交友","实事讨论"));
        tagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("专业");
        db.setTags(Arrays.asList("计算机/软件", "数学", "英语", "文新", "建环", "经济", "商", "水利", "制造"));
        tagDTOS.add(db);

        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> StringUtils.isBlank(t) || !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }

    public static void main(String[] args) {
        int i = (5 - 1) >>> 1;
        System.out.println(i);
    }
}

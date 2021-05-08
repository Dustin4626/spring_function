package springboot_cors.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);


    @RequestMapping("/index")
    public String index(Model model) {
        return "goods";
    }

    @RequestMapping("/web/jsonp")
    public @ResponseBody Object jsonp() {
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v3");
        return "handleResponse({\"k1\":\"v1\",\"k2\":\"v3\"})";
    }

    @RequestMapping("/web/test")
    public @ResponseBody Object test() {
        return "666";
    }
    
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @RequestMapping("/web/page")
    public String page() {
        //int a = 10 / 0; //抛出异常，显示一个背景白色的错误页面，不是很友好
        //return "page";
        return null;
    }
}

package cn.huangzijian888.smstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

/**
 * @author huangzijian888
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

}

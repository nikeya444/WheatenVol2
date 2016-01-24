package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 04.05.15
 * Time: 23:17
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String defaultPage() {
        return "index";
    }
}

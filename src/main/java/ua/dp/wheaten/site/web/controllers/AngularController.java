package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kkm on 20.02.2016.
 */
@Controller
@RequestMapping(value = "ng")
public class AngularController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "ng/index";
    }

}

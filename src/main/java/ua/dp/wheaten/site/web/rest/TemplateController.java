package ua.dp.wheaten.site.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kkm on 23.02.2016.
 */
@Controller
public class TemplateController {
    @RequestMapping(value = "document", method = RequestMethod.GET)
    public String getDocumentsTemplate() {
        return "template/documents";
    }
}

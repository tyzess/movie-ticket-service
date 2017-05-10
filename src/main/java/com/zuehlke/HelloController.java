package com.zuehlke;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by urzy on 10.05.2017.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        return "Hello World!";
    }
}

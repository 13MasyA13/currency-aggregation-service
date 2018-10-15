package ua.holyk.springboot.currencyaggregationservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class needed to visualise index.html
 */
@Controller
public class IndexController {

    /**
     * This method allows you to visualise index.html
     * @return index.html
     */
    @RequestMapping("/")
    public String index(){
        return "forward:/index.html";
    }
}

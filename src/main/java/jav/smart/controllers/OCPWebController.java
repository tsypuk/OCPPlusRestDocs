package jav.smart.controllers;

import jav.smart.service.LoadOcpDumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by roman.tsypuk on 6/4/16.
 */
@Controller
public class OCPWebController {
    @Autowired
    private LoadOcpDumper loadOcpDump;

    @RequestMapping("/greeting/{id}")
    public ModelAndView greeting(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting");
        modelAndView.addObject("question", loadOcpDump.loadQuestion(id).getText());
        modelAndView.addObject("answers", loadOcpDump.loadQuestion(id).getAnswers());
        modelAndView.addObject("explain", loadOcpDump.loadQuestion(id).getDescription());
        return modelAndView;
    }
}
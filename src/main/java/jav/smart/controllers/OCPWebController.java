package jav.smart.controllers;

import jav.smart.model.Question;
import jav.smart.service.LoadOcpDumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView greeting(@PathVariable("id") int id, Model model) {
//        model.addAttribute("name", loadOcpDump.loadQuestion(1).getText());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greeting");

        mav.addObject("question", loadOcpDump.loadQuestion(id).getText());
        mav.addObject("answers", loadOcpDump.loadQuestion(id).getAnswers());
        mav.addObject("explain", loadOcpDump.loadQuestion(id).getDescription());
        return mav;
    }
}
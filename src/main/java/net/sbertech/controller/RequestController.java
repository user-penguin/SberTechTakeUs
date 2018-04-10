package net.sbertech.controller;


import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import logic.*;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class RequestController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public String addStudent(@RequestParam("id") int identify, @RequestParam("probability") double prob,
                             ModelMap model) {

        Starter starter = new Starter();
        ArrayList<AssocInterval> result;
        ArrayList<AssocInterval> errlist = new ArrayList<AssocInterval>();

        try{
            result = starter.main(identify, prob);
            String json = new Gson().toJson(result);
            if(result.isEmpty())
                return "error_page";
            else{
                model.addAttribute("id", json);
                return "out";
            }

        }
        catch(IOException e){
            System.out.println(e.toString());
        }


        return "index";
    }
}

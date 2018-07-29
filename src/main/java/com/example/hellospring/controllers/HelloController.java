package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");
        return "Hello " + name;
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodBye(){
        return "GoodBye";
    }

    @RequestMapping(value="hello", method =RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest req){
        String name = req.getParameter("name");
        return "Hello, " + name;
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

    @RequestMapping(value = "language", method = RequestMethod.GET)
    @ResponseBody
    public String helloLanguageForm(){
        String html = "<form method = 'post'>" +
                "<input type='text' name = 'name'/>" +
                "<select name='lang'>" +
                "<option>English</option>" +
                "<option>French</option>" +
                "<option>German</option>" +
                "<option>Serbian</option>" +
                "<Option>Italian</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me'/>"+
                "</input>";
        return html;
    }

    @RequestMapping(value ="language", method = RequestMethod.POST)
    @ResponseBody
    public static String helloLanguage(HttpServletRequest req){
        String name = req.getParameter("name");
        String language = req.getParameter("lang");
        return createMessage(name, language);
    }

    public static String createMessage(String name, String language){
        String greet = "";
        switch (language){
            case "English": greet = "Hello " + name;
                             break;
            case "French": greet = "Bonjour " + name;
                            break;
            case "German": greet = "Guten tag " + name;
                            break;
            case "Serbian": greet = "Zdravo " + name;
                            break;
            case "Italian": greet = "Ciao " + name;
                            break;
            default:break;
        }
        return greet;
    }

    
}

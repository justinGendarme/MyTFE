package com.example.MyTFE.controllers;

import com.example.MyTFE.model.DAO.DiabeticDAO;
import com.example.MyTFE.model.bean.LoginForm;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {
    //to get login form page
    @RequestMapping(value="login", method= RequestMethod.GET)
    public String getLoginForm(){
        //return html page name
        return "loginPage";
    }

    //checking for login credentials
    @RequestMapping(value="login", method= RequestMethod.POST)
    public String login(@ModelAttribute (name="loginForm")LoginForm loginForm, Model model) {
        String mail= loginForm.getMail();
        String mdp = loginForm.getMdp();

        DiabeticDAO dia = new DiabeticDAO();
        if(dia.loggin(mail,mdp))
        {
            return "home";
        }
        else
        {
            return "firstPage";
        }
    }
}

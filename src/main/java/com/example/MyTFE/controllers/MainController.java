package com.example.MyTFE.controllers;

import com.example.MyTFE.model.DAO.DiabeticDAO;
import com.example.MyTFE.model.DAO.DoctorDAO;
import com.example.MyTFE.model.DAO.HelpDAO;
import com.example.MyTFE.model.DAO.InjectionDAO;
import com.example.MyTFE.model.Diabetic;
import com.example.MyTFE.model.Doctor;
import com.example.MyTFE.model.Help;
import com.example.MyTFE.model.bean.InscriptCheck;
import com.example.MyTFE.model.bean.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    DiabeticDAO diaDao;

    @Autowired
    DoctorDAO docDAO;

    @Autowired
    HelpDAO helpDAO;

    @Autowired
    InjectionDAO injDAO;



    @GetMapping("/")
    public String firstPage(){
        return "firstPage";
    }

    @GetMapping("/newDiab")
    public String inscriptionForm(Model model){
        List<Doctor> listDoc = docDAO.getAllDoct();
        model.addAttribute("listDoc",listDoc);
        return "inscriptionForm";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "loginPage";
    }


    @GetMapping("/help")
    public String helpPage(Model model){
        List<Help> listHelp = helpDAO.getAllHelp();
        model.addAttribute("listHelp",listHelp);
        return "help";
    }



    @RequestMapping(value="/authentification", method= RequestMethod.POST)
    public ModelAndView logData(LoginForm lgf){
        ModelAndView mv = new ModelAndView(home());
        if(!diaDao.loggin(lgf.getMail(), lgf.getMdp()))
        {
            mv.setViewName(loginPage());

        }
            return mv;

    }

    @RequestMapping(value="/inscription", method= RequestMethod.POST)
    public ModelAndView ins(InscriptCheck inscriptCheck) {
        ModelAndView mv = new ModelAndView(home());
        return mv;
    }
    /*
    @RequestMapping(value="/inscription", method= RequestMethod.POST)
        public void ins(InscriptCheck inscriptCheck) {
        inscriptCheck.toString();

        /*if(inscriptCheck.checkAll().size()==0)
        {
            mv.setViewName(loginPage());
            System.out.println("TEST UN");
        }
        else{
            mv.setViewName(loginPage());
            System.out.println("TEST DEUX");
            mv.addObject(inscriptCheck);
            System.out.println("TEST TROIS");
        }
        //return mv;

    }*/




    @GetMapping("/add")
    public String addDiab(){

        Diabetic di = new Diabetic(4,8,"nameTest","firstnTest",
                Date.valueOf("2007-02-07"),"test@gamail.com","mdp123",
                "0476276735","027331528","205 avenue des test");
        diaDao.addDiab(di);
        return "home";
    }

    @GetMapping("/del")
    public String delDia(){

        diaDao.delDiab(3);

        return "home";
    }

}

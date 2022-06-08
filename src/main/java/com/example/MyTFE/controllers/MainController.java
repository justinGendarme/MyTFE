package com.example.MyTFE.controllers;

import com.example.MyTFE.model.DAO.DiabeticDAO;
import com.example.MyTFE.model.DAO.DoctorDAO;
import com.example.MyTFE.model.DAO.HelpDAO;
import com.example.MyTFE.model.DAO.InjectionDAO;
import com.example.MyTFE.model.Diabetic;
import com.example.MyTFE.model.Doctor;
import com.example.MyTFE.model.Help;
import com.example.MyTFE.model.Injection;
import com.example.MyTFE.model.bean.InjForm;
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
import java.util.LinkedList;
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

/*
@GetMapping("/help")
    public String helpPage(Model model){
        List<Help> listHelp = helpDAO.getAllHelp();
        model.addAttribute("listHelp",listHelp);
        return "help";
    }
 */

   @GetMapping("/")
    public String firstPage(){
        return "firstPage";
    }

    @GetMapping("/newInjForm")
    public String newInjForm(){
       return "newInjForm";
    }

    @GetMapping("/newDocForm")
    public String newDocForm(){
        return "newDocForm";
    }


    @RequestMapping("/MyInjections")
    public String MyInjections(Model model){
        List <Injection> myInj = injDAO.getAllInjFromIdDia(1);//MOD:
        System.out.println("TEST DEUx");
        System.out.println(myInj.toString());

        model.addAttribute("myInj",myInj);
       return "myInjections";
    }

    @GetMapping("/myDoctorProfil")
    public String myDoctorProfil(Model model)
    {
        Doctor myDoc = docDAO.getDoctorById(1);//MOD:Ajouter id utilisateur courant
        model.addAttribute("myDoc",myDoc);
        return "myDoctorProfil";
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

    // Login form
    @RequestMapping("/loginPage.html")
    public String login() {
        return "loginPage.html";
    }
    @GetMapping("/loginPage")
    public String loginPage(){
        return "loginPage";
    }

    @GetMapping("/inscriptionForm")
    public String inscriptionForm() { return "inscriptionForm"; }


    @GetMapping("/help")
    public String helpPage(Model model){
        List<Help> listHelp = helpDAO.getAllHelp();
        model.addAttribute("listHelp",listHelp);
        return "help";
    }



    @RequestMapping(value="/delInj", method= RequestMethod.POST)
    public ModelAndView delinject(Injection injection){
        ModelAndView mv = new ModelAndView(home());
        mv.setViewName("MyInjections");

        return mv;

    }

    @RequestMapping(value="/authentification", method= RequestMethod.POST)
    public ModelAndView logData(LoginForm lgf){
        ModelAndView mv = new ModelAndView(home());
        if(!diaDao.loggin(lgf.getMail(), lgf.getMdp()))
        {
            //mv.setViewName(loginPage());


        }
            return mv;

    }
    @RequestMapping(value="/addInjection", method= RequestMethod.POST)
    public ModelAndView addInj(InjForm injForm){
        ModelAndView mv = new ModelAndView(home());
        Injection injection = new Injection();
        injection.setDate(injForm.getDate());
        injection.setDay(injForm.getDay());
        injection.setComment(injForm.getComment());
        injection.setId_diabetic(1);//MOD:


        //Test
        if(injForm.getTestTime().equals("wakeUp"))
            injection.setWakeupTest(injForm.getTestVal());
        if(injForm.getTestTime().equals("morning"))
            injection.setMorningTest(injForm.getTestVal());
        if(injForm.getTestTime().equals("midday"))
            injection.setMiddayTest(injForm.getTestVal());
        if(injForm.getTestTime().equals("afternoon"))
            injection.setAfternoonTest(injForm.getTestVal());
        if(injForm.getTestTime().equals("supper"))
            injection.setSupperTest(injForm.getTestVal());
        if(injForm.getTestTime().equals("sleep"))
            injection.setSleepTest(injForm.getTestVal());
        if(injForm.getTestTime().equals("night"))
            injection.setNightTest(injForm.getTestVal());

        //Dose
        if(injForm.getDoseTime().equals("morning"))
            injection.setMorningDose(injForm.getDoseVal());
        if(injForm.getDoseTime().equals("midday"))
            injection.setMiddayDose(injForm.getDoseVal());
        if(injForm.getDoseTime().equals("supper"))
            injection.setSupperDose(injForm.getDoseVal());
        if(injForm.getDoseTime().equals("sleep"))
            injection.setSleepDose(injForm.getDoseVal());



        //verifier si l'injection n'existe pas deja
        List<Injection> listInj = injDAO.getAllInjFromIdDia(1);//MOD:
        System.out.println("Contenu de la liste d'injection du diabetic 1:");
        System.out.println(listInj.toString());
        System.out.println("injection from form:");
        System.out.println(injection.toString());
        System.out.println("--------------");


        if(injDAO.checkInjExist(listInj,injection.getDate()))
        {
            System.out.println("Injection exist");
            injDAO.editInj(injection,1);
            mv.setViewName("MyInjections");
            return mv;

        }
        else
        {
            System.out.println("Injection exist pas");
            injDAO.addInj(injection);
            mv.setViewName("MyInjections");
            return mv;
        }

    }


    @RequestMapping(value="/inscription", method= RequestMethod.POST)
    public ModelAndView ins(InscriptCheck inscriptCheck) {
        System.out.println("TTEESSTT");//ok
        System.out.println(inscriptCheck.toString());//ok
        ModelAndView mv = new ModelAndView(home());
        List lst = new LinkedList();
        if(inscriptCheck.getPassword().equals(inscriptCheck.getPassword2()))
        {
            if((inscriptCheck.getFirstname()).equals(""))
            {
                lst.add("Firstname is missing");
            }
            if((inscriptCheck.getName()).equals(""))
            {
                lst.add("Lastname is missing");
            }

            if(inscriptCheck.getMail().equals(""))
            {
                lst.add("mail adresse is missing");
            }

            if(inscriptCheck.getPassword().equals("")) {
                lst.add("first password is missing");
            }

            if(inscriptCheck.getPassword2().equals(""))
            {
                lst.add("second password is missing");
            }

            if(inscriptCheck.getBirthdate().equals(null))
            {
                lst.add("date of birth is missing");
            }
            if(inscriptCheck.getPhone().equals(""))
            {
                lst.add("phone numer is missing");
            }
            if(inscriptCheck.getEmergencyContact().equals(""))
            {
                lst.add("emergency contact is missing");
            }
            if(inscriptCheck.getAddress().equals(""))
            {
                lst.add("adresse is mising"+ "\n");
            }
        }
        else{
            System.out.println("pas ok");
            lst.add("The first and second password are not the same"+ "\n");
        }

        if(!lst.isEmpty())
        {
            mv.setViewName(inscriptionForm());
        }

        Diabetic newDia = new Diabetic();
        //ModelAndView mv = new ModelAndView(home());
        //mv.addObject("insCk",inscriptCheck);
        mv.addObject("er",lst);
        return mv;
    }

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

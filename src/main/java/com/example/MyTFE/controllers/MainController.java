package com.example.MyTFE.controllers;

import com.example.MyTFE.model.DAO.*;
import com.example.MyTFE.model.Diabetic;
import com.example.MyTFE.model.Doctor;
import com.example.MyTFE.model.Help;
import com.example.MyTFE.model.Injection;
import com.example.MyTFE.model.bean.InjForm;
import com.example.MyTFE.model.bean.InscriptCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
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

    @Autowired
    ReminderDAO remDAO;


    public int getUserId(){
        int id=0;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            Diabetic diabetic=diaDao.getDiaByMail(username);
            id=diabetic.getId_diabetic();
            return id;
        } else {
            String username = principal.toString();
            Diabetic diabetic=diaDao.getDiaByMail(username);
            id=diabetic.getId_diabetic();
            return id;
        }
    }
   @GetMapping("/")
    public String firstPage(){
        return "firstPage";
    }


    @RequestMapping(value = "/userOnly/menu", method = RequestMethod.GET)
    public String menu() {
        return "userOnly/menu";
    }
    @RequestMapping(value = "/userOnly/newDocForm", method = RequestMethod.GET)
    public String newDocForm() {
        return "userOnly/newDocForm";
    }
    @RequestMapping(value = "/userOnly/navbar", method = RequestMethod.GET)
    public String navbar() {
        return "userOnly/navbar";
    }

    ///userOnly/addReminder
    @RequestMapping(value = "/userOnly/addReminder", method = RequestMethod.GET)
    public String addReminder() {
        return "userOnly/addReminder";
    }


    @GetMapping("/userOnly/newInjForm")
    public String newInjForm(){
       return "userOnly/newInjForm";
    }

    @GetMapping("/userOnly/MyInjections")
    public String MyInjections(Model model){
        int id=this.getUserId();
        List <Injection> myInj = injDAO.getAllInjFromIdDia(id);
        model.addAttribute("myInj",myInj);
       return "userOnly/MyInjections";
    }


    @GetMapping("/userOnly/myDoctorProfil")
    public String myDoctorProfil(Model model)
    {
        int id=this.getUserId();
        Doctor myDoc = docDAO.getDoctorById(id);
        model.addAttribute("myDoc",myDoc);
        return "userOnly/myDoctorProfil";
    }

    @GetMapping("/userOnly/profil")
    public String myProfil(Model model)
    {
        int id=this.getUserId();
        Diabetic dia = diaDao.getDiabById(id);
        model.addAttribute("myself",dia);
        return "userOnly/profil";
    }

    @GetMapping("/userOnly/home")
    public String home(Model model)
    {
        int id=this.getUserId();
        List lstRem=remDAO.getAllReminderFromUser(id);
        model.addAttribute("lrm",lstRem);

        //datej = 7 day before
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now().minusDays(7);
        java.util.Date datej = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());


        model.addAttribute("td",datej);
        return "userOnly/home";
    }
    @GetMapping("/inscriptionForm")
    public ModelAndView inscriptionForm(){
        List<Doctor> listDoc = docDAO.getAllDoct();
        ModelAndView mv = new ModelAndView();
        mv.addObject("listDoc",listDoc);
        return mv;
    }



    @GetMapping("/help")
    public String helpPage(Model model){
        List<Help> listHelp = helpDAO.getAllHelp();
        model.addAttribute("listHelp",listHelp);
        return "help";
    }

    @GetMapping(value="/delInj/{idIj}")
    public String delinject(@PathVariable int idIj){
        System.out.println(idIj);
        injDAO.delInj(idIj);

        return "redirect:/userOnly/MyInjections";

    }



    @RequestMapping(value="/addInjection", method= RequestMethod.POST)
    public ModelAndView addInj(InjForm injForm){
        ModelAndView mv = new ModelAndView();
        Injection injection = new Injection();
        injection.setDate(injForm.getDate());
        injection.setDay(injForm.getDay());
        injection.setComment(injForm.getComment());
        int id=this.getUserId();
        injection.setId_diabetic(id);


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
            injDAO.editInj(injection,1);//MOD
            mv.setViewName("userOnly/MyInjections");
            return mv;

        }
        else
        {
            System.out.println("Injection exist pas");
            injDAO.addInj(injection);
            mv.setViewName("userOnly/MyInjections");
            return mv;
        }

    }



    @RequestMapping(value="/inscription", method= RequestMethod.POST)
    public ModelAndView ins(InscriptCheck inscriptCheck) {
        System.out.println("TTEESSTT");//ok
        System.out.println(inscriptCheck.toString());//ok
        ModelAndView mv = new ModelAndView();
        List lst = new LinkedList();
        Diabetic newDia = new Diabetic();
        //TEST Password SECURITY
        int passLenght=8,upChars=0,lowChars=0;
        int special=0,digits=0;
        char ch;
        String psw=inscriptCheck.getPassword();
        int total=psw.length();
        if(total<passLenght)
        {
            lst.add("Password lenght must be beetween 8 and 16");
        }
        else
        {
            for(int i=0; i<total; i++)
            {
                ch= psw.charAt(i);
                if(Character.isUpperCase(ch))
                    upChars=1;
                else if(Character.isLowerCase(ch))
                    lowChars = 1;
                else if(Character.isDigit(ch))
                    digits = 1;
                else
                    special=1;
            }
        }
        if(upChars != 1 && lowChars != 1 && digits!=1 && special!=1)
            lst.add("This password isn't strong enough");

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
                lst.add("mail address is missing");
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
                lst.add("phone number is missing");
            }
            if(inscriptCheck.getEmergencyContact().equals(""))
            {
                lst.add("emergency contact is missing");
            }
            if(inscriptCheck.getAddress().equals(""))
            {
                lst.add("address is missing"+ "\n");
            }
        }
        else{
            System.out.println("pas ok");
            lst.add("The first and second password are not the same"+ "\n");
        }

        if(!lst.isEmpty())
        {
            mv.setViewName("inscriptionForm");
            mv.addObject("er",lst);
            return mv;
        }

        mv.setViewName(menu());
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

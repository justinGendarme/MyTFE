package com.example.MyTFE.model.bean;

public class LoginForm {

    private String mail;
    private String mdp;


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "mail='" + mail + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}

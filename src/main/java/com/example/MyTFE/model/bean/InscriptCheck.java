package com.example.MyTFE.model.bean;

import java.sql.Date;

public class InscriptCheck {

    private int id_diabetic;
    private int id_doctor;
    private String name;
    private String firstname;
    private Date birthdate;
    private String mail;
    private String password;
    private String password2;
    private String phone;
    private String emergencyContact;
    private String address;


    public int getId_diabetic() {
        return id_diabetic;
    }

    public void setId_diabetic(int id_diabetic) {
        this.id_diabetic = id_diabetic;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    @Override
    public String toString() {
        return "InscriptCheck{" +
                "id_diabetic=" + id_diabetic +
                ", id_doctor=" + id_doctor +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", birthdate=" + birthdate +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                ", phone='" + phone + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

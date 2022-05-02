package com.example.MyTFE.model;

import java.sql.Date;

public class Diabetic {


    private int id_diabetic;
    private int id_doctor;
    private String name;
    private String firstname;
    private Date birthdate;
    private String mail;
    private String password;
    private String phone;
    private String emergencyContact;
    private String address;

    public Diabetic() {
    }

    public Diabetic(int id_diabetic, int id_doctor, String name, String firstname, Date birthdate,
                    String mail, String password, String phone, String emergencyContact, String address) {
        this.id_diabetic = id_diabetic;
        this.id_doctor = id_doctor;
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.emergencyContact = emergencyContact;
        this.address = address;
    }

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
}

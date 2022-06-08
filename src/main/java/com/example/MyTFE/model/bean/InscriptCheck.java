package com.example.MyTFE.model.bean;

import java.sql.Date;
import java.util.List;

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
    private List<String> errorList;


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

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
/*
    public InscriptCheck(int id_diabetic, int id_doctor, String name,
                         String firstname, Date birthdate, String mail,
                         String password, String password2, String phone,
                         String emergencyContact, String address, List<String> errorList) {
        this.id_diabetic = id_diabetic;
        this.id_doctor = id_doctor;
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.mail = mail;
        this.password = password;
        this.password2 = password2;
        this.phone = phone;
        this.emergencyContact = emergencyContact;
        this.address = address;
        this.errorList = errorList;
    }*/

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
                ", errorList=" + errorList +
                '}';
    }

    public void checkAll()
    {
        if(!this.password.equals(this.password2))
        {
            this.errorList.add("you haven't used the same password twice");
        }
        int passwordLength=8, upChars=0, lowChars=0;
        int special=0, digits=0;
        char ch;
        String password = this.password;

        int total = password.length();
        if(total<passwordLength)
        {
            this.errorList.add("The Password's Length has to be of 8 characters or more.");

        }
        else
        {
            for(int i=0; i<total; i++)
            {
                ch = password.charAt(i);
                if(Character.isUpperCase(ch))
                    upChars++;
                else if(Character.isLowerCase(ch))
                    lowChars++;
                else if(Character.isDigit(ch))
                    digits++;
                else
                {
                    if(ch=='<' || ch=='>')
                    {
                        this.errorList.add("The Password is Malicious!");
                    }
                    else
                        special++;
                }
            }
        }
        if(upChars!=0 && lowChars!=0 && digits!=0 && special!=0)
        {
            if(total>=12)
            {
                System.out.println("\nThe Strength of Password is Strong.");
            }
            else
            {
                System.out.println("\nThe Strength of Password is Medium.");
            }
            System.out.println("\n----The Password Contains----");
            System.out.println("UpperCase Character: " +upChars);
            System.out.println("LowerCase Character: " +lowChars);
            System.out.println("Digit: " +digits);
            System.out.println("Special Character: " +special);
        }
        else
        {
            if(upChars==0)
            {
                this.errorList.add("The Password must contain at least one uppercase character.");
            }

            if(lowChars==0)
            {
                this.errorList.add("The Password must contain at least one lowercase character.");
            }
            if(digits==0)
            {
                this.errorList.add("The Password must contain at least one digit.");
            }
            if(special==0)
            {
                this.errorList.add("The Password must contain at least one special character.");
            }
        }

    }
}

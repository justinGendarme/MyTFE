package com.example.MyTFE.model;

import java.sql.Date;

public class Reminder {

    private int id_reminder;
    private int id_doctor;
    private int id_diabetic;
    private Date date;
    private String description;

    public Reminder() {
    }

    public Reminder(int id_reminder, int id_doctor, int id_diabetic, Date date, String description) {
        this.id_reminder = id_reminder;
        this.id_doctor = id_doctor;
        this.id_diabetic = id_diabetic;
        this.date = date;
        this.description = description;
    }

    public int getId_reminder() {
        return id_reminder;
    }

    public void setId_reminder(int id_reminder) {
        this.id_reminder = id_reminder;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public int getId_diabetic() {
        return id_diabetic;
    }

    public void setId_diabetic(int id_diabetic) {
        this.id_diabetic = id_diabetic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

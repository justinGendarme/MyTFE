package com.example.MyTFE.model;

import java.sql.Date;

public class Injection {

    private int id_injection;
    private int id_diabetic;
    private Date date;
    private String day;
    private int wakeupTest;
    private String morningDose;
    private int morningTest;
    private int middayTest;
    private String middayDose;
    private int afternoonTest;
    private int supperTest;
    private String supperDose;
    private int eveningTest;
    private int sleepTest;
    private String sleepDose;
    private int nightTest;
    private String comment;

    public Injection()
    {}
    public Injection(int id_injection, int id_diabetic, Date date, String day, int wakeupTest, String morningDose, int morningTest, int middayTest, String middayDose, int afternoonTest, int supperTest, String supperDose, int eveningTest, int sleepTest, String sleepDose, int nightTest, String comment) {
        this.id_injection = id_injection;
        this.id_diabetic = id_diabetic;
        this.date = date;
        this.day = day;
        this.wakeupTest = wakeupTest;
        this.morningDose = morningDose;
        this.morningTest = morningTest;
        this.middayTest = middayTest;
        this.middayDose = middayDose;
        this.afternoonTest = afternoonTest;
        this.supperTest = supperTest;
        this.supperDose = supperDose;
        this.eveningTest = eveningTest;
        this.sleepTest = sleepTest;
        this.sleepDose = sleepDose;
        this.nightTest = nightTest;
        this.comment = comment;
    }

    public int getId_injection() {
        return id_injection;
    }

    public void setId_injection(int id_injection) {
        this.id_injection = id_injection;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getWakeupTest() {
        return wakeupTest;
    }

    public void setWakeupTest(int wakeupTest) {
        this.wakeupTest = wakeupTest;
    }

    public String getMorningDose() {
        return morningDose;
    }

    public void setMorningDose(String morningDose) {
        this.morningDose = morningDose;
    }

    public int getMorningTest() {
        return morningTest;
    }

    public void setMorningTest(int morningTest) {
        this.morningTest = morningTest;
    }

    public int getMiddayTest() {
        return middayTest;
    }

    public void setMiddayTest(int middayTest) {
        this.middayTest = middayTest;
    }

    public String getMiddayDose() {
        return middayDose;
    }

    public void setMiddayDose(String middayDose) {
        this.middayDose = middayDose;
    }

    public int getAfternoonTest() {
        return afternoonTest;
    }

    public void setAfternoonTest(int afternoonTest) {
        this.afternoonTest = afternoonTest;
    }

    public int getSupperTest() {
        return supperTest;
    }

    public void setSupperTest(int supperTest) {
        this.supperTest = supperTest;
    }

    public String getSupperDose() {
        return supperDose;
    }

    public void setSupperDose(String supperDose) {
        this.supperDose = supperDose;
    }

    public int getEveningTest() {
        return eveningTest;
    }

    public void setEveningTest(int eveningTest) {
        this.eveningTest = eveningTest;
    }

    public int getSleepTest() {
        return sleepTest;
    }

    public void setSleepTest(int sleepTest) {
        this.sleepTest = sleepTest;
    }

    public String getSleepDose() {
        return sleepDose;
    }

    public void setSleepDose(String sleepDose) {
        this.sleepDose = sleepDose;
    }

    public int getNightTest() {
        return nightTest;
    }

    public void setNightTest(int nightTest) {
        this.nightTest = nightTest;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

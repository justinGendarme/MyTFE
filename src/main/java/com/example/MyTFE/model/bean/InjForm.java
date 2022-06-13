package com.example.MyTFE.model.bean;

import java.sql.Date;
public class InjForm {

    private int id_injection;
    private Date date;
    private String day;
    private String testTime;
    private int testVal;
    private String doseTime;
    private String doseVal;
    private String comment;

    public int getId_injection() {
        return id_injection;
    }

    public void setId_injection(int id_injection) {
        this.id_injection = id_injection;
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

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public int getTestVal() {
        return testVal;
    }

    public void setTestVal(int testVal) {
        this.testVal = testVal;
    }

    public String getDoseTime() {
        return doseTime;
    }

    public void setDoseTime(String doseTime) {
        this.doseTime = doseTime;
    }

    public String getDoseVal() {
        return doseVal;
    }

    public void setDoseVal(String doseVal) {
        this.doseVal = doseVal;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "InjForm{" +
                "id_injection=" + id_injection +
                ", date=" + date +
                ", day='" + day + '\'' +
                ", testTime='" + testTime + '\'' +
                ", testVal=" + testVal +
                ", doseTime='" + doseTime + '\'' +
                ", doseVal='" + doseVal + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}

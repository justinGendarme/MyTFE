package com.example.MyTFE.model;

import java.sql.Date;

public class Periodic_review {

    private int id_review;
    private int id_diabetic;
    private int id_doctor;
    private Date date;
    private float weight;
    private float arterialPressure;
    private float cholesterol;
    private float hdlcholesterol;
    private float triglycerides;
    private float urea;
    private float creatinine;
    private float glycatedHemoglobin;
    private float proteinuria;
    private float microalbuminuria;
    private String eyeFluangiography;
    private String other;

    public Periodic_review() {
    }

    public Periodic_review(int id_review, int id_diabetic, int id_doctor, Date date, float weight, float arterialPressure, float cholesterol, float hdlcholesterol, float triglycerides, float urea, float creatinine, float glycatedHemoglobin, float proteinuria, float microalbuminuria, String eyeFluangiography, String other) {
        this.id_review = id_review;
        this.id_diabetic = id_diabetic;
        this.id_doctor = id_doctor;
        this.date = date;
        this.weight = weight;
        this.arterialPressure = arterialPressure;
        this.cholesterol = cholesterol;
        this.hdlcholesterol = hdlcholesterol;
        this.triglycerides = triglycerides;
        this.urea = urea;
        this.creatinine = creatinine;
        this.glycatedHemoglobin = glycatedHemoglobin;
        this.proteinuria = proteinuria;
        this.microalbuminuria = microalbuminuria;
        this.eyeFluangiography = eyeFluangiography;
        this.other = other;
    }

    public int getId_review() {
        return id_review;
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getArterialPressure() {
        return arterialPressure;
    }

    public void setArterialPressure(float arterialPressure) {
        this.arterialPressure = arterialPressure;
    }

    public float getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(float cholesterol) {
        this.cholesterol = cholesterol;
    }

    public float getHdlcholesterol() {
        return hdlcholesterol;
    }

    public void setHdlcholesterol(float hdlcholesterol) {
        this.hdlcholesterol = hdlcholesterol;
    }

    public float getTriglycerides() {
        return triglycerides;
    }

    public void setTriglycerides(float triglycerides) {
        this.triglycerides = triglycerides;
    }

    public float getUrea() {
        return urea;
    }

    public void setUrea(float urea) {
        this.urea = urea;
    }

    public float getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(float creatinine) {
        this.creatinine = creatinine;
    }

    public float getGlycatedHemoglobin() {
        return glycatedHemoglobin;
    }

    public void setGlycatedHemoglobin(float glycatedHemoglobin) {
        this.glycatedHemoglobin = glycatedHemoglobin;
    }

    public float getProteinuria() {
        return proteinuria;
    }

    public void setProteinuria(float proteinuria) {
        this.proteinuria = proteinuria;
    }

    public float getMicroalbuminuria() {
        return microalbuminuria;
    }

    public void setMicroalbuminuria(float microalbuminuria) {
        this.microalbuminuria = microalbuminuria;
    }

    public String getEyeFluangiography() {
        return eyeFluangiography;
    }

    public void setEyeFluangiography(String eyeFluangiography) {
        this.eyeFluangiography = eyeFluangiography;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}

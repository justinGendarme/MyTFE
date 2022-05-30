package com.example.MyTFE.model;

public class Help {

    private int id_help;
    private String category;
    private String question;
    private String reply;

    public Help()
    {}
    public Help(int id_help, String category, String question, String reply) {
        this.id_help = id_help;
        this.category = category;
        this.question = question;
        this.reply = reply;
    }

    public int getId_help() {
        return id_help;
    }

    public void setId_help(int id_help) {
        this.id_help = id_help;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}

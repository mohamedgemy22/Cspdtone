package com.enggemy22.cap.models;

public class University {
    private String name;
    private String gpa;
    private int  sat_score_range_min;
    private int  sat_score_range_max;
    private int est_score_range_max;
    private int est_score_range_min;
    private String finanial_aid;
    private String acceptance_rate;
    private String average_fees;
    private String country;
    private String qs_ranking;
    public University() {
    }

    public University(String name, String gpa, int sat_score_range_min, int sat_score_range_max, int est_score_range_max, int est_score_range_min, String finanial_aid, String acceptance_rate, String average_fees, String country, String qs_ranking)
    {
        this.name = name;
        this.gpa = gpa;
        this.sat_score_range_min = sat_score_range_min;
        this.sat_score_range_max = sat_score_range_max;
        this.est_score_range_max = est_score_range_max;
        this.est_score_range_min = est_score_range_min;
        this.finanial_aid = finanial_aid;
        this.acceptance_rate = acceptance_rate;
        this.average_fees = average_fees;
        this.country = country;
        this.qs_ranking = qs_ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public int getSat_score_range_min() {
        return sat_score_range_min;
    }

    public void setSat_score_range_min(int sat_score_range_min) {
        this.sat_score_range_min = sat_score_range_min;
    }

    public int getSat_score_range_max() {
        return sat_score_range_max;
    }

    public void setSat_score_range_max(int sat_score_range_max) {
        this.sat_score_range_max = sat_score_range_max;
    }

    public int getEst_score_range_max() {
        return est_score_range_max;
    }

    public void setEst_score_range_max(int est_score_range_max) {
        this.est_score_range_max = est_score_range_max;
    }

    public int getEst_score_range_min() {
        return est_score_range_min;
    }

    public void setEst_score_range_min(int est_score_range_min) {
        this.est_score_range_min = est_score_range_min;
    }

    public String getFinanial_aid() {
        return finanial_aid;
    }

    public void setFinanial_aid(String finanial_aid) {
        this.finanial_aid = finanial_aid;
    }

    public String getAcceptance_rate() {
        return acceptance_rate;
    }

    public void setAcceptance_rate(String acceptance_rate) {
        this.acceptance_rate = acceptance_rate;
    }

    public String getAverage_fees() {
        return average_fees;
    }

    public void setAverage_fees(String average_fees) {
        this.average_fees = average_fees;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getQs_ranking() {
        return qs_ranking;
    }

    public void setQs_ranking(String qs_ranking) {
        this.qs_ranking = qs_ranking;
    }
}
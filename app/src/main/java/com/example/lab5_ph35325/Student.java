package com.example.lab5_ph35325;


import java.io.Serializable;

public class Student implements Serializable {
    private String studyAt;
    private String nameStd;
    private String hometown;

    public Student(String studyAt, String nameStd, String hometown) {
        this.studyAt = studyAt;
        this.nameStd = nameStd;
        this.hometown = hometown;
    }
    public Student(){}

    public String getStudyAt() {
        return studyAt;
    }

    public void setStudyAt(String studyAt) {
        this.studyAt = studyAt;
    }

    public String getNameStd() {
        return nameStd;
    }

    public void setNameStd(String nameStd) {
        this.nameStd = nameStd;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}

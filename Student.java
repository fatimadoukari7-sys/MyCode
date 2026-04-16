package com.mybrand.newlab3_1;

public class Student {

    private static int counter = 0;

    private int id;
    private String name;
    private String department;
    private String contact;
    private int likes;

    public Student(String name, String department, String contact) {
        this.id = ++counter;
        this.name = name;
        this.department = department;
        this.contact = contact;
        this.likes = 0;
    }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getContact() { return contact; }
    public int getLikes() { return likes; }

    // setter for likes only
    public void setLikes(int likes) {
        this.likes = likes;
    }
}

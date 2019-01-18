package com.smart.cst.pwcfgd.staff;

/**
 * Created by user_1 on 12-07-2018.
 */

public class Staff {
    String id;
    String name;
    String contact;
    String address;
    String designation;
    String graduate;
    String specialization;
    String department;
    String gmail;
    String password;
    String confirmpassword;
    String image;
    public String regid;

    public Staff() {
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }

    public Staff(String name, String contact, String address, String designation, String graduate,
                 String specialization, String department,String gmail, String password, String confirmpassword,
                 String image, String regid) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.designation = designation;
        this.graduate = graduate;
        this.specialization = specialization;
        this.department = department;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.image = image;
        this.gmail=gmail;
        this.regid = regid;
    }

    public Staff(String id, String name, String contact, String address, String designation,
                 String graduate, String specialization, String department,String gmail, String password, String confirmpassword, String image, String regid) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.designation = designation;
        this.graduate = graduate;
        this.specialization = specialization;
        this.department = department;
        this.password = password;
        this.gmail=gmail;
        this.confirmpassword = confirmpassword;
        this.image = image;
        this.regid = regid;
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}

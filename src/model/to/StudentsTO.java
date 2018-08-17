package model.to;

import java.sql.Date;

public class StudentsTO {
    private int studentid;
    private String studentname;
    private String fathername;
    private Date dob;
    private String contactno;
    private String gender;
    private String maritalstatus;
    private int photoid;

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }
    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }
    public String toString(){
        String result = "";
        if(gender.equalsIgnoreCase("male")){
            result += "Mr. ";
        }else if(gender.equalsIgnoreCase("female")){
            if(maritalstatus.equalsIgnoreCase("single")){
                result += "Ms. ";
            }else{
                result += "Mrs. ";
            }
        }        
        result += studentname ;
        if(gender.equalsIgnoreCase("male")){
            result += " S/O ";
        }else if(gender.equalsIgnoreCase("female")){
            result += " D/O ";
        }
        result += fathername;
        return result;
    }
}

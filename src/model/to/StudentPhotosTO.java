package model.to;

import java.io.InputStream;

public class StudentPhotosTO {

    private int photoid;
    private int studentid;
    private String extension;
    private String photoname;
    private InputStream photodata;

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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    public InputStream getPhotodata() {
        return photodata;
    }

    public void setPhotodata(InputStream photodata) {
        this.photodata = photodata;
    }
}

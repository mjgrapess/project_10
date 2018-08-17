package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.to.StudentPhotosTO;
import model.to.StudentsTO;
import operations.ErrorHandler;

public class StudentPhotosDAO extends DAO {

    public boolean insertRecord(StudentPhotosTO record) {
        try {
            String query = "insert into studentphotos ";
            query += "(studentid,extension,photoname,photodata) ";
            query += " values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getStudentid());
            stmt.setString(2, record.getExtension());
            stmt.setString(3, record.getPhotoname());
            stmt.setBinaryStream(4, record.getPhotodata());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(StudentPhotosTO record) {
        try {
            String query = "update studentphotos ";
            query += " set studentid=?,extension=?,photoname=?,photodata=? ";
            query += " where photoid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getStudentid());
            stmt.setString(2, record.getExtension());
            stmt.setString(3, record.getPhotoname());
            stmt.setBinaryStream(4, record.getPhotodata());
            stmt.setInt(5, record.getPhotoid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int photoid) {
        try {
            String query = "delete from studentphotos ";
            query += " where photoid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, photoid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }
    public StudentPhotosTO getRecord(int photoid) {
        try {
            String query = "select photoid,photoname,extension,studentid,photodata ";
            query += " from studentphotos ";
            query += " where photoid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, photoid);
            StudentPhotosTO result = null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = new StudentPhotosTO();
                result.setPhotoid(rs.getInt("photoid"));
                result.setStudentid(rs.getInt("studentid"));
                result.setExtension(rs.getString("extension"));
                result.setPhotoname(rs.getString("photoname"));
                result.setPhotodata(rs.getBinaryStream("photodata"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }
    }
}

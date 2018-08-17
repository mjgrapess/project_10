package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.to.StudentCoursesTO;
import model.to.StudentPhotosTO;
import operations.ErrorHandler;

public class StudentCoursesDAO extends DAO {

    public boolean insertRecord(StudentCoursesTO record) {
        try {
            String query = "insert into studentcourses ";
            query += "(studentid,courseid,start_date,end_date,fee) ";
            query += " values(?,?,?,null,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getStudentid());
            stmt.setString(2, record.getCourseid());
            stmt.setDate(3, record.getStart_date());
            stmt.setInt(4, record.getFee());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(StudentCoursesTO record) {
        try {
            String query = "update studentcourses ";
            query += " set studentid=?,courseid=?,start_date=?,fee=? ";
            query += " where scid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getStudentid());
            stmt.setString(2, record.getCourseid());
            stmt.setDate(3, record.getStart_date());
            stmt.setInt(4, record.getFee());
            stmt.setInt(5, record.getScid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int scid) {
        try {
            String query = "delete from studentcourses ";
            query += " where scid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, scid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public List<StudentCoursesTO> getAllRecord() {
        try {
            String query = "select scid , sc.studentid , sc.courseid , start_date ,\n"
                    + "end_date , fee , studentname , coursename\n"
                    + "from studentcourses sc join students s\n"
                    + "on sc.studentid = s.studentid\n"
                    + "join courses c on sc.courseid = c.courseid";
            PreparedStatement stmt = DataConnection.getStatement(query);

            List<StudentCoursesTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new LinkedList<>();
                do {
                    StudentCoursesTO sct = new StudentCoursesTO();
                    sct.setScid(rs.getInt("scid"));
                    sct.setStudentid(rs.getInt("studentid"));
                    sct.setFee(rs.getInt("fee"));
                    sct.setCourseid(rs.getString("courseid"));
                    sct.setStart_date(rs.getDate("start_date"));
                    sct.setEnd_date(rs.getDate("end_date"));
                    sct.setStudentname(rs.getString("studentname"));
                    sct.setCoursename(rs.getString("coursename"));
                    result.add(sct);
                } while (rs.next());
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

    public StudentCoursesTO getRecord(int scid) {
        try {
            String query = "select scid , sc.studentid , sc.courseid , start_date ,\n"
                    + "end_date , fee , studentname , coursename\n"
                    + "from studentcourses sc join students s\n"
                    + "on sc.studentid = s.studentid\n"
                    + "join courses c on sc.courseid = c.courseid"
                    + " where scid  = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, scid);
            StudentCoursesTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new StudentCoursesTO();
                result.setScid(rs.getInt("scid"));
                result.setStudentid(rs.getInt("studentid"));
                result.setFee(rs.getInt("fee"));
                result.setCourseid(rs.getString("courseid"));
                result.setStart_date(rs.getDate("start_date"));
                result.setEnd_date(rs.getDate("end_date"));
                result.setStudentname(rs.getString("studentname"));
                result.setCoursename(rs.getString("coursename"));

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
    
     public boolean isCourseAlloted(int studentid) {
        try {
            String query = "select * from studentcourses "
                    + " where studentid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, studentid);
            boolean result = false;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
               result = true;
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }
}

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.CoursesTO;
import model.to.LoginInfoTO;
import operations.ErrorHandler;

public class CoursesDAO extends DAO {

    public boolean insertRecord(CoursesTO record) {
        try {
            String query = "insert into courses ";
            query += "(courseid,coursename,coursefee) ";
            query += " values(?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCourseid());
            stmt.setString(2, record.getCoursename());
            stmt.setInt(3, record.getCoursefee());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(CoursesTO record) {
        try {
            String query = "update courses ";
            query += " set coursename=?,coursefee=? ";
            query += " where courseid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCoursename());
            stmt.setInt(2, record.getCoursefee());
            stmt.setString(3, record.getCourseid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(String courseid) {
        try {
            String query = "delete from courses ";
            query += " where courseid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, courseid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public List<CoursesTO> getAllRecord() {
        try {
            String query = "select courseid,coursename,coursefee ";
            query += " from courses ";
            PreparedStatement stmt = DataConnection.getStatement(query);

            List<CoursesTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    CoursesTO ct = new CoursesTO();
                    ct.setCourseid(rs.getString("courseid"));
                    ct.setCoursename(rs.getString("coursename"));
                    ct.setCoursefee(rs.getInt("coursefee"));
                    result.add(ct);
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
}

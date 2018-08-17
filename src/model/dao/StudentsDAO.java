package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.CoursesTO;
import model.to.StudentsTO;
import operations.ErrorHandler;

public class StudentsDAO extends DAO {

    public boolean insertRecord(StudentsTO record) {
        try {
            String query = "insert into students ";
            query += "(studentname,fathername,contactno,gender,maritalstatus,dob) ";
            query += " values(?,?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getStudentname());
            stmt.setString(2, record.getFathername());
            stmt.setString(3, record.getContactno());
            stmt.setString(4, record.getGender());
            stmt.setString(5, record.getMaritalstatus());
            stmt.setDate(6, record.getDob());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(StudentsTO record) {
        try {
            String query = "update students ";
            query += " set studentname=?,fathername=?,contactno=?,gender=?,maritalstatus=?,dob=? ";
            query += " where studentid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getStudentname());
            stmt.setString(2, record.getFathername());
            stmt.setString(3, record.getContactno());
            stmt.setString(4, record.getGender());
            stmt.setString(5, record.getMaritalstatus());
            stmt.setDate(6, record.getDob());
            stmt.setInt(7, record.getStudentid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int studentid) {
        try {
            String query = "delete from students ";
            query += " where studentid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, studentid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public StudentsTO getRecord(int studentid) {
        try {
            String query = "select studentid,studentname,fathername,contactno,dob,gender,maritalstatus ";
            query += " from students ";
            query += " where studentid=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, studentid);
            StudentsTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new StudentsTO();
                result.setStudentid(rs.getInt("studentid"));
                result.setStudentname(rs.getString("studentname"));
                result.setFathername(rs.getString("fathername"));
                result.setContactno(rs.getString("contactno"));
                result.setGender(rs.getString("gender"));
                result.setMaritalstatus(rs.getString("maritalstatus"));
                result.setDob(rs.getDate("dob"));
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

    public List<StudentsTO> getAllRecord() {
        try {
            String query = "select st.studentid,studentname,fathername,\n"
                    + "contactno,dob,gender,maritalstatus,ifnull(photoid,0) photoid\n"
                    + "from students st left outer join studentphotos sp\n"
                    + "on st.studentid = sp.studentid";
            PreparedStatement stmt = DataConnection.getStatement(query);

            List<StudentsTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    StudentsTO st = new StudentsTO();
                    st.setStudentid(rs.getInt("studentid"));
                    st.setStudentname(rs.getString("studentname"));
                    st.setFathername(rs.getString("fathername"));
                    st.setContactno(rs.getString("contactno"));
                    st.setGender(rs.getString("gender"));
                    st.setMaritalstatus(rs.getString("maritalstatus"));
                    st.setDob(rs.getDate("dob"));
                    st.setPhotoid(rs.getInt("photoid"));
                    result.add(st);
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

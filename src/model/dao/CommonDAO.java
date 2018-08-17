package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import operations.ErrorHandler;

public class CommonDAO extends DAO {

    public int getLastInsertID() {
        try {
            String query = "select last_insert_id()";
            PreparedStatement stmt = DataConnection.getStatement(query);
            int id = 0;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            return id;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return 0;
        }
    }

    public List<Object[]> getCourseDetails(int year) {
        try {
            String query = "select sc.courseid , count(*) TotalStudent\n"
                    + "from studentcourses sc join courses c\n"
                    + "on sc.courseid = c.courseid\n"
                    + "where year(start_date) = ?\n"
                    + "group by sc.courseid";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,year);
            List<Object[]> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do{
                    Object values[] = new Object[2];
                    values[0] = rs.getString("courseid");
                    values[1] = rs.getInt("TotalStudent");
                    result.add(values);
                }while(rs.next());
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

package operations;

import java.sql.Connection;
import java.util.Map;
import model.dao.DataConnection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportGenerator {

    private String designpath;

    public JasperReportGenerator(String designpath) {
        this.designpath = designpath;
    }

    public void generateReport(Map parameters) {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(designpath);
            JasperReport jasperReport
                    = JasperCompileManager.compileReport(jasperDesign);
            Connection con = DataConnection.getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            ErrorHandler.showStackTrace(ex);
        }
    }
}

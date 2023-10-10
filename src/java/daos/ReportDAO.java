package daos;

import DAO.DBContext;
import dtos.ReportDTO;

public class ReportDAO extends AbstractDAO {

    public boolean createReport(ReportDTO report) {
        boolean result = false;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO Report VALUES(?, ?, ?, ?)");
            ps.setInt(1, report.getCustomerID());
            if (report.getProductID() == 0) {
                ps.setString(2, null);
            } else {
                ps.setString(2, String.valueOf(report.getProductID()));
            }
            if (report.getStoreID() == 0) {
                ps.setString(3, null);
            } else {
                ps.setString(3, String.valueOf(report.getStoreID()));
            }

            ps.setString(4, report.getContent());

            result = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return result;
    }
}

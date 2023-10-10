package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractDAO {

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    protected Connection conn1 = null;
    protected PreparedStatement ps1 = null;
    protected ResultSet rs1 = null;

    protected void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {

        }
    }

    protected void closeConnection1() {
        try {
            if (rs1 != null) {
                rs1.close();
            }
            if (ps1 != null) {
                ps1.close();
            }
            if (conn1 != null) {
                conn1.close();
            }
        } catch (SQLException ex) {
        }
    }

}

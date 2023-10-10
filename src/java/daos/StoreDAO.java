package daos;

import DAO.DBContext;
import dtos.SellerDTO;
import dtos.StoreDTO;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO extends AbstractDAO {

    public List<StoreDTO> getStore() {
        List<StoreDTO> listStore = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT st.*, se.SellerName, se.Phone, se.SellerAddress, se.Avatar, se.UserID FROM Store st JOIN Sellers se ON st.SellerID = se.SellerID");
            rs = ps.executeQuery();

            while (rs.next()) {
                SellerDTO seller = new SellerDTO(rs.getInt(2), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                StoreDTO store = new StoreDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), seller);
                listStore.add(store);
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return listStore;
    }

    public StoreDTO getStoreById(String storeID) {
        StoreDTO store = new StoreDTO();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM Store WHERE StoreID = ?");
            ps.setString(1, storeID);
            rs = ps.executeQuery();

            if (rs.next()) {
                SellerDTO seller = new SellerDTO();
                seller.setSellerID(rs.getInt(2));
                store.setSellerDTO(seller);

            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return store;
    }
}

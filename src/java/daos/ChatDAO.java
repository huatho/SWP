package daos;

import DAO.DBContext;
import dtos.ChatDTO;
import dtos.CustomerDTO;
import dtos.SellerDTO;
import java.util.ArrayList;
import java.util.List;

public class ChatDAO extends AbstractDAO {

    public List<CustomerDTO> getCustomerChat(String sellerID) {
        List<CustomerDTO> listCustomer = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement("SELECT * FROM Customers WHERE CustomerID IN (SELECT CustomerID FROM Chat WHERE SellerID = ? GROUP BY CustomerID)");
            ps.setString(1, sellerID);

            rs = ps.executeQuery();

            while (rs.next()) {
                CustomerDTO customer = new CustomerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(7));
                listCustomer.add(customer);
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return listCustomer;
    }

    public List<ChatDTO> getListMessageChat(String customerID, String sellerID) {
        List<ChatDTO> listChat = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement("SELECT ch.CustomerID, ch.SellerID, ch.IsCustomerSend, ch.MessageChat, c.* FROM Chat ch JOIN Customers c ON ch.CustomerID = c.CustomerID WHERE ch.CustomerID = ? AND ch.SellerID = ?");
            ps.setString(1, customerID);    
            ps.setString(2, sellerID);


            rs = ps.executeQuery();
            while (rs.next()) {
                CustomerDTO customer = new CustomerDTO(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(11));
                SellerDTO seller = new SellerDTO();
                seller.setSellerID(rs.getInt(2));
                ChatDTO chat = new ChatDTO(customer, seller, rs.getBoolean(3), rs.getString(4));
                listChat.add(chat);
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return listChat;
    }
    
    public List<ChatDTO> getListMessageChatUser(String customerID, String sellerID) {
        List<ChatDTO> listChat = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement("SELECT ch.CustomerID, ch.SellerID, ch.IsCustomerSend, ch.MessageChat, c.* FROM Chat ch JOIN Sellers c ON ch.SellerID = c.SellerID WHERE ch.CustomerID = ? AND ch.SellerID = ?");
            ps.setString(1, customerID);    
            ps.setString(2, sellerID);


            rs = ps.executeQuery();
            while (rs.next()) {
                SellerDTO seller = new SellerDTO(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(11));
                CustomerDTO customer = new CustomerDTO();
                customer.setCustomerID(rs.getInt(1));
                ChatDTO chat = new ChatDTO(customer, seller, rs.getBoolean(3), rs.getString(4));
                listChat.add(chat);
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return listChat;
    }
    
    public List<SellerDTO> getSellerChat(String customerID) {
        List<SellerDTO> listSeller = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement("SELECT * FROM Sellers WHERE SellerID IN (SELECT SellerID FROM Chat WHERE CustomerID = ? GROUP BY SellerID)");
            ps.setString(1, customerID);

            rs = ps.executeQuery();

            while (rs.next()) {
                SellerDTO seller = new SellerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(7));
                listSeller.add(seller);
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return listSeller;
    }
    
    public boolean createChat(ChatDTO chat) {
        boolean result = false;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO Chat VALUES(?, ?, ?, ?)");
            ps.setInt(1, chat.getCustomerDTO().getCustomerID());
            ps.setInt(2, chat.getSellerDTO().getSellerID());
            if (chat.isIsCustomerSend()) {
                ps.setInt(3, 1);
            } else {
                ps.setInt(3, 0);
            }
            ps.setString(4, chat.getMessageChat());

            result = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return result;
    }
}

package daos;

import DAO.DBContext;
import dtos.CategoryDTO;
import java.util.List;
import dtos.ProductDTO;
import java.util.ArrayList;

public class ProductDAO extends AbstractDAO {

    public List<ProductDTO> getListProduct(String productName, String priceFrom, String priceTo, String categoryName, String storeID) {
        List<ProductDTO> listProduct = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            if (!priceFrom.equals("")) {
                priceFrom = " AND p.Price >= " + priceFrom;
            }
            if (!priceTo.equals("")) {
                priceTo = " AND p.Price <= " + priceTo;
            }

            ps = conn.prepareStatement("SELECT p.*, c.CategoryName FROM Product p JOIN Category c ON p.CategoryID = c.CategoryID WHERE p.ProductName LIKE ?" + priceFrom + priceTo + " AND c.CategoryName LIKE ? AND p.StoreID = ? ORDER BY p.ProductID DESC");
            ps.setString(1, "%" + productName + "%");
            ps.setString(2, "%" + categoryName + "%");
            ps.setString(3, storeID);

            rs = ps.executeQuery();

            while (rs.next()) {
                CategoryDTO category = new CategoryDTO(rs.getString(7), rs.getString(9));
                ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), category, rs.getInt(8));
                listProduct.add(product);
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return listProduct;
    }

    public boolean createProduct(ProductDTO product) {
        boolean result = false;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO Product VALUES(?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescriptions());

            ps.setString(3, product.getSex());
            ps.setString(4, product.getImageLink());
            ps.setInt(5, product.getPrice());
            ps.setString(6, product.getCategoryDTO().getCategoryID());
            ps.setInt(7, product.getStoreID());
            result = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateProduct(ProductDTO product) {
        boolean result = false;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("UPDATE Product SET ProductName = ?, Descriptions = ?, Sex = ?, ImageLink = ?, Price = ?, CategoryID = ?, StoreID = ? WHERE ProductID = ?");
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescriptions());
            ps.setString(3, product.getSex());
            ps.setString(4, product.getImageLink());
            ps.setInt(5, product.getPrice());
            ps.setString(6, product.getCategoryDTO().getCategoryID());
            ps.setInt(7, product.getStoreID());
            ps.setInt(8, product.getProductID());

            result = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteProduct(int productID) {
        boolean result = false;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("DELETE FROM Products WHERE productID = ?");
            ps.setInt(1, productID);

            result = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return result;
    }

}

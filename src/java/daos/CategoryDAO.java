package daos;

import DAO.DBContext;
import dtos.CategoryDTO;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO {
    
    public List<CategoryDTO> getCategory() {
        List<CategoryDTO> listCategory = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM Category");
 
            rs = ps.executeQuery();
            
            while (rs.next()) {
                CategoryDTO category = new CategoryDTO(rs.getString(1), rs.getString(2));
                listCategory.add(category);
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            closeConnection();
        }
        return listCategory;
    }
}
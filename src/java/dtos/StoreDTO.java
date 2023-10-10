package dtos;

import java.io.Serializable;

public class StoreDTO implements Serializable {

    private int storeID;
    private String storeName;
    private String descriptions;
    private String linkImage;
    private SellerDTO sellerDTO;

    public StoreDTO() {
    }

    public StoreDTO(int storeID, String storeName, String descriptions, String linkImage, SellerDTO sellerDTO) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.descriptions = descriptions;
        this.linkImage = linkImage;
        this.sellerDTO = sellerDTO;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public SellerDTO getSellerDTO() {
        return sellerDTO;
    }

    public void setSellerDTO(SellerDTO sellerDTO) {
        this.sellerDTO = sellerDTO;
    }

}

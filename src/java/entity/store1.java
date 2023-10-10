/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MSII
 */
public class store1 {
    private String storeId;
    private String sellerId;
    private String storeName;
    private String descriptions;
    private String linkImg;

    public store1() {
    }

    public store1(String storeId, String sellerId, String storeName, String descriptions, String linkImg) {
        this.storeId = storeId;
        this.sellerId = sellerId;
        this.storeName = storeName;
        this.descriptions = descriptions;
        this.linkImg = linkImg;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
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

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    @Override
    public String toString() {
        return "store{" + "storeId=" + storeId + ", sellerId=" + sellerId + ", storeName=" + storeName + ", descriptions=" + descriptions + ", linkImg=" + linkImg + '}';
    }
    
}

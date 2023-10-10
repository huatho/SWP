package dtos;

import java.io.Serializable;

public class ChatDTO implements Serializable {

    private CustomerDTO customerDTO;
    private SellerDTO sellerDTO;
    private boolean isCustomerSend;
    private String messageChat;

    public ChatDTO() {
    }

    public ChatDTO(CustomerDTO customerDTO, SellerDTO sellerDTO, boolean isCustomerSend, String messageChat) {
        this.customerDTO = customerDTO;
        this.sellerDTO = sellerDTO;
        this.isCustomerSend = isCustomerSend;
        this.messageChat = messageChat;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public SellerDTO getSellerDTO() {
        return sellerDTO;
    }

    public void setSellerDTO(SellerDTO sellerDTO) {
        this.sellerDTO = sellerDTO;
    }

    public boolean isIsCustomerSend() {
        return isCustomerSend;
    }

    public void setIsCustomerSend(boolean isCustomerSend) {
        this.isCustomerSend = isCustomerSend;
    }

    public String getMessageChat() {
        return messageChat;
    }

    public void setMessageChat(String messageChat) {
        this.messageChat = messageChat;
    }

}

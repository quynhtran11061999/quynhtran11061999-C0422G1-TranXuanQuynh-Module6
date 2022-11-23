package com.example.dto;

public interface ICartDto {
    Long getId();

    Integer getQuantityCart();

    String getTitle();

    Double getPrice();

    Integer getQuantity();

    String getImageUrl();

    Double totalPrice() ;
}

package com.moraes.jsonconsumer.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Payment implements Serializable {

    private Long id;

    private Long idUser;

    private Long idProduct;

    private String cardNumber;
}

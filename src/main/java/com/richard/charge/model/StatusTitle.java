package com.richard.charge.model;

public enum StatusTitle {

    PENDING("Pendente"),
    RECEIVED("Recebido");

    StatusTitle(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

}

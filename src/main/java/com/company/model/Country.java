package com.company.model;

import lombok.Data;

@Data
public class Country {

    private int id;
    private String name;
    private String capital;
    private Currency currency;
    private long population;
}

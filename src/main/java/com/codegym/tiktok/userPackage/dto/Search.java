package com.codegym.tiktok.userPackage.dto;

import lombok.Data;

@Data
public class Search{
    private String name;
    private int maxAge;
    private int minAge;
    private String gender;
    private String city;
}

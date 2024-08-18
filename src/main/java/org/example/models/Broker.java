package org.example.models;

import lombok.Data;

@Data
public class Broker {

    private String name;
    private String address;
    private String landlineNumber;
    private String mobileNumber;
    private Integer numberOfPropertiesAssigned;
}

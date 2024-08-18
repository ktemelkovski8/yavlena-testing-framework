package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Broker {

    private String name;
    private String address;
    private String landlineNumber;
    private String mobileNumber;
    private Integer numberOfPropertiesAssigned;
}

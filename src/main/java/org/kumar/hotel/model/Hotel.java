package org.kumar.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private String name;
    private String brand;
    private String tagline;
    private String description;
    private String address;
    private String phone;
}

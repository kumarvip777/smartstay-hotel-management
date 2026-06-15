package org.kumar.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Hotel Name is Required")
    private String name;

    @NotBlank(message = "Brand is Required")
    private String brand;

    @NotBlank(message = "Tagline is Required")
    private String tagline;

    @NotBlank(message = "Description is Required")
    private String description;

    @NotBlank(message = "Address is Required")
    private String address;

    @NotBlank(message = "Phone Number is Required")
    private String phone;
}
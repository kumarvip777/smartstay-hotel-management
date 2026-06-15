package org.kumar.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer Name is Required")
    private String customerName;

    @NotNull(message = "Check In Date is Required")
    private LocalDate checkInDate;

    @NotNull(message = "Check Out Date is Required")
    private LocalDate checkOutDate;

    @NotBlank(message = "Room Type is Required")
    private String roomType;
}
package org.kumar.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is Required")
    private String name;

    @Email(message = "Enter a Valid Email")
    @NotBlank(message = "Email is Required")
    private String email;

    @NotBlank(message = "Subject is Required")
    private String subject;

    @NotBlank(message = "Message is Required")
    private String message;
}
package ru.floda.ecommerce.dto;

import lombok.Data;

import java.time.Instant;

/**
 * DTO for {@link ru.floda.ecommerce.entity.User}
 */
@Data
public class UserDto {
    Long id;

    String firstName;

    String lastName;

    String email;

    String password;

    Instant createdAt;

    Instant updatedAt;

}

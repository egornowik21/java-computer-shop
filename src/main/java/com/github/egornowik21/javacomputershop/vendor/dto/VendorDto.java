package com.github.egornowik21.javacomputershop.vendor.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class VendorDto {
    Long id;
    @NotBlank(message = "Имя не может быть пустым")
    String name;
}

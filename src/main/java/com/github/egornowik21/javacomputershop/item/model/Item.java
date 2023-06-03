package com.github.egornowik21.javacomputershop.item.model;

import com.github.egornowik21.javacomputershop.vendor.model.Vendor;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.MappedSuperclass;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Item {
    Long id;
    Vendor vendor;
    Long number;
    Long price;
    Long count;
    ItemType itemType;
}

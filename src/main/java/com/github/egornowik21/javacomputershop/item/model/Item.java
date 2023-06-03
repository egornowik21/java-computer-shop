package com.github.egornowik21.javacomputershop.item.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.egornowik21.javacomputershop.vendor.model.Vendor;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
    Vendor vendor;
    @Column(name = "numbers", nullable = false)
    Long number;
    @Column(name = "price", nullable = false)
    Long price;
    @Column(name = "count", nullable = false)
    Long count;
}

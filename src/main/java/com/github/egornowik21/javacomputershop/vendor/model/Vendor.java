package com.github.egornowik21.javacomputershop.vendor.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@Entity
@Table(name = "vendors")
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "name", nullable = false, length = 320)
    String name;
}

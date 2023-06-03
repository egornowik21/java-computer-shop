package com.github.egornowik21.javacomputershop.item.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pc")
public class PcItem extends Item {
    @Enumerated
    PcForms pcForms;
}

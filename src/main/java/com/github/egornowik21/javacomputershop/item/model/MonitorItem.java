package com.github.egornowik21.javacomputershop.item.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "monitors")
public class MonitorItem extends Item {
    @Column(name = "sizes", nullable = false)
    Integer size;
}

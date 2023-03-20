package com.evaluacion.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "phone")
@Data
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private String cityCode;
    private String contryCode;

}

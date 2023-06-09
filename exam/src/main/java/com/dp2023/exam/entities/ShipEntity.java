package com.dp2023.exam.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "military_ships")
public class ShipEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String img;
        private int year;
        private String country;
}
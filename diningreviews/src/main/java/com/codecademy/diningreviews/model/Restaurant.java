package com.codecademy.diningreviews.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="RESTAURANTS")
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String line1;
    private String city;
    private String state;
    private String zipCode;

    private String phoneNumber;
    private String website;

    private String overallScore;
    private String peanutScore;
    private String dairyScore;
    private String eggScore;
}

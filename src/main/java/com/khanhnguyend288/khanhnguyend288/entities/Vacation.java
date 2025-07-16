package com.khanhnguyend288.khanhnguyend288.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
//debug front end not rendering
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacationTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_fare_price", precision = 19, scale = 2)
    private BigDecimal travelPrice;

    //debug image not rendering.
    @JsonProperty("image_URL")
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "vacation")
    private Set<Excursion> excursions;
}

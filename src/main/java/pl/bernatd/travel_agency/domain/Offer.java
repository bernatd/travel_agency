package pl.bernatd.travel_agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "OFFERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Offer {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "PLACE")
    private String place;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "START_DATE")
    private LocalDate start_date;

    @Column(name = "END_DATE")
    private LocalDate end_date;
}

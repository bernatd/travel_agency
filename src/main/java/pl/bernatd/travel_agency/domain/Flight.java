package pl.bernatd.travel_agency.domain;

import javax.persistence.*;

@Entity
@Table(name = "FLIGHTS")
public class Flight {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "AIRLINE")
    private String airline;

    @Column(name = "ORIGIN")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "CATEGORY")
    private String category;
}

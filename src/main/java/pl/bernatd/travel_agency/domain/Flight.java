package pl.bernatd.travel_agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FLIGHTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

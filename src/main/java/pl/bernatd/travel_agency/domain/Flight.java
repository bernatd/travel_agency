package pl.bernatd.travel_agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "FLIGHTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "flight")
    private Offer offer;

    @Column(name = "CODE")
    private String code;

    @Column(name = "AIRLINE")
    private String airline;

    @Column(name = "ORIGIN")
    private String origin;

    @Column(name = "DESTINATION")
    private String destination;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PRICE")
    private BigDecimal price;

    public Flight(Long id, String code, String airline, String origin, String destination, String category,
                  BigDecimal price) {
        this.id = id;
        this.code = code;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.category = category;
        this.price = price;
    }
}

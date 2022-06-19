package pl.bernatd.travel_agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "HOTELS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "hotel")
    private Offer offer;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "STANDARD")
    private String standard;

    @Column(name = "PRICE")
    private BigDecimal price;

    public Hotel(Long id, String city, String country, String standard, BigDecimal price) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.standard = standard;
        this.price = price;
    }
}

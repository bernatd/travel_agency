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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "INSURANCE_ID")
    private Insurance insurance;

    @NotNull
    @Column(name = "PLACE")
    private String place;

    @Column(name = "DESCRIPTION")
    private String description;

/*    @Column(name = "PRICE")
    private BigDecimal price;*/

    @Column(name = "START_DATE")
    private LocalDate start_date;

    @Column(name = "END_DATE")
    private LocalDate end_date;

    public Offer(Long id, String place, String description, LocalDate start_date, LocalDate end_date) {
        this.id = id;
        this.place = place;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}

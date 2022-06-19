package pl.bernatd.travel_agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESERVATIONS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "OFFER_ID")
    private Offer offer;


    @OneToMany(
            targetEntity = Traveller.class,
            mappedBy = "reservation",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Traveller> travellers = new ArrayList<>();

    @Column(name = "PRICE")
    private BigDecimal price;

    @NotNull
    @Column(name = "DATE_CREATED")
    private LocalDate created = LocalDate.now();

    @Column(name = "PAID")
    private boolean is_paid = Boolean.FALSE;

    public Reservation(Long id, List<Traveller> travellers , BigDecimal price, LocalDate created, boolean is_paid) {
        this.id = id;
        this.travellers = travellers;
        this.price = price;
        this.created = created;
        this.is_paid = is_paid;
    }
}

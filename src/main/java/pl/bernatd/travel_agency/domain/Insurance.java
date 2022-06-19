package pl.bernatd.travel_agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "INSURANCES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Insurance {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "insurance")
    private Offer offer;

    @NotNull
    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESC")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    public Insurance(Long id, String type, String description, BigDecimal price) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.price = price;
    }
}

package pl.bernatd.travel_agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESC")
    private String description;
}

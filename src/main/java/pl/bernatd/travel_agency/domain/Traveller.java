package pl.bernatd.travel_agency.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Travellers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Traveller {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @NotNull
    @Column(name = "PHONE")
    private String phone_number;

    @Column(name = "EMAIL")
    private String email;
}

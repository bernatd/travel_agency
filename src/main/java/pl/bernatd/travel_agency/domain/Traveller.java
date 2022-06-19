package pl.bernatd.travel_agency.domain;

import lombok.*;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TRAVELLERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Traveller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "RESERVATION_ID")
    private Reservation reservation;

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

    public Traveller(Long id, String firstName, String lastName, String address, String phone_number, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }
}

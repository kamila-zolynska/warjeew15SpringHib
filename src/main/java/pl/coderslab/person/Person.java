package pl.coderslab.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    @OneToOne
    private PersonDetails personDetails;

    public Person(String login, String password, String email, PersonDetails personDetails) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.personDetails = personDetails;
    }
}

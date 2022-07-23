package pl.coderslab.dwarfs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "dwarfs")
@ToString //tostring ma opcje exlude, include
public class Dwarf {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "latitude")
    private String lat;
    private String lng;

    private String street;
    private String nearestNumber;

    //jest to oznaczenie dodatkowego pola, ktorego nie chcemy w bazie danych,
    // no i nie zostanie tam utworzone
    @Transient
    private long distanceFromPapa;

    //super do ustawiania dat zaraz przed wpisem
    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }
}

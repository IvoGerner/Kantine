package nl.hanze.kantine;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "factuurRegel")
public class FactuurRegel implements Serializable {
    @Id
    @GeneratedValue
    @Column(name ="id", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factuur_id")
    private Factuur factuur;


    @Column(name = "artikel")
    private String artikel;

    public FactuurRegel(){

    }

    public FactuurRegel(Factuur factuur, String artikel){
        this.factuur = factuur;
        this.artikel = artikel;
    }

    @Override
    public String toString() {
        return "FactuurRegel{" +
                "id=" + id +
                ", factuur=" + factuur +
                ", artikel=" + artikel +
                '}';
    }
}

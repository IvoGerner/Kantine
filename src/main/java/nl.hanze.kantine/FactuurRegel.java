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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "factuur_artikel", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "factuur_id"))
    private Factuur factuur;

    @Column(name = "artikel_id")
    private Artikel artikel;

    public FactuurRegel(){

    }

    public FactuurRegel(Factuur factuur, Artikel artikel){
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

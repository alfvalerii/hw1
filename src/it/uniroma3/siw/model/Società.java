package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@NamedQuery(name = "findAllSocieta", query = "SELECT s FROM Società s")
public class Società {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String ragioneSociale;

    @Column(nullable = false)
    private String numeroTelefono;
    
    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})//società ha un solo indirizzo,strategia fetch lasciata quella predefinita, impostata proprietà di cascade poichè è comodo che la persist e remove applicate su società vengano applicate direttamente su indirizzo 
    private Indirizzo indirizzo;
    
    public Società() {
    }

    public Società(String ragioneSociale, String numeroTelefono ) {
        this.ragioneSociale = ragioneSociale;
        this.numeroTelefono = numeroTelefono;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    
    

    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Indirizzo");
        sb.append("{id=").append(id);
        sb.append(", ragioneSociale='").append(ragioneSociale);
        sb.append(", numeroTelefono=").append(numeroTelefono);
        sb.append("}\n");
        return sb.toString();
    }
}
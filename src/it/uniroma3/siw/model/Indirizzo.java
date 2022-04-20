package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Column;

@Entity
@NamedQuery(name = "findAllIndirizzi", query = "SELECT i FROM Indirizzo i")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String via;
    
    @Column(nullable = false)
    private int numerocivico;
    
    @Column(nullable = false)
    private String comune;
    
    @Column(nullable = false)
    private int cap;
    
    @Column(nullable = false)
    private String provincia;
    
    
    public Indirizzo() {
    }

    public Indirizzo(String via, int numerocivico, String comune, int cap, String provincia) {
        this.via = via;
        this.numerocivico = numerocivico;
        this.comune = comune;
        this.cap = cap;
        this.provincia = provincia;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getNumerocivico() {
        return numerocivico;
    }

    public void setNumerocivico(int numerocivico) {
        this.numerocivico = numerocivico;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    
    public String getComune() {
        return this.comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }
    
    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }
    
    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Indirizzo");
        sb.append("{id=").append(id);
        sb.append(", via='").append(via);
        sb.append(", numerocivico=").append(numerocivico);
        sb.append(", comune='").append(comune);
        sb.append(", cap='").append(cap);
        sb.append(", provincia='").append(provincia);
        sb.append("}\n");
        return sb.toString();
    }
}
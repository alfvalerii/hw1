package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Column;

@Entity
@NamedQuery(name = "findAllDocenti", query = "SELECT d FROM Docente d")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String cognome;
    
    @Column(nullable = false)
    private LocalDate dataNascita;
    
    @Column(nullable = false)
    private String luogoNascita;

    @Column(nullable = false)
    private Float partitaIva;
    
    @OneToMany(mappedBy="docente",fetch=FetchType.LAZY)//docente può tenere 1 o + corsi, strategia di fetch lasciata quella predefinita
    private List<Corso> corsi;
    
    public Docente() {
    }

    public Docente(String nome, String cognome, LocalDate dataNascita, String luogoNascita, Float partitaIva) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.partitaIva = partitaIva;      
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    
    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public Float getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(Float partitaIva) {
        this.partitaIva = partitaIva;
    }

    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Indirizzo");
        sb.append("{id=").append(id);
        sb.append(", nome='").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", dataNascita='").append(dataNascita);
        sb.append(", luogoNascita='").append(luogoNascita);
        sb.append(", partitaIva='").append(partitaIva);
        sb.append("}\n");
        return sb.toString();
    }
}
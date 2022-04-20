package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Column;

@Entity
@NamedQuery(name = "findAllAllievi", query = "SELECT a FROM Allievo a")
public class Allievo {

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
    private int matricola;
    
    @Column(nullable = false)
    private String indirizzoPostaElettronica;
    
    @OneToMany(fetch = FetchType.LAZY)//allievo dipendente di una società, strategia di fetch lasciata quella predefinita
    private List<Società> società;
    
    @ManyToMany(fetch = FetchType.LAZY)//allievo può seguire 1 o + corsi, strategia di fetch lasciata quella predefinita
    private List<Corso> corsi;

    
    public Allievo() {
    }

    public Allievo(String nome, String cognome, LocalDate dataNascita, String luogoNascita, int matricola, String indirizzoPostaElettronica) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.matricola = matricola;
        this.indirizzoPostaElettronica = indirizzoPostaElettronica;
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

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    
    public String getIndirizzoPostaElettronica() {
        return this.indirizzoPostaElettronica;
    }

    public void setIndirizzoPostaElettronica(String indirizzoPostaElettronica) {
        this.indirizzoPostaElettronica = indirizzoPostaElettronica;
    }
    
    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
    
    public LocalDate getDataNascita() {
        return this.dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Indirizzo");
        sb.append("{id=").append(id);
        sb.append(", nome='").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", dataNascita='").append(dataNascita);
        sb.append(", luogoNascita='").append(luogoNascita);
        sb.append(", matricola='").append(matricola);
        sb.append(", indirizzoPostaElettronica='").append(indirizzoPostaElettronica);
        sb.append("}\n");
        return sb.toString();
    }
}
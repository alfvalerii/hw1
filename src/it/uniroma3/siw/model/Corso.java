package it.uniroma3.siw.model;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


import javax.persistence.Column;

@Entity
@NamedQuery(name = "findAllCorsi", query = "SELECT c FROM Corso c")
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private LocalDate dataInizio;
    
    @Column(nullable = false)
    private int durataMesi;
    
    @ManyToMany(mappedBy="corsi",fetch = FetchType.LAZY)//corso frequentato da 1 o + allievi, strategia fetch lasciata quella predefinita
    private List<Allievo> allievi;
    
    @ManyToOne(fetch = FetchType.EAGER)//corso tenuto da un solo docente, strategia fetch lasciata quella predefinita
    private Docente docente;
    
    public Corso() {
    }

    public Corso(String nome, LocalDate dataInizio,int durataMesi) {
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.durataMesi = durataMesi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
 
    public int getDurataMesi() {
        return durataMesi;
    }

    public void setDurataMesi(int durataMesi) {
        this.durataMesi = durataMesi;
    }

    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Indirizzo");
        sb.append("{id=").append(id);
        sb.append(", nome='").append(nome);
        sb.append(", dataInizio=").append(dataInizio);
        sb.append(", durataMesi='").append(durataMesi);
        sb.append("}\n");
        return sb.toString();
    }
}
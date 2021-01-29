package com.gabrielez.CarRental.entity;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Prenotazioni")
@Check(constraints = "inizio < fine")
public class Prenotazione{

    public enum Stato{
        RIFIUTATO,
        DA_APPROVARE,
        APPROVATO
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "auto")
    private Auto auto;

    @Column(name = "stato")
    @ColumnDefault( value = "1" )
    private Stato stato;

    @Column(name = "inizio")
    private Date inizio;

    @Column(name = "fine")
    private Date fine;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Date getInizio() {
        return inizio;
    }

    public void setInizio(Date inizio) {
        this.inizio = inizio;
    }

    public Date getFine() {
        return fine;
    }

    public void setFine(Date fine) {
        this.fine = fine;
    }

}

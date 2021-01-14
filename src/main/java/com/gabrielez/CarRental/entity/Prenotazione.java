package com.gabrielez.CarRental.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Prenotazioni")
public class Prenotazione {
    @Id
    @Column(name = "data_operazione")
    private String dataOperazione;

    @Id
    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = "username")
    private User user;

    @Id
    @OneToOne
    @JoinColumn(name = "auto", referencedColumnName = "targa")
    private Auto auto;

    @Column(name = "stato")
    private String stato;

    @Column(name = "inizio")
    private Date inizio;

    @Column(name = "fine")
    private Date fine;


    public String getDataOperazione() {
        return dataOperazione;
    }

    public void setDataOperazione(String dataOperazione) {
        this.dataOperazione = dataOperazione;
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

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
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

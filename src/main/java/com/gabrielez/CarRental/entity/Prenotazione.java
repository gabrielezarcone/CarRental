package com.gabrielez.CarRental.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "data_operazione", length = 30, unique = true)
    private Date dataOperazione;

    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = "username", unique = true)
    private User user;

    @OneToOne
    @JoinColumn(name = "auto", referencedColumnName = "targa", unique = true)
    private Auto auto;

    @Column(name = "stato", length = 30)
    private String stato;

    @Column(name = "inizio")
    private Date inizio;

    @Column(name = "fine")
    private Date fine;


    public Date getDataOperazione() {
        return dataOperazione;
    }

    public void setDataOperazione(Date dataOperazione) {
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

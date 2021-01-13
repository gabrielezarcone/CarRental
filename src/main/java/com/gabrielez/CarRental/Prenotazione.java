package com.gabrielez.CarRental;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Prenotazione")
public class Prenotazione {
    @Id
    @Column(name = "data_operazione")
    private String data_operazione;

    @Id
    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    @Id
    @OneToOne
    @JoinColumn(name = "targa")
    private Auto auto;

    @Column(name = "data_operazione")
    private String stato;

    @Column(name = "data_operazione")
    private Date inizio;

    @Column(name = "data_operazione")
    private Date fine;


    public String getData_operazione() {
        return data_operazione;
    }

    public void setData_operazione(String data_operazione) {
        this.data_operazione = data_operazione;
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

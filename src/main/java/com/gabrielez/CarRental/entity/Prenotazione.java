package com.gabrielez.CarRental.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Prenotazioni")
public class Prenotazione  implements  Serializable{
    @Id
    @Column(name = "data_operazione", length = 30, nullable = false)
    private Date dataOperazione;

    @Id
    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    private User user;

    @Id
    @OneToOne
    @JoinColumn(name = "auto", referencedColumnName = "id", nullable = false)
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

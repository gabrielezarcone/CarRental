package com.gabrielez.CarRental.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Auto")
public class Auto {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "targa", length = 30, unique = true)
    private String targa;

    @Column(name = "immatricolazione")
    private Date immatricolazione;

    @Column(name = "modello", length = 30)
    private String modello;

    @Column(name = "costruttore", length = 30)
    private String costruttore;

    @Column(name = "tipologia", length = 30)
    private String tipologia;

    public String getTarga() {
        return targa;
    }



    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Date getImmatricolazione() {
        return immatricolazione;
    }

    public void setImmatricolazione(Date immatricolazione) {
        this.immatricolazione = immatricolazione;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getCostruttore() {
        return costruttore;
    }

    public void setCostruttore(String costruttore) {
        this.costruttore = costruttore;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}

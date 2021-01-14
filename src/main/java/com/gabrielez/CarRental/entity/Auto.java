package com.gabrielez.CarRental.entity;

import javax.persistence.*;

@Entity
@Table(name = "Auto")
public class Auto {
    @Id
    @Column(name = "targa")
    private String targa;

    @Column(name = "immatricolazione")
    private String immatricolazione;

    @Column(name = "modello")
    private String modello;

    @Column(name = "costruttore")
    private String costruttore;

    @Column(name = "tipologia")
    private String tipologia;

    public String getTarga() {
        return targa;
    }



    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getImmatricolazione() {
        return immatricolazione;
    }

    public void setImmatricolazione(String immatricolazione) {
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

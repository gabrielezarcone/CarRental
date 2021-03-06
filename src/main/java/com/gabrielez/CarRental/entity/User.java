package com.gabrielez.CarRental.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", length = 30, unique = true, nullable = false)
    private String username;

    @Column(name="password", length = 30)
    private String password;

    @Column(name="name", length = 30)
    private String name;

    @Column(name="surname", length = 30)
    private String surname;

    @Column(name="birth_date")
    private Date birth_date;

    @Column(name="is_admin")
    private boolean is_admin;

    @Column(name="deleted")
    private boolean deleted;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Prenotazione> prenotazione;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Prenotazione> getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Set<Prenotazione> prenotazione) {
        this.prenotazione = prenotazione;
    }
}

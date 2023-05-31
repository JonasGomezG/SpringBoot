package com.example.conexionBD.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "dbfrutas")
@EqualsAndHashCode
@Entity
public class Fruta {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "fruta")
    private String fruta;

    public Fruta() {
    }
    public Fruta(int id, String fruta) {
        this.id = id;
        this.fruta = fruta;
    }

}

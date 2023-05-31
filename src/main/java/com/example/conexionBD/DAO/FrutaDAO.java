package com.example.conexionBD.DAO;

import com.example.conexionBD.Model.Fruta;

import java.util.List;

public interface FrutaDAO {

    List<Fruta> listarFrutas();

    void delete(int id);

    void add(Fruta fruta);

    void editar(String old_fruta, String new_fruta);

}

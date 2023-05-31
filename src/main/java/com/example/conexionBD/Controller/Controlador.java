package com.example.conexionBD.Controller;

import com.example.conexionBD.DAO.FrutaDAO;
import com.example.conexionBD.Model.Fruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    FrutaDAO frutaDAO;

    @GetMapping("/listar")
    public List<Fruta> listar(){
        return frutaDAO.listarFrutas();
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable int id){
        frutaDAO.delete(id);
    }

    @PostMapping("/añadir")
    public void add(@RequestBody Fruta fruta){
        frutaDAO.add(fruta);
    }

    @PutMapping("/editar/{old_nombre}/{new_nombre}")
    public void editar(@PathVariable String old_nombre, String new_nombre){ frutaDAO.editar(old_nombre, new_nombre); }

}

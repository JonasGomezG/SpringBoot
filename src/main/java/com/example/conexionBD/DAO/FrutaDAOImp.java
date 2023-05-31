package com.example.conexionBD.DAO;

import com.example.conexionBD.Model.Fruta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FrutaDAOImp implements FrutaDAO {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Fruta> listarFrutas() {
        String query = "FROM Fruta";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        Fruta fruta = entityManager.find(Fruta.class, id);
        entityManager.remove(fruta);
    }

    @Override
    public void add(Fruta fruta) {
        entityManager.merge(fruta);
    }

    @Override
    public void editar(String old_fruta, String new_fruta) {
        String query = "UPDATE dbfrutas SET '" + new_fruta + "' where fruta = '" + old_fruta + "'";
        entityManager.createQuery(query).getResultList();
    }


}

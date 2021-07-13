package com.example.progettospring.Tris.repository;


import com.example.progettospring.Tris.entities.Partita;
import com.example.progettospring.Tris.entities.Utente;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MyRepository {
    Map<String, Partita> partite = new HashMap<>();
    Map<String, Utente> utentiInseriti = new HashMap<>();//UUID,UTENTE

    public Map<String, Partita> getPartiteMap() {
        return partite;
    }

    public List<Partita> getPartite() {
        return new ArrayList<>(partite.values());
    }

    public List<Utente> getUtenti() {
        return new ArrayList<>(utentiInseriti.values());
    }

    public Map<String, Utente> getUtentiInseriti() {
        return utentiInseriti;
    }

    public void aggiungiUtenti() {
        /*if(numUtenti%2==0 ) this.utenti.add(new Utente(TipoMosse.mossaO));
        else this.utenti.add(new Utente(TipoMosse.mossaX));*/
        Utente nuovo = new Utente();
        this.utentiInseriti.put(nuovo.getIdUtente().toString(), nuovo);
    }


    public void aggiungiPartita(Utente utente1, Utente utente2) {
        Partita nuova = new Partita(utente1, utente2);
        this.partite.put(nuova.getIdPartita().toString(), nuova);
    }
}

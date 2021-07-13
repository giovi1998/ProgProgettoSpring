package com.example.progettospring.Tris.controller;
/*
Implementare un’applicazione Spring che permette di gestire una partita di tris.
Gli endpoint devono permettere le seguenti funzioni
● Iniziare una partita (/new)
● Resettare una partita (/reset/{matchID})
● Fare una mossa (/move/{X/O}/{pos_i}/{pos_j})
● Annullare l’ultima mossa fatta (/back)
Punto bonus
Implementare il concetto di utente/giocatore
Invece di passare X o O nel path dell’endpoint per la mossa, usare gli header per mantenere l’ID
dell’utente che sta facendo la mossa e sapere quindi quale simbolo usare (se X o O)
Punto bonus 2
Permettere all’applicazione di gestire più partite contemporaneamente
 */

import com.example.progettospring.Tris.entities.Partita;
import com.example.progettospring.Tris.entities.TipoMosse;
import com.example.progettospring.Tris.services.MyService;
import com.example.progettospring.Tris.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(value = "/creaUtente", method = RequestMethod.POST)
    public String creaUtente() {
        myService.creaUtente();
        return "Hai creato un nuovo utente";
    }


    @RequestMapping(value = "/vissualizzaUtenti", method = RequestMethod.GET)
    public Map<String, Utente> getUtenti() {
        return myService.getMyRepository().getUtentiInseriti();
    }

    @RequestMapping(value = "/aggiungiPartita/{utente1}/{utente2}", method = RequestMethod.POST)
    public String aggiungiPartita(@PathVariable String utente1, @PathVariable String utente2) {
        if (myService.getMyRepository().getUtentiInseriti().containsKey(utente1) &&
                myService.getMyRepository().getUtentiInseriti().containsKey(utente2)) {
            myService.creaPartita(utente1, utente2);
            return "Hai inserito una partita nuova";
        } else return "errore non ho trovato gli utenti ";
    }

    @RequestMapping(value = "/vissualizzaPartite", method = RequestMethod.GET)
    public Map<String, Partita> getPartite() {
        return myService.getMyRepository().getPartiteMap();
    }


    @RequestMapping(value = "/mossa/{idPartite}/{posI}/{posJ}", method = RequestMethod.POST)
    public ResponseEntity<String> Mossa(@RequestHeader UUID idUtente, @PathVariable String idPartite, @PathVariable int posI, @PathVariable int posJ) {
        if (myService.getMyRepository().getUtentiInseriti().get(idUtente.toString()).isGiocatore()) {
            if (!myService.condizioneFineGioco(idPartite)) {
                //conto il numero di mosse per vedere se ha rispettato il turno
                if (myService.countMossa(idPartite, TipoMosse.mossaO) > myService.countMossa(idPartite, TipoMosse.mossaX)
                        && myService.getMyRepository().
                        getUtentiInseriti().
                        get(idUtente.toString()).
                        getTipoDiMossa().
                        equals(TipoMosse.mossaO)) {
                    return ResponseEntity
                            .status(HttpStatus.FORBIDDEN).body("Non hai rispettato il turno");
                } else if (myService.countMossa(idPartite, TipoMosse.mossaX) > myService.countMossa(idPartite, TipoMosse.mossaO)
                        && myService.getMyRepository().
                        getUtentiInseriti().
                        get(idUtente.toString()).
                        getTipoDiMossa().
                        equals(TipoMosse.mossaX)) {
                    return ResponseEntity
                            .status(HttpStatus.FORBIDDEN).body("Non hai rispettato il turno");
                } else {
                    TipoMosse[][] tristemp = myService.getMyRepository().getPartiteMap().get(idPartite).getTris();//vedo che non sia inserito un altro valore
                    if (tristemp[posI][posJ] == TipoMosse.nessuna) {
                        myService.getMyRepository().getPartiteMap().get(idPartite).setUnaMossaDelTris(idUtente, posI, posJ);
                        return ResponseEntity
                                .status(HttpStatus.ACCEPTED).body("Hai fatto una Mossa");
                    } else return ResponseEntity
                            .status(HttpStatus.FORBIDDEN).body("Non puoi inserire in posizione " + " " + posI + " " + posJ);
                }

            } else return ResponseEntity
                    .status(HttpStatus.FORBIDDEN).body("Hai finito la partita");
        }
    else return ResponseEntity
                .status(HttpStatus.FORBIDDEN).body("Hai inserito un id utente sbagliato");

    }

    @RequestMapping(value = "/reset/{idPartite}", method = RequestMethod.POST)
    public ResponseEntity<String> reset(@PathVariable String idPartite) {
        if (myService.getMyRepository().getPartiteMap().get(idPartite) == null) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN).body("errore non ho trovato la partita con id " + idPartite);
        }

        myService.resetPartita(idPartite);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED).body("hai resetato la partita");
    }

    @RequestMapping(value = "/back/{idPartite}", method = RequestMethod.POST)
    public ResponseEntity<String> backToLastMove(@PathVariable String idPartite) {
        if (myService.getMyRepository().getPartiteMap().get(idPartite) == null) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN).body("errore non ho trovato la partita con id " + idPartite);
        }

        myService.getMyRepository().getPartiteMap().get(idPartite).backUltimaMossa();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED).body("sei tornato indietro la partita");
    }


}
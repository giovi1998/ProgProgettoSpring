package com.example.progettospring.Tris.entities;

import java.util.UUID;


public class Utente {
    private UUID idUtente;
    private TipoMosse tipoDiMossa = TipoMosse.nessuna; //X nessuno o O come tipo di mosse;
    private boolean giocatore=false;
    public Utente() {
        setIdUtente();
    }

    public UUID getIdUtente() {
        return idUtente;
    }

    public void setIdUtente() {
        this.idUtente = UUID.randomUUID();
    }

    public boolean isGiocatore() {
        return giocatore;
    }

    public void setGiocatore(boolean giocatore) {
        this.giocatore = giocatore;
    }

    public void setTipoDiMossa(TipoMosse tipoDiMossa) {
        this.tipoDiMossa = tipoDiMossa;
    }

    public TipoMosse getTipoDiMossa() {
        return tipoDiMossa;
    }

}

package com.example.progettospring.Tris.entities;

import java.util.*;

public class Partita {
    private UUID idPartita;
    private TipoMosse[][] tris;
    private Utente utente1;
    private Utente utente2;
    private int dimensioneMatrix = 3;
    Queue<List<Integer>> tipoMosse = new LinkedList<>();


    public Partita(Utente utente1, Utente utente2) {
        this.idPartita = UUID.randomUUID();
        this.utente1 = utente1;
        this.utente2 = utente2;
        utente1.setGiocatore(true);
        utente2.setGiocatore(true);
        setMosse();
        inizializzaMatrice();
    }

    public void inizializzaMatrice() {
        this.tris = new TipoMosse[dimensioneMatrix][dimensioneMatrix];
        for (int i = 0; i < dimensioneMatrix; i++) {
            for (int j = 0; j < dimensioneMatrix; j++) {
                this.tris[i][j] = TipoMosse.nessuna;
            }
        }
    }

    public TipoMosse[][] getTris() {
        return tris;
    }

    public Utente getUtente1() {
        return utente1;
    }

    public void setUtente1(Utente utente1) {
        this.utente1 = utente1;
    }

    public Utente getUtente2() {
        return utente2;
    }

    public void setUtente2(Utente utente2) {
        this.utente2 = utente2;
    }

    public UUID getIdPartita() {
        return idPartita;
    }

    public void setMosse() {
        int num = new Random().nextInt(2);
        if (num == 1) {
            utente1.setTipoDiMossa(TipoMosse.mossaO);
            utente2.setTipoDiMossa(TipoMosse.mossaX);
        } else {
            utente1.setTipoDiMossa(TipoMosse.mossaX);
            utente2.setTipoDiMossa(TipoMosse.mossaO);
        }

    }

    public void setUnaMossaDelTris(UUID idUtente, int posI, int posJ) {
        if (utente1.getIdUtente().equals(idUtente)) {
            this.tris[posI][posJ] = utente1.getTipoDiMossa();
            List<Integer> mossa = new ArrayList<>();
            mossa.add(posI);
            mossa.add(posJ);
            tipoMosse.add(mossa);
        } else this.tris[posI][posJ] = utente2.getTipoDiMossa();
    }

    public void backUltimaMossa() {
        List<Integer> mossa = tipoMosse.poll();
        int posI = mossa.get(0);
        int posJ = mossa.get(1);
        tris[posI][posJ] = TipoMosse.nessuna;
    }
}

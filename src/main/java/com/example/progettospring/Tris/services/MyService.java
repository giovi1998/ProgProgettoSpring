package com.example.progettospring.Tris.services;

import com.example.progettospring.Tris.entities.Partita;
import com.example.progettospring.Tris.entities.TipoMosse;
import com.example.progettospring.Tris.entities.Utente;
import com.example.progettospring.Tris.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private MyRepository myRepository;

    @Autowired
    public void myService(MyRepository repository) {
        this.myRepository = repository;
    }

    public void creaUtente() {
        myRepository.aggiungiUtenti();
    }

    public long numeroUtenti() {
        return myRepository.getUtenti().size();
    }

    public void creaPartita(String utenteId1, String utenteId2) {
        /*Collections.shuffle(myRepository.getUtenti());
        Utente utente1=myRepository.getUtenti().stream().filter(u->u.isTipoDiMossa().equals(TipoMosse.mossaO)).findFirst().orElse(null);
        Utente utente2=myRepository.getUtenti().stream().filter(u->u.isTipoDiMossa().equals(TipoMosse.mossaX)).findFirst().orElse(null);        */
        Utente utente1 = myRepository.getUtentiInseriti().get(utenteId1);
        Utente utente2 = myRepository.getUtentiInseriti().get(utenteId2);
        //Utente utente2=myRepository.getUtenti().stream().filter(s->s.getIdUtente().toString().equals(utenteId2)).findFirst().orElse(null);
        myRepository.aggiungiPartita(utente1, utente2);
    }


    public MyRepository getMyRepository() {
        return myRepository;
    }

    public boolean condizioneFineGioco(String idPArtita) {
        Partita temp = myRepository.getPartiteMap().get(idPArtita);
        TipoMosse[][] trisTemp = temp.getTris();
        if (rigaTuttaUguale(trisTemp, TipoMosse.mossaO) || rigaTuttaUguale(trisTemp, TipoMosse.mossaX)) return true;
        if (colonnaTuttaUguale(trisTemp, TipoMosse.mossaO) && colonnaTuttaUguale(trisTemp, TipoMosse.mossaX))
            return true;
        if (diagonale(trisTemp, TipoMosse.mossaO) && diagonale(trisTemp, TipoMosse.mossaX)) return true;
        return fineGioco(trisTemp);
    }

    public boolean rigaTuttaUguale(TipoMosse[][] Riga, TipoMosse mossa) {
        if (Riga[0][0] == mossa && Riga[0][1] == mossa && Riga[0][2] == mossa) {
            return true;
        }
        if (Riga[1][0] == mossa && Riga[1][1] == mossa && Riga[1][2] == mossa) {
            return true;
        }
        return Riga[2][0] == mossa && Riga[2][1] == mossa && Riga[2][2] == mossa;
    }

    public boolean colonnaTuttaUguale(TipoMosse[][] Riga, TipoMosse mossa) {
        if (Riga[0][0] == mossa && Riga[1][0] == mossa && Riga[2][0] == mossa) {
            return true;
        }
        if (Riga[0][1] == mossa && Riga[1][1] == mossa && Riga[2][1] == mossa) {
            return true;
        }
        return Riga[0][2] == mossa && Riga[1][2] == mossa && Riga[2][2] == mossa;
    }

    public boolean diagonale(TipoMosse[][] Riga, TipoMosse mossa) {
        if (Riga[0][0] == mossa && Riga[1][1] == mossa && Riga[2][2] == mossa) {
            return true;
        }
        return Riga[2][2] == mossa && Riga[1][1] == mossa && Riga[0][2] == mossa;
    }

    public boolean fineGioco(TipoMosse[][] tris) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tris[i][j] == TipoMosse.nessuna) return false;

            }
        }
        return true;
    }

    public int countMossa(String idPartita, TipoMosse mossa) {
        int count = 0;
        Partita temp = myRepository.getPartiteMap().get(idPartita);
        TipoMosse[][] trisTemp = temp.getTris();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (trisTemp[i][j] == mossa) count++;
            }
        }
        return count;
    }

    public void resetPartita(String idPartita) {
        Partita temp = myRepository.getPartiteMap().get(idPartita);
        temp.inizializzaMatrice();
    }

}

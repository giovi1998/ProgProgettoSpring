#Tris

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
 

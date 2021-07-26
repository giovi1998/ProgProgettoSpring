# Tris
<p align="center">
<img src="https://media.istockphoto.com/photos/top-view-of-tic-tac-toe-game-on-wooden-toy-blocks-against-orange-picture-id1208578184?k=6&m=1208578184&s=612x612&w=0&h=N2bIUq7qHUKcmOq2-pbsNR3wNGtoYPvySad9JvTIZZk="  class="center">
</p>

Implementare un’applicazione Spring che permette di gestire una partita di tris.
Gli endpoint devono permettere le seguenti funzioni
<p>
● Iniziare una partita (/new)
 </p>
 <p>
● Resettare una partita (/reset/{matchID})
 </p>
 <p>
● Fare una mossa (/move/{X/O}/{pos_i}/{pos_j})
 </p>
  <p>
● Annullare l’ultima mossa fatta (/back)
 </p>


## Punto bonus
Implementare il concetto di utente/giocatore
Invece di passare X o O nel path dell’endpoint per la mossa, usare gli header per mantenere l’ID
dell’utente che sta facendo la mossa e sapere quindi quale simbolo usare (se X o O)
Punto bonus 2
Permettere all’applicazione di gestire più partite contemporaneamente
 

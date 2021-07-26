# Tris
<img src=https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.istockphoto.com%2Fit%2Fimmagine%2Ftris&psig=AOvVaw2tmsiTxCun1jaO8ATBBHkt&ust=1627401753970000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIj8ko2OgfICFQAAAAAdAAAAABAD> 

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
 

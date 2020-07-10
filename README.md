# Gestionale Aziendale IGPE
**For eng version -> go down.**

Gestionale aziendale
Ho deciso di pubblicare questo codice in seguito al completamento con successo dell'esame IGPE (Interfacce Grafice e Programmazione ad Eventi) all'Unical Università della Calabria.
Il progetto non ha potuto conseguire il massimo punteggio per via di alcuni errori di programmazione e gestione dei dati, uno tra i quali, il login, ma, nonostante ciò, ho deciso comunque di pubblicare la sorgente in total per dare, a chi vorrà, la possibilità di contribuire allo sviluppo del progetto nel caso in cui lo ritenesse opportuno.

# Materiale usato per lo sviluppo
- Crediti immagini: https://www.flaticon.com/authors/monkik - Free
- JavaFX - Free
- JavaSE-1.8 - Free
- SceneBuilder - Free
- sqlite-jdbc-3.30.1 - Free
- Eclipse - Free

# Struttura del progetto
Il progetto non è stato strutturato in model, view e controller unico bensì ogni scena ha la propria parte grafica e la propria parte logica.
Sono presenti 9 package:
- catalogo_e_magazzino: File grafici -> 3 | File logici -> 4
- imprenditore_package: File grafici -> 1 | File logici -> 5
- - imprenditore_package.Dati: File grafici -> 4 | File logici -> 0
- libro_giornale: File grafici -> 3 | File logici -> 3
- login_package: File grafici -> 1 | File logici -> 1
- reparti_di_produzione: File grafici -> 1 | File logici -> 1
- - reparti_di_produzione.reparti: File grafici -> 3 | File logici -> 3
- statistiche_package: File grafici -> 1 | File logici -> 1
- util_package: File grafici -> 1 | File logici -> 6

# UTIL -> Main, DataBase, Interfacce(scene), Messaggi d'errore, Util(operazioni)
- **Main**
All'interno della classe main vado a richiamare tutti i file .fxml relativamente principali al fine di poterli passare al gestore delle interfacce che potrà catalogare ogni file con una determinata chiave in maniera tale da poterlo acquisire quando si vuole in qualunque parte del programma.
- **Database**
All'interno del database non ho implementato altro che un metodo statico che possa restituire la connessione che, come vedremo, verrà usata nella classe *Util* per svolgere le operazioni dove la richiede.
- **Interfacce**
Una banale classe che gestisce, tramite un HashMap, le varie finestre(file .fxml) in base a una stringa determinata dall'add(...).
- **Messaggi d'errore**
Una classe che banalmente gestisce tutti i messaggi d'errore.
- **Util**
Beh... signori... il cuore del programma... anzi... cuore, mente, corpo... un po' tutto... gestisce tutte le richieste particolari dei *Dati Aziendali - Reparti di produzione - Catalogo e magazzino - Libro giornale - Statistiche *... non voglio commentare tutto perché ci sarebbe davvero troppo da scrivere e mi secca...

# Login
Il login viene gestito in un modo molto semplice, forse troppo... Non andando ad acquisire i dati opportunamente da un database si è mette a rischio l'intera funzionalità e validità del gestionale, ma, come citato a priori, questo non è un gestionale valido al 100% bensì è un progetto d'esame che è stato valutato parzialmente corretto.
Tramite il metodo *initialize* vado a settare l'immagine background del login.
Viene usata un HashMap per il controllo del login tramite il metodo *login()*.

# Home page
L'home page è stata creata in maniera tale da dare all'utente la possibilità di decidere quale pagina aprire avendo la possibilità di scegliere tra libro giornale, reparti di produzione, catalogo e magazzino e statistiche.
Cliccando su di loro si avrà la possibilità di avere una prima visione della pagina che si andrà ad aprire.
L'acquisizione della pagina in base al click è determinata dal metodo *visualizzaDati(...)* in 'InterfacciaImprenditore.java' dove, in base al click, quindi in base ad un *ActionEvent*, passo il nome del file da aprire.
*I file da aprire possono essere visti a livello grafico in imprenditore_package.Dati invece a livello logico in imprenditore_package*

# Libro giornale
Il libro giornale è rappresentato da una TableView con 7 colonne. I dati attualmente inseriti non sono minimamente controllati quindi qualunque economista all'ascolto si può preparare a qualche infarto...
Gli eventi possibli sono *Aggiungi voce - Modifica voce - Elimina voce - Scarica* dove nei primi adue casi vado a creare un Alert con, come contenuto, un .fxml che gestisca tutte le informazioni nuove o da modificare. Elimina voce invece elimina la voce selezionata sulla table view. Scarica apre un pop-up che da all'utente la possibilità di scaricare in attualmente al più 3 formati tutto il libro giornale.
Tutti i metodi richiedente l'utilizzo del database vengono gestiti dalla classe Util, mentre Scarica no.

# Reparti di produzione
In questa pagina si può fare ben poco se non vedere l'utilizzo di uno split pane, qualche scrollbar e altri elementi di JavaFX.
Ricordo che è un progetto a livello studentesco con pochi mesi di tempo e fatto mentre imparavo a farlo.

# Catalogo e magazzino
Gestisco il catalogo e magazzino con una table view collegata ad un database che riporta 7 colonne dove però l'ultima non è gestita dal database bensì dalla classe *prodotto* siccome è un dato variabile. Vi sono le seguenti funzionalità *Cerca, Annulla(ricerca), Aggiungi, Modifica, Elimina* dove cercando utilizzo le query di ricerca quindi ad esemprio %Pho% -> tutti gli elementi che hanno Pho all'interno della stringa e così via... Annulla serve per ripristinare la TableView. Aggiungi e Modifica per aggiungere o modificare un prodotto ed Elimina va a rimuovere un prodotto sia dalla TableView sia, ovviamente, dal database.

# Statistiche
In una pagina chiamata **Statistiche** cosa vi aspettate? Beh mi dispiace deludervi ma c'è ben poco di statistica... Per via del poco tempo che mi rimaneva per completare il progetto ho dovuto creare qualcosa che potesse trasformare i dati in informazioni valide. Di fatti ho usato un BarChar per visualizzare l'andamento aziendale e una TextArea per generare un commento in base ai movimenti economici/finanziari dell'azienda, quindi, in base al libro giornale. Le uniceh funzionalità sono la generazione del commento e il ricaldolo dei dati, decisamente utile nel caso in cui si aggiornasse il libro giornale senza far ripartire il progamma.

# Menu
IL menu è identico per tutte le pagine, meno che per il login.
Riporta le seguenti vodi:
- File: *Home* che ti riporta alla home page, *Dati aziendali* che ti mostra i dati aziendali (anche questi dati vengono gestiti dal database), *Email veloce* apre l'applicazione preferita per mandare email senza alcun ricevente, *Esci* ti fa ritornare alla scheramta di Login.
- Visualizza: "Teletrasportatore" tra le pagine senza passare dalla Home.
- Opzioni: Unica parte del menu, unica per ogni pagina.
- Aiuto: *Crediti* mostra i crediti del programma tramite un Alert e *Contatta l'assistenza* richiama il software per email predefinito inserendo nel destinatario la mia email.

***Work in progess for Eng version...***

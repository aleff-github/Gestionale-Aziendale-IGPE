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

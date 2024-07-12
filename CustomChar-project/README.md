**Beskrivelse av appen**
CustomChar er en app hvor en bruker skal kunne lage og tilpasse en karakter. Brukeren skal ha flere måter å tilpasse karakteren gjennom å trykke på knapper, som for eksempel å velge karakterens farge og kjønn. Et bilde av hvordan karakteren ser ut
skal være lett synlig for brukeren, og dette bildet vil forandre seg hver gang brukeren trykker på en knapp for å redigere karakteren. Denne forandringen skal reflektere brukerens valg. Etter brukeren er fornøyd med karakteren de har laget skal de 
kunne lagre den i skyen, slik at de kan hente den igjen senere og fortsette å redigere.

**Brukerhistorie**

Som privatperson ønsker jeg underholdning og muligheten til å lage og tilpasse en karakter på, så jeg er sikker på at jeg alltid har en måte å tilfredstille skapertrangen min på.

Brukeren har behov for å kunne velge kjønn på karakteren, velge karakterens farge og hårstil, og legge til tilbehør som for eksempel en hatt eller briller.

Viktig å kunne se:
1. En oversikt over de forskjellige tilpasningvalgene
2. Selve karakteren slik at brukeren kan se hvordan den ser ut før og etter de har tilpasset den

Viktig å kunne gjøre:
1. Tilpasse kjønn, farge, hårstil, og tilbehør
2. Lagre karakteren slik at man kan hente den opp igjen senere


**Skjermbilde**
![Skjermbilde](../../../../../../fxui/src/main/resources/customChar/ui/images/screenshots/screenshotOfLayout.png)
![Skjermbilde](../../../../../../fxui/src/main/resources/customChar/ui/images/screenshots/screenshotOfLayout2.png)

**Refleksjon over fillagring**

Vi har valgt å bruke dokumentmetafor. Når brukeren trykker på "save" knappen lagres CustomChar objektet i en .txt fil, som brukeren kan hente opp igjen senere hvis de trykker på "load". Vi valgte å bruke dokumentmetafor siden det er mer praktisk for funksjonaliteten av appen. På denne måten kan brukeren velge selv når de vil lagre, og hvilken versjon av karakteren sin de vil lagre. Brukeren kan også velge et navn de vil lagre karakteren med og hvilke karakter som lastes inn. Det ville heller ikke gitt mening å ha implisitt lagring for en slik app, fordi da vil karakteren bli overskrevet etter hver endring, noe som er både unødvendig og upraktisk.


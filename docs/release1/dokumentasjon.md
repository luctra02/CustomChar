[NO](#Introduksjon)

# <a name="Introduksjon"></a>Introduksjon
CustomChar er det forkortede appnavnet for Custom Character, som er en applikasjon designet for å lage din egen enkle pikselkarakter og designe den slik du vil. Dette er implementert som en kombinasjon av en JavaFX-app.

# Design
Da vi startet designprosessen av applikasjonen hentet vi inspirasjon fra spill som inkluderer karaktertilpasning. Spillene som vi tok det største aspektet av design fra var Among Us og Lost ark på grunn av deres brede utvalg av skins, antrekk og andre tilpasningsmuligheter. Vi valgte det vi anså for å være de viktigste aspektene ved spillene, nemlig farge, tilbehør, hår og kjønn.
For å designe applikasjonen lagde vi sketcher og så på referanser fra spillene nevnt tidligere, før vi begynte å lage basen til brukergrensesnittet. Vi tenkte deretter å designe de forskjellige hårstilene og accessoriene, i tillegg til en mannlig og en kvinnelig basekarakter. Vi bestemte oss for å at den beste og mest effektive måten å gjøre dette på var å lage pixel art, siden det er lett å designe i tillegg til at det føles litt nostalgisk.
Vi hadde opprinnelig lyst til at brukeren skulle ha muligheten til å sette arr og briller på karakteren sin, men endte opp med å bare beholde hattene vi hadde designet for det ekstra tilbehøret brukeren kunne velge. Vi bestemte oss for dette siden det var vanskelig å få brillene og arrene til å passe med selve figuren og fargen på figuren med en så simpel pixel stil som den vi valgte. Vi skal vurdere å prøve å få det til å funke igjen senere, men for release 1 vil "extra" tabben bare inneholde noen få hatter. Alternativt kan vi også legge til flere forskjellige typer hatter, men dette er noe vi skal bestemme oss for senere.



# Utvikling
I begynnelsen av utviklingen måtte vi bli enige om klassestrukturen og de store modulene som trengs for at programmet skal fungere, samt en filstruktur som ville være enkel å navigere og forstå. Vi tok inspirasjon fra oppsettet i den indviduelle øvingen vi hadde tidligere i faget, og ble enige om hvordan dette skulle se ut ganske fort.
Etter vi var ferdig med basen til brukergrensesnittet og alle tilpasningsmulighetene hadde blitt ferdig designet kunne vi starte å jobbe på backend delen av prosjektet. Appen har ikke altfor mye funskjonalitet, og de fleste knappene gjør lignende ting, så "model" delen av prosjektet ble ganske simpel, og har for det meste bare getter- og setter metoder.
Siden vi bestemte oss for at brukernavnet ikke kunne være hva som helst, og la til validering for å sjekke om brukernavnet var gyldig, lagde vi en test som sjekket om valideringen fungerte som forventet. Vi valgte også å skrive tester for selve appen, for å se om knappene i brukergrensesnittet også fungerer som forventet.
Vi ville gi brukeren muligheten til å endre fargen på karakteren sin, men vi slet litt i starten med hva den beste måten å implementere fargeforskjellene på var. Vi ønsket ikke å ha masse forskjellige bilder av samme figur med forskjellige farger. Etter hvert fant vi en bedre måte å gjøre det på, nemlig å sette en "hue" på figuren, og forandre på denne verdien for å forandre fargen. På denne måten slapp vi å måtte bytte bilde av karakteren som vises i brukergrensesnittet hver gang brukeren endret på fargen.
Resten av utviklingen av kontrolleren og filbehandlingen gikk veldig greit, med få problemer.
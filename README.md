# Group gr2210 repository 
 
Appen handler om å **designe en karakter**.

Karakteren **lagres i skyen**.

Brukeren kan **redigere karakteren** som ligger i skyen 

eller **lage nye karakterer**.

Kodingsprosjektet ligger i mappen **customChar**


## Kjøring i Gitpod

[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2210/gr2210)

## Bygging og kjøring av prosjektet
CustomChar prosjektet bruker maven til bygging og kjøring.

   
1. Clone git repositorien
```
git clone https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2210/gr2210.git
```
2. Kjør
```
mvn install
``` 
3. Kjør serveren med

```
mvn -pl springboot/restserver spring-boot:run
```
4. Åpne en ny terminal, prosjektet må kjøres fra fxui-modulen, enten med
```
mvn javafx:run -f CustomChar-project/fxui/pom.xml
```

## Oppdeling
CustomChar prosjektet er delt opp tre moduler. Den ene modulen, som vi har kalt "core", er for kjernekoden (selve logikken). Denne modulen inneholder bare én klasse, CustomChar.java, spm inneholder all logikken. Den andre modulen, "fxui", er for brukergrensesnittet. "fxui" modulen inneholder app klassen, controller klassen, og en ChangeColor klasse som skifter på fargene på figuren og håret i appen. "springboot" er brukt til å sette opp lokal server.

## Dokumentasjon
Se beskrivelse om kode [Her](CustomChar-project/README.md)

### Release notes
[Release1](docs/release1/dokumentasjon.md)

[Release2](docs/release2/dokumentasjon.md)

[Release3](docs/release3/dokumentasjon.md)

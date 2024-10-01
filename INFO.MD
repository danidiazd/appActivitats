# Prova Backend Hackató Saló Ocupació

## El vostre repte consisteix a desenvolupar una API per a una aplicació web que gestioni usuaris i activitats. Aquest servei ha de permetre el registre d'usuaris, la gestió de dades de les activitats i la importació/exportació d'aquestes activitats en format JSON.

### Requisits tècnics

    1. Gestió d'Usuaris: Pots utilitzar les dades dels usuaris que consideris: nom, cognoms,
    edad, email...
    • Registre de nous usuaris
    • Actualització de dades de l'usuari:
    • Eliminació d'usuaris
    • Consulta d'informació d'usuaris.
    
    2. Gestió d'activitats:
    • Creació d'una nova activitat
    • Consulta d'activitats
    • Apuntar-se a una activitat
    
    3. Exportació d'activitats:
    • Exportar activitats en format JSON
    
    4. Importació d'activitats:
    • Importar activitats des d'un arxiu JSON
    
    5. Configuració de la Base de Dades:
    • Establir una connexió amb una base de dades, que pot ser MySQL o
      MongoDB, per emmagatzemar les dades d'usuaris i activitats.

### Endpoints de l’API

            Aquí teniu l’exemple dels endpoints de l’apartat d’usuaris, crea els endpoints necessaris per
            gestionar la resta de l’aplicació.
            Usuaris:
            • POST /appActivitats/user: Registre d'un nou usuari.
            • PUT /appActivitats/users/:id: Actualització de les dades d'un usuari.
            • GET /appActivitats/users/:id: Consulta de la informació d'un usuari.
            • DELETE /appActivitats/users/:id: Eliminació d'un usuari.

## Requisits Tècnics i Avaluació

      • L’aplicació compleix amb els requisits funcionals especificats.
      • El codi segueix bones pràctiques de programació.
      • El projecte segueix un patró estructural.
      • Les funcions tenen una única responsabilitat.
      • El codi és escalable i reutilitzable.
      • El codi està optimitzat i el seu rendiment és eficient.
      • Proporcionar una documentació acurada en el Readme del repositori.

## Lliurament

      Un cop hagis completat la prova tècnica, envia el teu projecte com un repositori de Git
      (com a resposta a aquest mail) i proporciona instruccions clares sobre com executar-lo
      localment. Assegura't d'incloure un arxiu README amb els detalls del projecte i com s'han
      complert els requisits.

## Molta sort! Esperem veure el teu projecte!
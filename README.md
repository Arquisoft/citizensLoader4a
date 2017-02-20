# citizensLoader4a

[![Join the chat at https://gitter.im/Arquisoft/citizensLoader4a](https://badges.gitter.im/Arquisoft/citizensLoader4a.svg)](https://gitter.im/Arquisoft/citizensLoader4a?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/Arquisoft/citizensLoader4a.svg?branch=master)](https://travis-ci.org/Arquisoft/citizensLoader4a)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e680327c40a44a6b8378a8171066e341)](https://www.codacy.com/app/jelabra/citizensLoader4a?utm_source=github.com&utm_medium=referral&utm_content=Arquisoft/citizensLoader4a&utm_campaign=badger)
[![codecov](https://codecov.io/gh/Arquisoft/citizensLoader4a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/citizensLoader4a)

Citizens Loader module

# Authors

- Herminio García González (@herminiogg)
- Jose Emilio Labra Gayo (@labra)
- Ana Bravo Mediavilla 
- Javier Castro Fernández (@javiercasfer95 || @javitxu1995)
- Pelayo García Lartategui (@pelayolartategui)

# Comandos soportados

          - readExcel fichname -> permite cargar y leer el fichero "fichname"
          .xlsx
  
          - readTxt filename -> permite cargar y leer el fichero "fichname"
          .txt
  
          - sendPDF -> Manda una carta en PDF a todos los ciudadanos leidos. Es
          necesario poner la lectura antes, es decir: readXXX filename sendPDF
          
          - sendTXT -> Manda una carta en TXT a todos los ciudadanos leidos. Es
          necesario poner la lectura antes, es decir: readXXX filename sendTXT
          
          - sendDOC -> Manda una carta en DOC a todos los ciudadanos leidos. Es
          necesario poner la lectura antes, es decir: readXXX filename sendDOC
 

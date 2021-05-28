# Pokedex
Cette application permet de visualiser un Pokedex avec une liste de Pokémons. 
Cette liste est chargée à partir de l'API Rest PokeApi disponible à l'adresse suivante : "https://pokeapi.co/api/v2/"
Elle permet lors de la séléction d'un Pokémon d'afficher les détails sur un élément plus particulièrement le nom et un lien pour plus d'informations complémentaires.

# Prérequis
Avoir installé l'IDE : Android Studio
Télécharger la branche develop de ce projet

# Consignes
  Consignes de base :
  - Ecran avec liste d'éléments
  - Ecran avec détail d'éléments
  - Appel WebService à une API Rest
  - Stockage de données en cache

  Consignes en plus :
   - Architecture Singletons
   - Design Patterns
   - MVC/MVP/MVVM
   - Principes (SOLID,KISS,DRY)
   - Firebase (Base de donnée en temps réel)

### Screen ###

Lorsqu'on lance l'application, nous avons les données chargé du cache avec la liste des éléments de l'API Rest PokeApi. Cette liste permet de récupérer l'image ainsi que le nom de chaque pokémon (dans notre cas, nous affichons 20 pokémons)

![image](https://user-images.githubusercontent.com/84411180/119989930-09942400-bfc8-11eb-8366-ea83905ba4a5.png)

Lorsqu'on clique par exemple sur un pokémon, dans notre cas : 'ratata', nous obtenons le résultat suivant :

![image](https://user-images.githubusercontent.com/84411180/119990197-57109100-bfc8-11eb-9464-f0b763935c42.png)

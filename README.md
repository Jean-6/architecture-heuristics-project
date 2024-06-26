# TodoDone

## Explication de code

1. Task.java :

    * La classe `Task` encapsule les détails d'une tâche, y compris sa description et son état (complétée ou non).
    * Elle fournit des méthodes pour marquer la tâche comme complétée ou en attente, et une méthode toString pour représenter la tâche sous forme de chaîne.
    

2. TodoList.java :

   * Cette  classe gère une collection de tâches.
   * Elle permet d'ajouter, de supprimer, de marquer comme complétée ou en attente, et d'afficher les tâches.


3. Main.java :

   * La classe Main contient une boucle principale qui gère l'interface utilisateur.
   * Elle lit les commandes de l'utilisateur, les interprète et appelle les méthodes appropriées de la classe `TodoList`.


## Qualité de code :

   * **Encapsulation** : Les détails de l'implémentation des tâches sont cachés dans la classe Task.
   * **Séparation des préoccupations** : La logique de gestion des tâches est séparée de la logique de l'interface utilisateur.
   * **Clarté** : Les méthodes ont des noms explicites et suivent des conventions de nommage claires.
   * **Robustesse** : Le code vérifie les entrées utilisateur et gère les cas où les index sont hors limites.

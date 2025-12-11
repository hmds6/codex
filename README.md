# Labyrinth

Projet JavaFX démontrant l’architecture MVC, le patron Command pour Undo/Redo et une façade pour contrôler l’accès au modèle.

## Lancer l’application

```bash
mvn javafx:run
```

> Astuce : l’erreur « JavaFX runtime components are missing » survient si l’application est lancée sans module-path JavaFX.
> Le but `mvn javafx:run` configure automatiquement ce chemin. Dans IntelliJ IDEA, choisissez « Run » > « Edit Configurations… » puis définissez
> le type « Maven » avec la commande `javafx:run` pour bénéficier de la même configuration.

### Windows : commandes rapides

Deux options Maven qui configurent automatiquement le module-path et évitent l’erreur « JavaFX runtime components are missing » :

1. **Plugin JavaFX (recommandé)**
   ```cmd
   scripts\run-windows.bat
   ```
   ou directement dans un terminal :
   ```bash
   mvn -DskipTests javafx:run
   ```

2. **Plugin Exec (utile si le but JavaFX est bloqué dans votre IDE)**
   ```bash
   mvn -DskipTests exec:java
   ```
   Cette commande construit le classpath complet (y compris les dépendances JavaFX Windows) avant de lancer `com.example.labyrinth.view.App`, ce qui supprime le message d’erreur rencontré avec une simple commande `java.exe` manuelle.

Dans IntelliJ IDEA, préférez une configuration « Maven » avec `javafx:run` ou `exec:java` plutôt qu’une configuration « Application » classique.

## Tests

```bash
mvn test
```

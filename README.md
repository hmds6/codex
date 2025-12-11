# Labyrinth

Projet JavaFX démontrant l’architecture MVC, le patron Command pour Undo/Redo et une façade pour contrôler l’accès au modèle.

## Lancer l’application

```bash
mvn javafx:run
```

> Astuce : l’erreur « JavaFX runtime components are missing » survient si l’application est lancée sans module-path JavaFX.
> Le but `mvn javafx:run` configure automatiquement ce chemin. Dans IntelliJ IDEA, choisissez « Run » > « Edit Configurations… » puis définissez
> le type « Maven » avec la commande `javafx:run` pour bénéficier de la même configuration.

### Windows : commande rapide

Sous Windows, utilisez le script fourni qui invoque directement le but Maven avec le module-path correctement configuré :

```cmd
scripts\run-windows.bat
```

Vous pouvez également créer une configuration d’exécution dans IntelliJ IDEA de type « Maven » avec la commande `javafx:run` : cela évite les erreurs « JavaFX runtime components are missing » rencontrées avec une simple commande `java.exe`.

## Tests

```bash
mvn test
```

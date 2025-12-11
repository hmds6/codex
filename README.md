# Labyrinth

Projet JavaFX démontrant l’architecture MVC, le patron Command pour Undo/Redo et une façade pour contrôler l’accès au modèle.

## Lancer l’application

```bash
mvn javafx:run
```

> Astuce : l’erreur « JavaFX runtime components are missing » survient si l’application est lancée sans module-path JavaFX.
> Le but `mvn javafx:run` configure automatiquement ce chemin. Dans IntelliJ IDEA, choisissez « Run » > « Edit Configurations… » puis définissez
> le type « Maven » avec la commande `javafx:run` pour bénéficier de la même configuration.

## Tests

```bash
mvn test
```

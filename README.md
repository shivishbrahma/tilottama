# Tilottama

A Java based multi-tasking command line interface bot.

## Features

- CPU info
  - `cpu`
  - `os`
  - `user`

- Weather and Forecast
  - `(weather/forecast) --city <cityname>`
    - weather --city Chennai
    - weather --city 'Navi Mumbai'
    - weather --city "New Delhi"
  - `(weather/forecast) --lat <latitiude> --lon <longitude>`

- Converter App
  - `currency <amount> <from> <to>`
  - `temperature <value> (C/F/K) (C/F/K)`

- Wikipedia
  - `wiki <topic>`

- Today in History: `today`

- Number Trick
  - Pi : `pi <digits>`
  - Roll Dice :`roll`
  - Flip Coin: `coin`

- Exits : `bye` `exit`

## Maven commands

### Build and run

- Build the package with all dependencies

```sh
mvn clean properties:write-project-properties compile assembly:single
```

- Run the jar

```bash
java -jar ./target/tilottama-0.0.1-jar-with-dependencies.jar
```

### Build and test

```bash
mvn clean install
```

### Generate Javadoc

```bash
mvn javadoc:javadoc
```

### Publish properties from pom

```bash
mvn properties:write-project-properties
```

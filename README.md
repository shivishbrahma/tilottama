# Tilottama

A Java based multi-tasking command line interface bot.

## Features

- CPU info

  - `cpu`
  - `os`
  - `user`
- Weather and Forecast

  - `(weather/forecast) city <cityname>`
  - `(weather/forecast) lat <latitiude> lon <longitude>`
- Currency Converter

  - `currency <amount> <from> <to>`
- Temperature Converter
  - `temperature <value> (C/F/K) (C/F/K)`
- Wikipedia
  - `wiki <topic>`

- Today in History: `today`

- Number Trick
  - Pi : `pi <no_of_digits>`
  - Roll Dice :`roll`
  - Flip Coin: `coin`

## Maven commands

### Build and run

- Build the package with all dependencies

```sh
mvn clean compile assembly:single
```

- Run the jar

```sh
java -jar ./target/tilottama-0.0.1-jar-with-dependencies.jar
```

### Build and test

```sh
mvn clean install
```

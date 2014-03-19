CREATE TYPE Region AS ENUM ('Europe', 'Asie', 'Océanie', 'Amérique', 'Afrique');

CREATE TABLE Station (
    idStation int PRIMARY KEY,
    nomStation text,
    capacite int, 
    lieu text, 
    region Region,
    tarif real);

CREATE TABLE Client (
    id int PRIMARY KEY,
    nom text, prenom text,
    ville text,
    region Region,
    solde real);

CREATE TABLE Activite (
    idStation int REFERENCES Station,
    libelle text,
    PRIMARY KEY (idStation, libelle),
    prix real CHECK (prix >= 0));

CREATE TABLE Sejour (
    id int REFERENCES Client,
    idStation int REFERENCES Station,
    debut date,
    PRIMARY KEY (id, idStation, debut),
    nbPlaces int);

INSERT INTO Station VALUES
  (1, 'Venusa', 200, 'Guadeloupe', 'Amérique', 1200),
  (2, 'Le Riad', 60, 'Marrakech', 'Afrique', 2270);

INSERT INTO Activite VALUES
  (1, 'Voile', 150),
  (1, 'Plongée', 120),
  (2, 'Hammam', 0);

INSERT INTO Client VALUES
  (1, 'Fogg', 'Phileas', 'Londres', 'Europe', 12465),
  (2, 'Pascal', 'Blaise', 'Paris', 'Europe', 6763),
  (3, 'Kerouac', 'Jack', 'New York', 'Amérique', 9812);

INSERT INTO Sejour VALUES
  (1, 1, '1998-08-03', 4),
  (1, 1, '2004-07-22', 2),
  (2, 2, '2007-09-03', 2);

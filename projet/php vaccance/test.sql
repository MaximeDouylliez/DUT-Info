
drop database inventaire;

create database inventaire;

use inventaire;

create table Salle(
idsalle serial PRIMARY KEY,
nomsalle varchar(20),
descriptionsalle varchar(100));



create table objet(
idobjet serial ,
nomobjet varchar(20),
descriptionobjet varchar(50),
idsalle int,
PRIMARY KEY(idobjet,idsalle),
FOREIGN KEY(idsalle) REFERENCES Salle);

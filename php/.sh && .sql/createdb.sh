
drop table Client;
drop table Artiste;
drop table Album;
drop table Chanson;
drop table Compilation;
drop table Rassemble;

CREATE TABLE Client (email varchar(20), nomClient varchar(10), password varchar(10),groupe int,adresse varchar(50), PRIMARY KEY (email));

CREATE TABLE Artiste (idArtiste integer(10) NOT NULL AUTO_INCREMENT, nomArtiste varchar(50), PRIMARY KEY (idArtiste));

CREATE TABLE Album (idArtiste int, idAlbum integer(10) NOT NULL AUTO_INCREMENT, titreAlbum varchar(50), annee int, PRIMARY KEY (idAlbum), FOREIGN KEY (idArtiste) REFERENCES Artiste(idArtiste));


CREATE TABLE Chanson (noChanson integer(10) NOT NULL AUTO_INCREMENT, idAlbum int,titreChanson varchar(50), duree int, prix numeric(10,2), redevance numeric(10,2), PRIMARY KEY (noChanson, idAlbum) ,FOREIGN KEY(idAlbum) REFERENCES Album(idAlbum));


CREATE TABLE Compilation (email varchar(20), idCompil integer(10) NOT NULL AUTO_INCREMENT, date date, numcartebanc numeric(19), PRIMARY KEY (idCompil), FOREIGN KEY (email) REFERENCES Client(email));

CREATE TABLE Rassemble (idCompil int, noChanson int, idAlbum int, PRIMARY KEY (idCompil, noChanson, idAlbum), FOREIGN KEY (idCompil) REFERENCES Compilation, FOREIGN KEY (noChanson, idAlbum) REFERENCES Chanson(noChanson,idAlbum));

INSERT INTO Client  VALUES ("crokette@hotmail.fr","maxime","concombres",1,"9chemin de limont");

INSERT INTO Artiste VALUES (null,"Saez");

INSERT INTO Album VALUES (1,null,"Jour etranges",1997);

INSERT INTO Chanson VALUES (null,1,"Sauver notre etoile",178,10,10);

INSERT INTO Chanson VALUES (null,1,"Jeune et con",177,0,0);

INSERT INTO Compilation VALUES ("crokette@hotmail.fr",null,CURRENT_TIMESTAMP,12);

INSERT INTO Rassemble VALUES (1,1,1);

select * from Client;
select * from Artiste;
select * from Album;
select * from Chanson;
select * from Compilation;
select * from Rassemble;
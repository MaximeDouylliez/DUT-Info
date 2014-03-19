drop database ap5;

create database ap5;

use ap5;

create table Artiste(
idArtiste serial PRIMARY KEY,
nomArtiste text);

create table Album(
idArtiste int,
idAlbum int PRIMARY KEY, 
titreAlbum text,
annee int,
FOREIGN KEY (idArtiste) references Artiste(idArtiste)); 

create table Chanson(
noChanson serial,
idAlbum int,
titreChanson text,
duree int,
prix numeric(10,2),
redevance numeric(10,2),
PRIMARY KEY(noChanson,idAlbum),
FOREIGN KEY (idAlbum) references Album(idAlbum));

create table Client(
email varchar(30) PRIMARY KEY,
nomClient text,
adresse text,
password varchar(8),
groupe int);

create table Compilation(
email varchar(30),
idCompil serial PRIMARY KEY, 
date TIMESTAMP default CURRENT_TIMESTAMP,
numcartebanc numeric(19),
FOREIGN KEY (email) references Client(email));

create table Rassemble(
idCompil int,
noChanson serial,
idAlbum int,
PRIMARY KEY(idCompil,noChanson,idAlbum),
FOREIGN KEY (noChanson) references Chanson(noChanson),
FOREIGN KEY (idAlbum) references Chanson(idAlbum));


insert into Artiste values(1,'The Cure');
insert into Artiste values(2,'Michael Jackson');

insert into Album values(2,1,'Thriller',1982);
insert into Album values(1,2,'4:13 Dream',2008);

insert into Chanson values(1,2,'The Only One','2',1,'0.5');
insert into Chanson values(2,2,'Freakshow','2',1,'0.5');
insert into Chanson values(3,2,'Sleep When I m Dead','2',1,'0.5');
insert into Chanson values(4,2,'The Perfect Boy','2',1,'0.5');
insert into Chanson values(5,1,'Billie Jean','2',1,'0.5');
insert into Chanson values(6,1,'The Girl Is Mine','2',1,'0.5');
insert into Chanson values(7,1,'Thriller','2',1,'0.5');

insert into Client Values('toto@toto.fr','toto','rue toto','toto','0');
insert into Client Values('tutu@toto.fr','tutu','rue tutu','tutu','1');
insert into Client Values('titi@toto.fr','titi','rue titi','titi','2');








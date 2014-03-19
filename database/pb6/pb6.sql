/*select nom,prenom,count(couleur) from carton group by nom,prenom;
select equipe,count(couleur) from carton natural join effectif group by equipe;
select local,count(*) from match where butLocal>butVisit group by local;*/


drop table Equipe cascade;
drop table Effectif cascade;
drop table Match cascade;
drop table Carton cascade;
drop type Couleur;

create TYPE Couleur As ENUM ('jaune','rouge');

create table Equipe (
idEquipe serial PRIMARY KEY,
nom text
);

create table Effectif(
idJoueur serial PRIMARY KEY,
idEquipe int references Equipe(idEquipe),
nom text,
prenom text
);

create table Match(
idMatch serial PRIMARY KEY,
idLocal int not null references Equipe(idEquipe),
idVisit int not null references Equipe(idEquipe),
butLocal int default 0,
butVisit int default 0,
saison int not null
);

create table Carton(
idMatch int references Match(idMatch),
idJoueur int references Effectif(idJoueur),
couleur Couleur NOT NULL,
Primary key(idMatch,idJoueur)
);

insert into Equipe select equipe from Pb6.Effectif group by equipe;

/*insert into Effectif(idJoueur, idEquipe, nom, prenom)
default,*/

 

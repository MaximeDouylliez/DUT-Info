DROP table Preference;
DROP table Repas;
DROP table Menu;


create table Preference (personne varchar(50), platPrefere varchar(50), PRIMARY KEY (personne));

create table Repas (date1 date, invite varchar(50), PRIMARY KEY (date1), FOREIGN KEY(invite) REFERENCES Preference(personne));

create table Menu (date1 date, plat varchar(50), PRIMARY KEY (date1,plat));




DROP TABLE Menu;
DROP TABLE Repas;
DROP TABLE Preference;

CREATE TABLE Preference(
personne text PRIMARY KEY,
platprefere text);

CREATE TABLE Repas(
date date,
invite text REFERENCES Preference(personne),
PRIMARY KEY(date,invite));

CREATE TABLE Menu(
date date,
plat text,
PRIMARY KEY (date,plat));

INSERT INTO Preference VALUES
('Marie', 'poulet'),
('Alice', 'pot_au_feu'),
('Martin', 'sanglier'),
('Luc', 'foie     '),
('Lea', 'pates'),
('Celine', 'poulet'),
('Chris', 'crepes'),
('David', 'veau_orloff');

INSERT INTO Menu VALUES
('01/05/1997', 'crepes'),
('05/07/2003', 'pot au feu'),
('02/08/2006', 'sanglier'),
('05/06/2002', 'poulet'),
('26/05/2003', 'foie');

INSERT INTO Repas VALUES
('01/05/1997', 'Chris'),
('01/05/1997', 'Celine'),
('01/05/1997', 'Marie'),
('02/08/2006', 'Alice'),
('05/07/2003', 'Alice'),
('05/06/2002', 'Marie'),
('26/05/2003', 'Luc'),
('01/05/1997', 'David'),
('02/08/2006', 'David'),
('05/07/2003', 'David'),
('26/05/2003', 'David');



Select invite from Repas where date = '01/05/1997';

Select plat from Menu natural join Repas where invite='Alice';

Select invite from Repas natural join Menu join Preference on (personne = invite) where (plat=platPrefere);

Select personne from Preference where personne not in (Select invite from Repas);
ere
/*Select invite from Repas natural join Menu where */

/*ALTER TABLE Preference ADD dateanniv text  DEFAULT '01/01/1001';*/

/* Il faut etendre la clé primaire */

/*ALTER TABLE Preference DROP CONSTRAINT preference_pkey CASCADE;
ALTER TABLE Preference ADD PRIMARY KEY (personne,dateanniv);
ALTER TABLE Repas ADD FOREIGN KEY (invite) REFERENCES Preference(personne,dateanniv);
*/

Select invite from Repas natural join Menu join Preference on (personne = invite) where (plat=platPrefere) group by invite;

Select personne from Preference where personne not in (Select invite from Repas) group by personne;


Select personne from Preference group by personne having count(platPrefere)>1 ;

Select personne from Preference where personne not in (Select invite from Repas) and platPrefere = '' ;

Select platPrefere from Preference where personne='Marie';

Select count (*) from Repas where invite='Marie';

Select count (*) from Repas natural join Preference where platPrefere = '' ;




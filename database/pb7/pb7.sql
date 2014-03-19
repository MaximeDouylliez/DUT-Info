drop table Utilisateur cascade;
drop table Vlog cascade;
drop table Article cascade;
drop table RespArticle cascade;
drop table Section cascade;
drop table Rangement cascade;
drop language plpgsql;
drop function loglog();
drop trigger loglog1 on Utilisateur;
drop function promote3();
drop trigger promote3 on Utilisateur;
drop function promote2();
drop trigger promote2 on Utilisateur;

create table Utilisateur(iduser serial Primary key, pseudo text not null, mdp text not null, role int);

create table Vlog(idlog serial primary key, iduser int references Utilisateur(iduser) not null, description text not null,dat TIMESTAMP not null);

create table Article(idArticle serial primary key, idAuteur int references Utilisateur(iduser)not null, isRead bool default);

create table RespArticle(idArticle int references Article(idArticle), idRedacteur int references Utilisateur(iduser) not null, Primary key (idArticle,idRedacteur));

create table Section(idSection serial primary key, type text not null);

create table Rangement(idSection int references Section(idSection),idArticle int references Article(idArticle) not null, primary key(idSection,idArticle));


create language plpgsql;




create function loglog() returns trigger as $$
begin
insert into Vlog values (default, (select iduser from Utilisateur where pseudo=new.pseudo), 'Creation dun nouvel utilisateur', CURRENT_TIMESTAMP);
return new;
end;
$$ language PLPGSQL;

create trigger loglog1 after insert on Utilisateur
for each row execute procedure loglog();




create function promote3() returns trigger as $$
begin
insert into Vlog values(default, (select iduser from Utilisateur where pseudo=new.pseudo), 'promoted to admin', CURRENT_TIMESTAMP)
where pseudo=new.pseudo and new.role=3;
return new;
end;
$$ language PLPGSQL;

create trigger promote3 after update on utilisateur
for each row execute procedure promote();



create function promote2() returns trigger as $$
begin
insert into Vlog values(default, (select iduser from Utilisateur where pseudo=new.pseudo), 'promoted to redactor', CURRENT_TIMESTAMP)
where pseudo=new.pseudo and new.role=2;
return new;
end;
$$ language PLPGSQL;

create trigger promote2 after update on utilisateur
for each row execute procedure promote();



insert into Utilisateur Values(default, 'Nainsomniak', 'concumber');
update Utilisateur set role=3 where pseudo='Nainsomniak';




drop table Utilisateur cascade;
drop table Admin cascade;
drop table Vlog cascade;
drop table Article cascade;
drop table RespArticle cascade;
drop table Section cascade;
drop table Rangement cascade;
drop language plpgsql;
drop function loglog();
drop trigger loglog1 on Utilisateur;

create table Utilisateur(iduser serial Primary key, pseudo text not null, mdp text not null, isRedactor bool default false);

create table Admin(iduser int primary key references Utilisateur(iduser) not null);

create table Vlog(idlog serial primary key, iduser int references Utilisateur(iduser) not null, description text not null,dat TIMESTAMP not null);

create table Article(idArticle serial primary key, idAuteur int references Utilisateur(iduser)not null, isRead bool default false);

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




create function promote() returns trigger as $$
begin
update utilisateur
set isRedactor=true
where iduser=new.iduser;
return new;
end;
$$ language PLPGSQL;

create trigger promote after insert on Admin
for each row execute procedure promote();



insert into Utilisateur Values(default, 'Nainsomniak', 'concumber');
insert into Admin values((select iduser from Utilisateur where pseudo ='Nainsomniak'));




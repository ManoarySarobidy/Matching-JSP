create TABLE personne(
	idPersone varchar(100) primary key,
	idInfo varchar(100),
	idCritere varchar(100),
);
	FOREIGN KEY(idInfo) references Info(idInfo),

create table annexe(
	idAnnexe varchar(100) primary key,
	value varchar(100)
);
insert into annexe values('ANX0001','Salaire');
insert into annexe values('ANX0002','Nationalite');
insert into annexe values('ANX0003','Finoana');
insert into annexe values('ANX0004','Diplome');
insert into annexe values('ANX0005','Teinte');
insert into annexe values('ANX0006','Hauteur');

create table Info(
	idInfo varchar(100) primary key,
	idAnnexe varchar(100),
	value number(2),
	idPersone varchar(100)
);

-- azoko ny Info de ndao ndray atao ny critere

create table Critere(
	idCritere varchar(100) primary key,
	idAnnexe varchar(100),
	value number(2),
	idPersone varchar(100),
	Foreign key(idAnnexe) references annexe(idAnnexe)
);

-- azo zay ny critere

-- ny user no ampidirina farany

create table users(
	idUser varchar(100) primary key,
	nom varchar(250),
	pass varchar(250),
	idPersone varchar(100),
	FOREIGN KEY(idPersone) references personne(idPersone)
);

alter table personne add Foreign key(idInfo) references Info(idInfo);
alter table personne add FOREIGN KEY(idCritere) references Critere(idCritere)

alter table Info add Foreign key(idPersone) references Personne(idPersone);
alter table Info add Foreign key(idAnnexe) references annexe(idAnnexe);
alter table personne add idAnnexe varchar(100);
-- donnes de test fotsiny

insert into Info(idInfo) values('INF0001');
insert into Critere(idCritere) values('CRT0001');

insert into personne values 
	('PRS0001','INF0001','CRT0001');

insert into users values
	('USR0001','Sarobidy@manoary','sarobidy','M');

create table Info(
	idInfo varchar(50) primary key,
	salary number(3),
	nationality number(3),
	finoana number(3),
	diplome number(3),
	fumeur number(3),
	teint number(3),
	longeur number(3),
	idUser varchar(50),
	FOREIGN KEY (idUser) references users(idUser)
);


create sequence infSequence
	start with 1
	increment by 1
	minvalue 1
	;

create function getInf
	return number 
	as inf number(8);
	BEGIN
		Select infSequence.nextVal into inf from dual;
		return (inf);
	END;
	/
create table Annexe(
	idAnnexe varchar(50) primary key,
	salary number(3),
	nationality number(3),
	finoana number(3),
	diplome number(3),
	fumeur number(3),
	teint number(3),
	longeur number(3),
	idUser varchar(50),
	FOREIGN KEY (idUser) references users(idUser)
);
create sequence anxSequence
	start with 1
	increment by 1
	minvalue 1
;

create function getAnx
	return number 
	as anx number(8);
	BEGIN
		Select anxSequence.nextVal into anx from dual;
		return (anx);
	END;
	/
-- eto no amoronana raikitra
create table raikitra(
	idRaikitra varchar(50) primary key,
	idUserOne varchar(50),
	idUserTwo varchar(50),
	dateRaikitra date,
	FOREIGN KEY (idUserOne) references users(idUser),
	FOREIGN key (idUserTwo) references users(idUser)
);

create sequence raikitraSequence
	start with 1
	increment by 1
	minvalue 1
;

create function getRaikitra
	return number 
	as rkt number(8);
	BEGIN
		Select raikitraSequence.nextVal into rkt from dual;
		return (rkt);
	END;
	/

-- rehefa vita ny user de ndao anao login vetivety
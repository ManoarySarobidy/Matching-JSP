create table Users(
	idUser varchar(10) primary key,
	username varchar(250),
	password varchar(250),
	sexe varchar(2)
);

create table annexe(
	idAnnexe varchar(10) primary key,
	AnnexeValue varchar(150)
);

create table information(
	idInformation varchar(10) primary key,
	idAnnexe varchar(10),
	infoValue varchar(10),
	idUser varchar(10),
	FOREIGN KEY(idUser) references Users(idUser),
	FOREIGN KEY(idAnnexe) references annexe(idAnnexe)
);

create table Critere(
	idCritere varchar(10) primary key,
	idAnnexe varchar(10),
	critValue varchar(10),
	idUser varchar(10),
	FOREIGN KEY(idUser) references Users(idUser),
	FOREIGN KEY(idAnnexe) references annexe(idAnnexe)
);

insert into annexe values
	( 'ANX0001' , 'Salaire' );
insert into annexe values
	( 'ANX0002' , 'Nationalite' );
insert into annexe values
	( 'ANX0003' , 'Finoana' );
insert into annexe values
	( 'ANX0004' , 'Diplome' );
insert into annexe values
	( 'ANX0005' , 'Longeur' );
insert into annexe values
	( 'ANX0006' , 'Age' );

create table raikitra(
	
	idRaikitra varchar(10) primary key,
	idUser1 varchar(10),
	idUser2 varchar(10),
	dateRaikitra date,
	Foreign key(idUser1) references Users(idUser),
	Foreign key(idUser2) references Users(idUser)
);

create sequence idUser
	start with 1
	increment by 1
	minvalue 1;

create function getIdUser()
	returns int
	language plpgsql
	as 
	$$
	Declare
	id int;
	BEGIN
		return nextVal('idUser');
	END;
	$$;


create sequence idInformation
	start with 1
	increment by 1
	minvalue 1;

create function getIdInformation()
	returns int
	language plpgsql
	as 
	$$
	Declare
	id int;
	BEGIN
		return nextVal('idInformation');
	END;
	$$;


create sequence idCritere
	start with 1
	increment by 1
	minvalue 1;

create function getIdCritere()
	returns int
	language plpgsql
	as 
	$$
	Declare
	id int;
	BEGIN
		return nextVal('idCritere');
	END;
	$$;

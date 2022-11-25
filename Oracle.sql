create table User(
	idUser varchar(10) primary key,
	nom varchar(250),
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
	FOREIGN KEY(idUser) references User(idUser)
);

create table Critere(
	idCritere varchar(10) primary key,
	idAnnexe varchar(10),
	critValue varchar(10),
	idUser varchar(10),
	FOREIGN KEY(idUser) references User(idUser)
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
	( 'ANX0006' , 'Teinte' );

-- efa ananako ny annexe de andao anao base vaovao indray

create table raikitra(
	
	idRaikitra varchar(10) primary key,
	idUser1 varchar(10),
	idUser2 varchar(10),
	dateRaikitra date,
	Foreign key(idUser1) references User(idUser),
	Foreign key(idUser2) references User(idUser)
);


-- rehefa manana critere avy eo de afaka manao izay tiana
CREATE DATABASE `mediator`;
USE `mediator`;

Create table Enseignant (
ID_ens integer not null,
nom   varchar(45) NOT NULL,
prenom   varchar(45) NOT NULL,
telephone   varchar(45) DEFAULT NULL,
CONSTRAINT PK_ID_ens PRIMARY KEY(ID_ens));

INSERT INTO Enseignant values (1, 'Dubois', 'Jean', ' 012345678');
INSERT INTO Enseignant values (2, 'LEGRAND', 'EMILIE', ' 012345678');
INSERT INTO Enseignant values (10, 'Nom10', 'Prenom10', ' 012345678');
INSERT INTO Enseignant values (11, 'Nom10', 'Prenom11', ' 012345678');


CREATE TABLE Etudiant (
ID_etudiant integer NOT NULL,
nom   varchar(45) NOT NULL,
prenom   varchar(45) NOT NULL,
provenance   varchar(45) NOT NULL,
Formation_precedente   varchar(45) NOT NULL,
Pays_Formation_precedente   varchar(45) NOT NULL,
Annee_debut   integer NOT NULL,
Niveau_inscription   varchar(45) NOT NULL,
telephone   varchar(45) DEFAULT NULL,
dateNaissance   date NOT NULL,
CONSTRAINT PK_ID PRIMARY KEY (ID_etudiant) );

INSERT INTO Etudiant values (10, 'Nom10', 'Prenom10', 'fr', 'Licence', 'fr', 2008, 'M1', '012345678' , STR_TO_DATE('05/03/1985', '%d/%m/%Y'));
INSERT INTO Etudiant values (11, 'Nom11', 'Prenom11', 'de', 'M1', 'fr', 2009, 'M2', '012345678', STR_TO_DATE('08/09/1985', '%d/%m/%Y'));
INSERT INTO Etudiant values (12, 'Nom12', 'Prenom12', 'it', 'Licence', 'it', 2008, 'M1', '012345678', STR_TO_DATE('02/07/1987', '%d/%m/%Y'));

CREATE TABLE   Cours (
NumCours   integer NOT NULL,
libele   varchar(45) NOT NULL,
niveau  varchar(45) NOT NULL,
type   varchar(45) NOT NULL,
CONSTRAINT PK_NumCours  PRIMARY KEY (NumCours));

INSERT INTO Cours values (1, 'SGBD', 'M1', 'CM');
INSERT INTO Cours values (2, 'SGBDA', 'M2', 'CM');
INSERT INTO Cours values (3, 'SGBD', 'M1', 'TD');
INSERT INTO Cours values (4, 'SGBDA', 'M2', 'TD');
INSERT INTO Cours values (5, 'ID', 'M2', 'CM');
INSERT INTO Cours values (6, 'ID', 'M2', 'TD');


CREATE TABLE   Enseigne (
NumEns   integer NOT NULL,
NumCours  integer NOT NULL,
Annee    integer NOT NULL,
CONSTRAINT PK_Ens  PRIMARY KEY (NumEns,NumCours,Annee),
Constraint FK_Ens Foreign key (NumEns) references Enseignant(ID_ens),
Constraint FK_Cours Foreign key (NumCours) references Cours(NumCours) );

INSERT INTO Enseigne values (1, 1, 2008);
INSERT INTO Enseigne values (2, 2, 2009);
INSERT INTO Enseigne values (10, 3, 2008);
INSERT INTO Enseigne values (11, 4, 2009);
INSERT INTO Enseigne values (10, 5, 2009);
INSERT INTO Enseigne values (11, 6, 2009);


CREATE TABLE    Inscription (
NumEt integer NOT NULL,
NumCours  integer NOT NULL,
Annee   integer NOT NULL,
Note_cours   integer  NOT NULL,
Constraint FK_etudiant Foreign key (NumEt) references Etudiant (ID_etudiant),
Constraint FK_cours_ins Foreign key (NumCours) references Cours (NumCours),
CONSTRAINT PK_LC PRIMARY KEY (NumEt, NumCours,Annee) );

INSERT INTO Inscription values (10, 1, 2008,10);
INSERT INTO Inscription values (11, 2, 2009,12);
INSERT INTO Inscription values (12, 1, 2008,14);
INSERT INTO Inscription values (10, 3, 2008,16);
INSERT INTO Inscription values (11, 4, 2009,10);
INSERT INTO Inscription values (12, 3, 2008,12);
INSERT INTO Inscription values (11, 5, 2009,14);
INSERT INTO Inscription values (11, 6, 2009,16);

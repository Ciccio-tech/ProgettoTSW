DROP database if exists progettoTSW;
CREATE DATABASE progettoTSW;
use progettoTSW;

CREATE TABLE prodotto (
	codP INT PRIMARY KEY ,
	tipo char(30) NOT NULL,
	marca char(20) NOT NULL,
	modello char(200) NOT NULL,
	prezzo float NOT NULL,
	quantità int Not null, 
	immagine text,
    IVA int NOT NULL
);

create table utente_registrato(
	username varchar(20) primary key, 
	pass varchar(20) NOT NULL, 
	nome char(15) NOT NULL, 
	cognome char(15) NOT NULL, 
	email char(30) NOT NULL
);
 CREATE TABLE indirizzo (
	codInd int auto_increment  primary key,
	username varchar(20) ,
	FOREIGN KEY (username) REFERENCES utente_registrato(username)
		on update cascade
        on delete set null,
    via varchar (50) not null,
    cap int (5) not null,
    nCivico int not null,
    citta varchar(60) not null,
    provincia varchar(60) not null,
    stato varchar(40) default 'italia'
);

CREATE TABLE ordine(
	codO int primary key,
	stato boolean NOT NULL,
    dataO date not null,
	username varchar(20)  not null,
    foreign key(username) references utente_registrato(username)
	on delete cascade
	on update cascade
	
); 

create table amministratore(
	username varchar(20) primary key, 
	pass varchar(20) NOT NULL, 
	nome char(15) NOT NULL, 
	cognome char(15) NOT NULL
); 


create table recensione(
	username varchar(20) not null,
	codP int not null,
	FOREIGN KEY (username) REFERENCES utente_registrato(username)
	on delete cascade
	on update cascade,
	FOREIGN KEY (codP) REFERENCES prodotto(codP)
	on delete cascade
	on update cascade,
	primary key(username, codP),
	dataR date NOT NULL,
	voto int NOT NULL, 
	commento char(50)
);
 


 
insert into prodotto values
(0001,"fotocamera","NIKON","D610",714.90,10, "images/FotoProdotti/NikonD610.jpg",20),
(0002,"fotocamera","CANON","POWERSHOT G9 X MARK II",332.90,20, "images/FotoProdotti/CanonG9.jpg",21),
(0003,"fotocamera","FUJIFILM","NSTAX MINI8",69.90,40, "images/FotoProdotti/FujifilNstax.jpg",21),
(0004,"obiettivi fotografici","CANON","SIGMA 10-20MM F/3.5 AF EX DC HSM ",374.90,18, "images/FotoProdotti/SigmaCanon10-20mm.jpg",22),
(0005,"obiettivi fotografici","NIKON","SIGMA 50MM F/1.4 DG HSM ",644.90,10, "images/FotoProdotti/SigmaNikon50mm.jpg",21),
(0006,"accessori","NIKON","NIKON MC-35 (CONNETTORE GPS PER NIKON D2X-D2XS-D3-D3X-D2HS-D200-D300)",99.90,90, "images/FotoProdotti/NikonG35.jpg",21),
(0007,"accessori","NIKON"," BATTERIA ORIGINALE EN-EL9A (Per D40 D40X D60 D5000)",52.90,100, "images/FotoProdotti/NikonEN.jpg",22),
(0008,"obiettivi fotografici","CANON","SIGMA 100-400MM F/5-6.3 DG OS HSM C",704.90,15, "images/FotoProdotti/Sigma100-400mmF5-6-3.jpg",22),
(0009,"accessori","GODOX","GODOX 303-STATIVO PER LAMPADE-TORCE-ALTEZZA MASSIMA 260CM",714.90,1, "images/FotoProdotti/Godox303.jpg",21),
(0010,"obiettivi fotografici","OLYMPUS","14-42MM F/3.5-5.6 ED EZ M.ZUIKO ",217.90,50, "images/FotoProdotti/Olympus14-42mm.jpg",20),
(0011,"accessori","Centenex Electronics","3 x - 8 Pin Kodak U-8 U8 USB dati cavo 5' 2,0 tipo-A Mini 8Pin elemento # 1955137 per C310, C315 ",9.95,10, "images/FotoProdotti/Pin-Kodak-USB.jpg",20),
(0012,"accessori","Bresser","BRESSER BRM-300AM Studio Flash Set 3x 300W",409.05,10, "images/FotoProdotti/BRESSER-BRM-300AM.jpg",20),
(0013,"fotocamera","INK","GoPro Hero 3/3+/4 Guscio impermeabile/Protezione Trasparente",18.95,10, "images/FotoProdotti/GoPro-Hero.jpg",20),
(0014,"obiettivi fotografici","Tamron","TAMRON SP AF 90mm F2.8 (272ES) Sony (Brown Packing)",524.00,20, "images/FotoProdotti/TAMRON-SP-AF-90mm.jpg",21);

insert into utente_registrato values
("Martina01","Marty01#", "Martina", "Girolamo","martinagiro@gmail.com"),
("Elena01","E7le6na01#", "Elena", "Prudente", "elenaPrudente01@gmail.com"),
("Claudia99","Cla9ud9ia&", "Claudia", "Buono","claudiabuono99@gmail.com"),
("Giovanni777","Gio61vanni#", "Giovanni", "Russo","russogiovanni777@gmail.com"),
("Pippo88","PippO88*", "Pippo", "Rossi", "rossipippo98@gmail.com"),
("Jae-Wook98","JaeWook98Lee*", "Jae-Wook", "Lee", "jaewooklee98@gmail.com"),
("Jung-kook97","Jungkook97*", "Jung-kook", "jeon","jung-kook97@gmail.com"),
("Ji-min95","Jimin95?", "Ji-min", "Park","parkjimin95@gmail.com"),
("Tae-hyung95","TaeHyung95^", "Tae-hyung", "Kim", "vkim95@gmail.com")
;

insert into indirizzo ( username, via, cap, nCivico, citta, provincia) value
("Martina01","via parmenide",84069,1,"Roscigno","Salerno"),
("Elena01","via giuliani",84012,28,"Roma","Roma"),
("Claudia99","via tommasini",84061,7,"Castel San Lorenzo","Salerno"),
("Pippo88","via roma",85178,16,"Aquara","Salerno");


insert into ordine value
(012351,true,"2020-05-10","Claudia99"),
(012352,true,"2020-05-10","Elena01"),
(012353,true,"2020-05-10","Jae-Wook98"),
(012354,true,"2020-05-10","Martina01"), 
(012355,true,"2020-05-10","Giovanni777")
;


INSERT INTO amministratore VALUES
("Francesco23", "password1","Francesco", "Cammarota"),
("Damiana5", "password2","Damiana", "Buono");

insert into recensione values
("Martina01",0004,"2021-05-20",6,"il prodotto é..."),
("Ji-min95",0005,"2020-11-23",8,"il prodotto é..."),
("Elena01",0008,"2021-04-13",6,"il servizio é..."),
("Tae-hyung95",0010,"2020-11-27",6,"il prodotto é..."),
("Jae-Wook98",0003,"2021-04-21",6,"il prodotto e il servizio sono..")
;


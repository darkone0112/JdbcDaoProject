DROP TABLE IF EXISTS `trabajas`;
DROP TABLE IF EXISTS `tienda`;
DROP TABLE IF EXISTS `empl`;
DROP TABLE IF EXISTS `empr`;
CREATE TABLE IF NOT EXISTS `empr` (
  `IDEMPR` int(5) NOT NULL,
  `NOMBRE` varchar(10),
  `DIRECCION` varchar(70), 
  `CP` int(5) not null, 
  `PAIS` varchar(20),
  `EMAIL` varchar(100) not null,
  PRIMARY KEY  (`IDEMPR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


insert into `empr` VALUES(00001,'KING','C. de Antonio López, 241',28041,'espanal','easd@gmal.com');


CREATE TABLE IF NOT EXISTS `empl` (
  `EMPLNO` int(5) NOT NULL,
  `NOMBRE` varchar(10) default NULL,
  `DNI` varchar(9),
  `FNACIO` DATE,
  `TELE` int(9),
  `IDEMPR` int(5) NOT NULL,
  PRIMARY KEY  (`EMPLNO`),
  KEY `empr_FOREIGN_KEY` (`IDEMPR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

insert into `empl` values(10001,'K','12345678f','1981-05-07',123456789,00001),
(10002,'j','23456789f','1981-05-07',234567891,00001),
(10003,'g','34567891f','1990-05-07',345678912,00001),
(10004,'f','45678912f','1981-09-31',456789123,00001),
(10005,'d','56789123f','1998-09-17',567891234,00001),
(10006,'s','67891234f','2000-07-07',678912345,00001),
(10007,'a','78912345f','1990-05-14',789123456,00001),
(10008,'n','89123456f','1986-12-07',891234567,00001);



CREATE TABLE IF NOT EXISTS `tienda` (
  `IDTIENDA` int(5) NOT NULL,
  `NOMBRE` varchar(10),
  `DIRECCION` varchar(70), 
  `CP` int(5) not null, 
  `PROVINCIA` varchar(20),
  `TELE` int(9),
  `IDEMPR` int(5),
  PRIMARY KEY  (`IDTIENDA`),
  KEY `empr_FOREIGN_KEY` (`IDEMPR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


insert into `tienda` values(30001,'k1','dr1',20360,'prv1',123456789,00001),
(30002,'j1','dr2',10064,'prv2',234567891,00001),
(30003,'g1','dr3',28060,'prv3',345678912,00001),
(30004,'f1','dr4',20150,'prv4',456789123,00001),
(30005,'d1','dr5',10030,'prv5',567891234,00001),
(30006,'s1','dr6',20033,'prv6',678912345,00001),
(30007,'a1','dr7',26006,'prv7',789123456,00001),
(30008,'n1','dr8',20604,'prv8',891234567,00001);

CREATE TABLE IF NOT EXISTS `trabajas` (
  `ID` int(5) NOT NULL,
  `IDEMPL` int(5),
  `IDTIENDA` int(5), 
  
  PRIMARY KEY  (`ID`),
  KEY `empl_FOREIGN_KEY` (`IDEMPL`),
  KEY `tienda_FOREIGN_KEY` (`IDTIENDA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



insert into `trabajas` values(40001,10001,30001),
(40002,10002,30002),
(40003,10003,30003),
(40004,10004,30004),
(40005,10005,30005),
(40006,10006,30006),
(40007,10007,30002),
(40008,10008,30003);


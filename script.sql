CREATE TABLE materias (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE professores (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  Nascimento datetime NOT NULL,
  Salario double NOT NULL,
  Materia int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (Materia) REFERENCES materias (id)
);

INSERT INTO materias (Nome) VALUES 
  ('Matematica'),
  ('Ciencia'),
  ('Portugues'),
  ('Geografia'),
  ('Historia');

INSERT INTO professores (Nome, Email, Nascimento, Salario, Materia) VALUES 
  ('Yuri','yuri@gmail.com','1998-04-21 00:00:00',2000,2),
  ('Cinthia','cinthia@gmail.com','1999-12-31 00:00:00',2600,5),
  ('Thiago','thiago@gmail.com','1988-01-15 00:00:00',2200,4),
  ('Carlos','carlos@gmail.com','1973-11-30 00:00:00',3000,1),
  ('Flavio','flaviarruda@gmail.com','1988-01-09 00:00:00',4000,3),
  ('George','george@gmail.com','1997-03-04 00:00:00',3000,1);

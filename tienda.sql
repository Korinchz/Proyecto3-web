/**
* Las dos siguientes instrucciones sólo se ejecutan una vez
*/
SET GLOBAL time_zone = '-6:00';



DROP SCHEMA IF EXISTS tienda;
DROP USER IF EXISTS 'usuariogeneral'@'%';



CREATE SCHEMA tienda;
create user 'usuariogeneral'@'%' identified by 'Prueba123_';
grant all privileges on tienda.* to 'usuariogeneral'@'%';
flush privileges;



USE tienda;



/*
* luego de crear el usuario y asignarlo no debiera de ejecutarse nuevamente
*/




CREATE TABLE juego (
idJuego int unsigned NOT NULL AUTO_INCREMENT,
nombre varchar(30) NOT NULL,
desarrollador varchar(30) NOT NULL,
genero varchar(30) NOT NULL,
precio varchar(15) NOT NULL,
modoJuego varchar(15) NOT NULL,
fechaLanzamiento varchar(15) NOT NULL,
plataforma varchar(15) NOT NULL,
idioma varchar(15) NOT NULL,
PRIMARY KEY (idJuego)
);

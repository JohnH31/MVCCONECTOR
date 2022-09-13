CREATE DATABASE bd_crud;
USE bd_crud;
CREATE TABLE tbl_cliente(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nit INT NOT NULL,
	nombres VARCHAR(50) NOT NULL,
	apellidos VARCHAR(50) NOT NULL,
	direccion VARCHAR(50) NOT NULL,
	telefono INT NOT NULL,
	fecha_nacimiento VARCHAR(50) NOT NULL
);

SELECT * FROM tbl_cliente;
CREATE SCHEMA `bdalmacen` ;
CREATE TABLE `bdalmacen`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NULL,
  `categoria` VARCHAR(20) NULL,
  `precio` DOUBLE NULL,
  `stock` INT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO productos (nombre, categoria, precio, stock)  VALUES ('Nevera', 'ELECTRODOMESTICOS', 500.50, 5);
INSERT INTO productos (nombre, categoria, precio, stock)  VALUES ('Lavadora', 'ELECTRODOMESTICOS', 350.10, 3);
INSERT INTO productos (nombre, categoria, precio, stock)  VALUES ('Pantalon', 'TEXTIL', 50.0, 10);
INSERT INTO productos (nombre, categoria, precio, stock)  VALUES ('Camisa', 'TEXTIL', 42.0, 15);
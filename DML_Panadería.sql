INSERT INTO PRODUCTO (nombre, tipo, precio) VALUES 
('Baguette', 'Salado', 1.20),
('Croissant', 'Dulce', 1.50),
('Pan de centeno', 'Salado', 2.50),
('Magdalena', 'Dulce', 1.00),
('Empanada', 'Salado', 2.80),
('Tarta de manzana', 'Dulce', 15.00),
('Pan integral', 'Salado', 3.00),
('Bizcocho', 'Dulce', 2.00),
('Galleta de avena', 'Dulce', 1.20),
('Chapata', 'Salado', 1.80),
('Rosca', 'Dulce', 1.50),
('Donut', 'Dulce', 1.00),
('Pan de molde', 'Salado', 2.00);

INSERT INTO CLIENTE (direccion, nombre, apellido1, apellido2) VALUES 
('Calle Falsa 123', 'Ana', 'García', 'López'),
('Avenida Siempreviva 742', 'Luis', 'Martínez', 'Pérez'),
('Plaza Mayor 5', 'María', 'Fernández', 'Gómez'),
('Calle del Sol 8', 'Carlos', 'Ruiz', 'Sánchez'),
('Calle Luna 3', 'Laura', 'Díaz', 'Morales'),
('Avenida del Mar 12', 'David', 'Hernández', 'Torres'),
('Calle del Río 9', 'Marta', 'Jiménez', 'Ramírez'),
('Plaza del Ángel 2', 'Pedro', 'Vega', 'Navarro'),
('Calle Nueva 11', 'Sara', 'Molina', 'Reyes'),
('Avenida del Bosque 7', 'Jorge', 'Ortiz', 'Cruz'),
('Calle Castilla 14', 'Roberto', 'González', 'Álvarez'),
('Calle Navarra 21', 'Paula', 'Ramírez', 'Santos'),
('Plaza de la Libertad 1', 'José', 'Rey', 'Romero'),
('Calle Princesa 8', 'Inés', 'Soler', 'Ferrer'),
('Calle Reina 16', 'Pablo', 'Nieto', 'Paredes');

INSERT INTO TELEFONO (numTelefono, idCliente) VALUES 
('11112222', 1), ('11112223', 1), ('11112224', 1),
('22223333', 2), 
('33334444', 3), ('33334445', 3),
('44445555', 4), ('44445556', 4), ('44445557', 4),
('55556666', 5), ('55556667', 5), ('55556668', 5),
('77778888', 7), ('77778889', 7), 
('88889999', 8), 
('99990000', 9), ('99990001', 9),
('00001111', 10),
('22222222', 12), ('22222223', 12), ('22222224', 12),
('33333333', 13), 
('44444444', 14), ('44444445', 14),
('55555555', 15);


INSERT INTO EMPLEADO (dni, salario, fnac, nombre, encargado) VALUES 
('12345678A', 2500.00, '1985-05-14', 'Juan', NULL),
('45678901D', 1800.00, '1995-03-05', 'Elena', NULL),
('01234567J', 2200.00, '1991-02-19', 'Laura', NULL),
('11112222K', 2500.00, '1980-05-12', 'Carlos', NULL);
INSERT INTO EMPLEADO (dni, salario, fnac, nombre, encargado) VALUES 
('23456789B', 2000.00, '1990-07-20', 'Lucía', '12345678A'),
('34567890C', 2200.00, '1988-01-10', 'Miguel', '12345678A'),
('78901234G', 2400.00, '1986-06-18', 'Marcos', '45678901D'),
('22223333L', 2300.00, '1992-11-20', 'Ana', '01234567J'),
('33334444M', 2400.00, '1984-07-15', 'Luis', '11112222K'),
('44445555N', 2000.00, '1990-10-10', 'María', '45678901D');
INSERT INTO EMPLEADO (dni, salario, fnac, nombre, encargado) VALUES 
('56789012E', 2100.00, '1992-12-24', 'Alberto', '78901234G'),
('67890123F', 2300.00, '1987-09-14', 'Raquel', '78901234G'),
('89012345H', 2600.00, '1984-11-27', 'Sara', '23456789B'),
('90123456I', 1900.00, '1993-08-07', 'Pablo', '23456789B'),
('55556666O', 2200.00, '1986-08-25', 'Javier', '44445555N');


INSERT INTO PANADERO (dni) VALUES 
('12345678A'), ('23456789B'), ('34567890C'), ('89012345H'), ('90123456I');

INSERT INTO DEPENDIENTE (dni, horario) VALUES 
('45678901D', '8:00-16:00'), 
('56789012E', '9:00-17:00'), 
('67890123F', '10:00-18:00'), 
('78901234G', '11:00-19:00'), 
('44445555N', '12:00-20:00'), 
('55556666O', '13:00-21:00');

INSERT INTO REPARTIDOR (dni, matricula) VALUES 
('01234567J', 'ABC1234'), 
('11112222K', 'DEF5678'), 
('22223333L', 'GHI9012'), 
('33334444M', 'JKL3456');

INSERT INTO COMPRA (fecha, idCliente, dniDependiente, descuentoDependiente, fechaDependiente, dniRepartidor, fechaRepartidor, horaRepartidor) VALUES 
('2024-01-01', 1, '45678901D', 5.00, '2024-01-01', '01234567J', '2024-01-01', '10:00:00'),
('2024-01-01', 1, '45678901D', 10.00, '2024-01-01', '01234567J', '2024-01-01', '11:00:00'),
('2024-01-01', 3, '56789012E', 7.50, '2024-01-01', '01234567J', '2024-01-01', '12:00:00'),
('2024-02-04', 4, '67890123F', 3.00, '2024-02-04', '01234567J', '2024-02-04', '13:00:00'),
('2024-02-06', 4, '67890123F', 8.00, '2024-02-06', '01234567J', '2024-02-06', '14:00:00'),
('2024-02-06', 6, '67890123F', 4.00, '2024-02-06', '22223333L', '2024-02-06', '15:00:00'),
('2024-03-07', 8, '67890123F', 6.50, '2024-03-07', '22223333L', '2024-03-07', '16:00:00'),
('2024-03-10', 8, '45678901D', 9.00, '2024-03-10', '33334444M', '2024-03-10', '17:00:00'),
('2024-03-10', 9, '45678901D', 12.00, '2024-03-10', '22223333L', '2024-03-10', '18:00:00'),
('2024-03-10', 10, '55556666O', 15.00, '2024-03-10', '22223333L', '2024-03-10', '19:00:00'),
('2024-03-11', 15, '55556666O', 5.00, '2024-03-11', '22223333L', '2024-03-11', '10:00:00'),
('2024-03-12', 12, '55556666O', 10.00, '2024-03-12', '01234567J', '2024-03-12', '11:00:00'),
('2024-04-13', 13, '56789012E', 7.50, '2024-04-13', '01234567J', '2024-04-13', '12:00:00'),
('2024-04-14', 13, '56789012E', 3.00, '2024-04-14', '01234567J', '2024-04-14', '13:00:00'),
('2024-04-15', 13, '55556666O', 8.00, '2024-04-15', '01234567J', '2024-04-15', '14:00:00');
INSERT INTO LINEA_DE_TICKET (numCompra, numLinea, codProducto, cantidad) VALUES 
(1,1,9,2),
(1,2,7,4),
(2,1,4,3),
(3,1,4,2),
(3,2,1,5),
(3,3,2,1),
(4,1,7,3),
(5,1,3,1),
(6,1,8,1),
(6,2,9,4),
(7,1,10,5),
(8,1,9,3),
(9,1,9,1),
(9,2,5,4),
(10,1,3,2),
(11,1,13,1),
(12,1,2,8),
(12,2,13,4),
(12,3,2,1),
(13,1,4,9),
(14,1,7,2),
(15,1,4,5),
(15,2,3,4);

INSERT INTO AJENO (codigo) VALUES 
(1),(2),(3),(4),(5),(6),(7);
INSERT INTO PROPIO (codigo) VALUES 
(8),(9),(10),(11),(12),(13);

INSERT INTO HACER (codProdPropio, dniPanadero) VALUES 
(8, '12345678A'), (9, '89012345H'), (10, '12345678A'),
(11, '89012345H'), (12, '89012345H'), (13, '90123456I');

INSERT INTO PROVEEDOR (nombre) VALUES 
('Panadería del Sol'), ('Pastelería La Dulce Vida'), 
('Distribuidora de Harinas'), ('Proveedor de Lácteos'), 
('Pan y Pasteles S.A.'), ('Alimentos Selectos'), 
('Granos y Semillas'), ('Distribuidora de Cacao'), 
('Proveedor de Azúcar'), ('Panaderos Unidos');


INSERT INTO INGREDIENTE (nombre, descripcion) VALUES 
('Harina', 'Harina de trigo refinada'), 
('Azúcar', 'Azúcar blanco refinado'), 
('Levadura', 'Levadura fresca para pan'), 
('Sal', 'Sal de mesa'), 
('Mantequilla', 'Mantequilla sin sal'), 
('Huevos', 'Huevos frescos de granja'), 
('Leche', 'Leche entera'), 
('Chocolate', 'Chocolate negro para repostería'), 
('Canela', 'Canela molida'), 
('Vainilla', 'Extracto de vainilla puro'), 
('Almendras', 'Almendras crudas sin sal'), 
('Nueces', 'Nueces troceadas');

INSERT INTO SUMINISTRAR (codProdAjeno, codProveedor) VALUES 
(1, 1), (1, 3), (2, 4), (3, 5), (3, 6), 
(3, 7), (4, 7), (5, 1), (6, 8), (6, 2), 
(7, 9);

INSERT INTO VENDER (codProveedor, codIngrediente) VALUES 
(1, 1), (1, 7), (2, 2), (3, 3), 
(3, 4), (5, 5), (5, 6), 
(6, 7), (6, 5), (8, 8), 
(8, 9), (9, 10), (10, 11),(10, 12);

INSERT INTO CONTENER (codIngrediente, codProdPropio, cantidad) VALUES 
(1,8,100), (7,8,180),(11,9,450), (1,10,315), (3,11,45), 
(4,11,50), (5,12,110), (7,13,150);


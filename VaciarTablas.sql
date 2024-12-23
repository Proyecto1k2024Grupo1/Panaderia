-- Habilitar esta opción para desactivar temporalmente las claves foráneas.
SET FOREIGN_KEY_CHECKS = 0;

-- Generar y ejecutar comandos TRUNCATE para todas las tablas de la base de datos.
TRUNCATE TABLE PRODUCTO;
TRUNCATE TABLE CLIENTE;
TRUNCATE TABLE TELEFONO;
TRUNCATE TABLE EMPLEADO;
TRUNCATE TABLE PANADERO;
TRUNCATE TABLE DEPENDIENTE;
TRUNCATE TABLE REPARTIDOR;
TRUNCATE TABLE COMPRA;
TRUNCATE TABLE LINEA_DE_TICKET;
TRUNCATE TABLE AJENO;
TRUNCATE TABLE PROPIO;
TRUNCATE TABLE HACER;
TRUNCATE TABLE PROVEEDOR;
TRUNCATE TABLE INGREDIENTE;
TRUNCATE TABLE SUMINISTRAR;
TRUNCATE TABLE VENDER;
TRUNCATE TABLE CONTENER;

-- Habilitar nuevamente las claves foráneas.
SET FOREIGN_KEY_CHECKS = 1;

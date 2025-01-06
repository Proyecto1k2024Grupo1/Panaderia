-- Crear tabla PRODUCTO
create table PRODUCTO(
    -- Código único del producto (auto incrementable)
    codigo int NOT NULL auto_increment, 
    
    -- Nombre del producto
    nombre varchar(128), 
    
    -- Tipo de producto, puede ser 'Dulce', 'Salado', 'Agridulce'
    tipo enum('Dulce', 'Salado', 'Agridulce'), 
    
    -- Precio del producto
    precio decimal(10,2), 
    
    -- Definición de la clave primaria
    constraint PK_PRODUCTO primary key (codigo)
);

-- Crear tabla CLIENTE
create table CLIENTE(
    -- ID único del cliente (auto incrementable)
    idCliente int auto_increment, 
    
    -- Dirección del cliente
    direccion varchar(256), 
    
    -- Nombre del cliente
    nombre varchar(128), 
    
    -- Primer apellido del cliente
    apellido1 varchar(128), 
    
    -- Segundo apellido del cliente
    apellido2 varchar(128), 
    
    -- Definición de la clave primaria
    constraint PK_CLIENTE primary key (idCliente)
);

-- Crear tabla TELEFONO
create table TELEFONO(
    -- Número de teléfono del cliente
    numTelefono char(8), 
    
    -- ID del cliente relacionado
    idCliente int NOT NULL, 
    
    -- Definición de la clave primaria (compuesta por numTelefono e idCliente)
    constraint PK_TELEFONO primary key (numTelefono, idCliente),
    
    -- Clave foránea que referencia a CLIENTE
    constraint FK_TELEFONO_CLIENTE foreign key (idCliente) references CLIENTE(idCliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Crear tabla EMPLEADO
create table EMPLEADO(
    -- DNI del empleado
    dni char(9), 
    
    -- Salario del empleado
    salario decimal(10,2), 
    
    -- Fecha de nacimiento del empleado
    fnac date, 
    
    -- Nombre del empleado
    nombre varchar(128), 
    
    -- DNI del encargado del empleado (puede ser NULL)
    encargado varchar(32), 
    
    -- Definición de la clave primaria
    constraint PK_EMPLEADO primary key (dni),
    
    -- Clave foránea que referencia a EMPLEADO (auto-referencia)
    constraint FK_EMPLEADO_EMPLEADO foreign key (encargado) references EMPLEADO(dni)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

-- Crear tabla PANADERO
create table PANADERO(
    -- DNI del panadero
    dni varchar(32), 
    
    -- Definición de la clave primaria
    constraint PK_PANADERO primary key (dni),
    
    -- Clave foránea que referencia a EMPLEADO
    constraint FK_PANADERO_EMPLEADO foreign key (dni) references EMPLEADO(dni)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Crear tabla DEPENDIENTE
create table DEPENDIENTE(
    -- DNI del dependiente
    dni varchar(32), 
    
    -- Horario de trabajo del dependiente
    horario varchar(64), 
    
    -- Definición de la clave primaria
    constraint PK_DEPENDIENTE primary key (dni),
    
    -- Clave foránea que referencia a EMPLEADO
    constraint FK_DEPENDIENTE_EMPLEADO foreign key (dni) references EMPLEADO(dni)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Crear tabla REPARTIDOR
create table REPARTIDOR(
    -- DNI del repartidor
    dni varchar(32), 
    
    -- Matrícula del vehículo del repartidor
    matricula varchar(32), 
    
    -- Definición de la clave primaria
    constraint PK_REPARTIDOR primary key (dni),
    
    -- Clave foránea que referencia a EMPLEADO
    constraint FK_REPARTIDOR_EMPLEADO foreign key (dni) references EMPLEADO(dni)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Crear tabla COMPRA
create table COMPRA(
    -- Número de compra (auto incrementable)
    numCompra int auto_increment, 
    
    -- Fecha de la compra
    fecha date, 
    
    -- ID del cliente que realizó la compra
    idCliente int NOT NULL, 
    
    -- DNI del dependiente que atendió al cliente
    dniDependiente varchar(32) NOT NULL, 
    
    -- Descuento aplicado por el dependiente
    descuentoDependiente decimal(10,2), 
    
    -- Fecha en que el dependiente atendió la compra
    fechaDependiente date, 
    
    -- DNI del repartidor que entregó el pedido
    dniRepartidor varchar(32) NOT NULL, 
    
    -- Fecha en que el repartidor entregó la compra
    fechaRepartidor date, 
    
    -- Hora de entrega del repartidor
    horaRepartidor time, 
    
    -- Definición de la clave primaria
    constraint PK_COMPRA primary key (numCompra),
    
    -- Claves foráneas que hacen referencia a CLIENTE, DEPENDIENTE y REPARTIDOR
    constraint FK_COMPRA_CLIENTE foreign key (idCliente) references CLIENTE(idCliente)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    
    constraint FK_COMPRA_DEPENDIENTE foreign key (dniDependiente) references DEPENDIENTE(dni)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    
    constraint FK_COMPRA_REPARTIDOR foreign key (dniRepartidor) references REPARTIDOR(dni)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

-- Crear tabla LINEA_DE_TICKET
create table LINEA_DE_TICKET(
    -- Número de compra (referencia a la tabla COMPRA)
    numCompra int, 
    
    -- Número de línea del ticket
    numLinea int, 
    
    -- Código del producto
    codProducto int NOT NULL, 
    
    -- Cantidad del producto
    cantidad int, 
    
    -- Definición de la clave primaria (compuesta por numCompra y numLinea)
    constraint PK_LINEA primary key (numCompra, numLinea),
    
    -- Claves foráneas que hacen referencia a COMPRA y PRODUCTO
    constraint FK_LINEA_COMPRA foreign key (numCompra) references COMPRA(numCompra)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    
    constraint FK_LINEA_PRODUCTO foreign key (codProducto) references PRODUCTO(codigo)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

-- Crear tabla AJENO
create table AJENO(
    -- Código del producto ajeno
    codigo int, 
    
    -- Definición de la clave primaria
    constraint PK_AJENO primary key (codigo),
    
    -- Clave foránea que referencia a PRODUCTO
    constraint FK_AJENO_PRODUCTO foreign key (codigo) references PRODUCTO(codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Crear tabla PROPIO
create table PROPIO(
    -- Código del producto propio
    codigo int, 
    
    -- Definición de la clave primaria
    constraint PK_PROPIO primary key (codigo),
    
    -- Clave foránea que referencia a PRODUCTO
    constraint FK_PROPIO_PRODUCTO foreign key (codigo) references PRODUCTO(codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Crear tabla HACER
create table HACER(
    -- Código del producto propio
    codProdPropio int, 
    
    -- DNI del panadero
    dniPanadero varchar(32), 
    
    -- Definición de la clave primaria (compuesta por codProdPropio y dniPanadero)
    constraint PK_HACER primary key (codProdPropio, dniPanadero),
    
    -- Claves foráneas que hacen referencia a PROPIO y PANADERO
    constraint FK_HACER_PROPIO foreign key (codProdPropio) references PROPIO(codigo)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    
    constraint FK_HACER_PANADERO foreign key (dniPanadero) references PANADERO(dni)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

-- Crear tabla PROVEEDOR
create table PROVEEDOR(
    -- Código del proveedor (auto incrementable)
    codProveedor int auto_increment, 
    
    -- Nombre del proveedor
    nombre varchar(128), 
    
    -- Definición de la clave primaria
    constraint PK_PROVEEDOR primary key (codProveedor)
);

-- Crear tabla INGREDIENTE
create table INGREDIENTE(
    -- Código del ingrediente (auto incrementable)
    codIngrediente int auto_increment, 
    
    -- Nombre del ingrediente
    nombre varchar(128), 
    
    -- Descripción del ingrediente
    descripcion text, 
    
    -- Definición de la clave primaria
    constraint PK_INGREDIENTE primary key (codIngrediente)
);

-- Crear tabla SUMINISTRAR
create table SUMINISTRAR(
    -- Código del producto ajeno
    codProdAjeno int, 
    
    -- Código del proveedor
    codProveedor int, 
    
    -- Definición de la clave primaria (compuesta por codProdAjeno y codProveedor)
    constraint PK_SUMINISTRAR primary key (codProdAjeno, codProveedor),
    
    -- Claves foráneas que hacen referencia a AJENO y PROVEEDOR
    constraint FK_SUMINISTRAR_AJENO foreign key (codProdAjeno) references AJENO(codigo)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    
    constraint FK_SUMINISTRAR_PROVEEDOR foreign key (codProveedor) references PROVEEDOR(codProveedor)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);


-- Crear tabla VENDER
create table VENDER(
    codProveedor int, 
    codIngrediente int, 
    constraint PK_VENDER primary key (codProveedor, codIngrediente),
    constraint FK_VENDER_PROVEEDOR foreign key (codProveedor) references PROVEEDOR(codProveedor)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,

    constraint FK_VENDER_INGREDIENTE foreign key (codIngrediente) references INGREDIENTE(codIngrediente)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

-- Crear tabla CONTENER
create table CONTENER(
    codIngrediente int, 
    codProdPropio int, 
    cantidad int,
    constraint PK_CONTENER primary key (codIngrediente, codProdPropio),
    constraint FK_CONTENER_INGREDIENTE foreign key (codIngrediente) references INGREDIENTE(codIngrediente)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    
    constraint FK_CONTENER_PROPIO foreign key (codProdPropio) references PROPIO(codigo)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);


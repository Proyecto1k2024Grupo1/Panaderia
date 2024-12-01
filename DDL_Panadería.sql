create table PRODUCTO(
    codigo int NOT NULL auto_increment,
    nombre varchar(128),
    tipo enum('Dulce', 'Salado', 'Agridulce'),
    precio decimal(10,2),
    constraint PK_PRODUCTO primary key (codigo)
);

create table CLIENTE(
    idCliente int auto_increment,
    direccion varchar(256),
    nombre varchar(128),
    apellido1 varchar(128),
    apellido2 varchar(128),
    constraint PK_CLIENTE primary key (idCliente)
);

create table TELEFONO(
    numTelefono char(8),
    idCliente int NOT NULL,
    constraint PK_TELEFONO primary key (numTelefono),
    constraint FK_TELEFONO_CLIENTE foreign key (idCliente) references CLIENTE(idCliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table EMPLEADO(
    dni char(9),
    salario decimal(10,2),
    fnac date,
    nombre varchar(128),
    encargado varchar(32),
    constraint PK_EMPLEADO primary key (dni),
    constraint FK_EMPLEADO_EMPLEADO foreign key (encargado) references EMPLEADO(dni)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

create table PANADERO(
    dni varchar(32),
    constraint PK_PANADERO primary key (dni),
    constraint FK_PANADERO_EMPLEADO foreign key (dni) references EMPLEADO(dni)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table DEPENDIENTE(
    dni varchar(32),
    horario(64),
    constraint PK_DEPENDIENTE primary key (dni),
    constraint FK_DEPENDIENTE_EMPLEADO foreign key (dni) references EMPLEADO(dni)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table REPARTIDOR(
    dni varchar(32),
    matricula varchar(32),
    constraint PK_REPARTIDOR primary key (dni),
    constraint FK_REPARTIDOR_EMPLEADO foreign key (dni) references EMPLEADO(dni)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table COMPRA(
    numCompra int auto_increment,
    fecha date,
    idCliente int NOT NULL,
    dniDependiente varchar(32) NOT NULL,
    descuentoDependiente decimal(10,2),
    fechaDependiente date,
    dniRepartidor varchar(32) NOT NULL,
    fechaRepartidor date,
    horaRepartidor time
    constraint PK_COMPRA primary key (numCompra),
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

create table LINEA_DE_TICKET(
    numCompra int,
    numLinea int,
    codProducto int NOT NULL,
    cantidad int,
    constraint PK_LINEA primary key (numCompra, numLinea),
    constraint FK_LINEA_COMPRA foreign key (numCompra) references COMPRA(numCompra)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    constraint FK_LINEA_PRODUCTO foreign key (codProducto) references PRODUCTO(codigo)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

create table AJENO(
    codigo int,
    constraint PK_AJENO primary key (codigo),
    constraint FK_AJENO_PRODUCTO foreign key (codigo) references PRODUCTO(codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table PROPIO(
    codigo int,
    constraint PK_PROPIO primary key (codigo),
    constraint FK_PROPIO_PRODUCTO foreign key (codigo) references PRODUCTO(codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table HACER(
    codProdPropio int,
    dniPanadero varchar(32),
    constraint PK_HACER primary key (codProdPropio, dniPanadero),
    constraint FK_HACER_PROPIO foreign key (codProdPropio) references PROPIO(codigo)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    constraint FK_HACER_PANADERO foreign key (dniPanadero) references PANADERO(dni)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

create table PROVEEDOR(
    codProveedor int auto_increment,
    nombre varchar(128),
    constraint PK_PROVEEDOR primary key (codProveedor)
);

create table INGREDIENTE(
    codIngrediente int auto_increment,
    nombre varchar(128),
    descripcion text,
    constraint PK_INGREDIENTE primary key (codIngrediente)
);

create table SUMINISTRAR(
    codProdAjeno int,
    codProveedor int,
    constraint PK_SUMINISTRAR primary key (codProdAjeno, codProveedor),
    constraint FK_SUMINISTRAR_AJENO foreign key (codProdAjeno) references AJENO(codigo)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    constraint FK_SUMINISTRAR_PROVEEDOR foreign key (codProveedor) references PROVEEDOR(codProveedor)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

create table VENDER(
    codProveedor int,
    codIngrediente int
    constraint PK_VENDER primary key (codProveedor, codIngrediente),
    constraint FK_VENDER_PROVEEDOR foreign key (codProveedor) references PROVEEDOR(codProveedor)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    constraint FK_VENDER_INGREDIENTE foreign key (codIngrediente) references INGREDIENTE(codIngrediente)
    ON DELETE NO ACTION
    ON UPDATE CASCADE

);

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

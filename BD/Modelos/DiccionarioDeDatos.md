## Diccionario de datos
### 1. PRODUCTO
| Nombre    | Tipo       | Descripción                                           |
|-----------|------------|-------------------------------------------------------|
| codigo    | INT        | Código único del producto (clave primaria).           |
| nombre    | VARCHAR(128)| Nombre del producto.                                 |
| tipo      | VARCHAR(64) | Tipo de producto (ejemplo: dulce, salado).           |
| precio    | DECIMAL(10,2) | Precio del producto.                                |

### 2. CLIENTE
| Nombre    | Tipo       | Descripción                                           |
|-----------|------------|-------------------------------------------------------|
| idCliente | INT        | Identificador único del cliente (clave primaria).    |
| direccion | VARCHAR(256)| Dirección del cliente.                               |
| nombre    | VARCHAR(128)| Nombre del cliente.                                  |
| apellido1 | VARCHAR(128)| Primer apellido del cliente.                         |
| apellido2 | VARCHAR(128)| Segundo apellido del cliente.                        |

### 3. TELEFONO
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| numTelefono | VARCHAR(32)| Número de teléfono (clave primaria).                 |
| idCliente   | INT        | Identificador del cliente (clave ajena).             |

### 4. EMPLEADO
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| dni         | VARCHAR(32)| Documento Nacional de Identidad del empleado (clave primaria). |
| salario     | DECIMAL(10,2) | Salario del empleado.                               |
| fnac        | DATE       | Fecha de nacimiento del empleado.                    |
| nombre      | VARCHAR(128)| Nombre del empleado.                                 |
| encargado   | VARCHAR(32)| DNI del encargado, referencia a otro empleado (clave ajena). |

### 5. PANADERO
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| dni         | VARCHAR(32)| Documento Nacional de Identidad del panadero (clave primaria, clave ajena de EMPLEADO). |

### 6. DEPENDIENTE
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| dni         | VARCHAR(32)| Documento Nacional de Identidad del dependiente (clave primaria, clave ajena de EMPLEADO). |
| horario     | VARCHAR(64)| Horario de trabajo del dependiente.                   |

### 7. REPARTIDOR
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| dni         | VARCHAR(32)| Documento Nacional de Identidad del repartidor (clave primaria, clave ajena de EMPLEADO). |
| matricula   | VARCHAR(32)| Matrícula del vehículo del repartidor.                |

### 8. COMPRA
| Nombre         | Tipo       | Descripción                                           |
|----------------|------------|-------------------------------------------------------|
| numCompra      | INT        | Número único de la compra (clave primaria).           |
| fecha          | DATE       | Fecha de la compra.                                   |
| idCliente      | INT        | Identificador del cliente (clave ajena).              |
| dniDependiente | VARCHAR(32)| DNI del dependiente que atendió la compra (clave ajena). |
| descuentoDependiente | DECIMAL(5,2) | Descuento aplicado por el dependiente.            |
| fechaDependiente | DATE     | Fecha en que se aplicó el descuento.                  |
| dniRepartidor  | VARCHAR(32)| DNI del repartidor (clave ajena).                     |
| fechaRepartidor | DATE      | Fecha de la entrega del pedido.                       |
| horaRepartidor | TIME       | Hora de la entrega del pedido.                        |

### 9. LINEA_DE_TICKET
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| numCompra   | INT        | Número de la compra (clave primaria, clave ajena de COMPRA). |
| numLinea    | INT        | Número de línea dentro del ticket (clave primaria).   |
| codProducto | INT        | Código del producto (clave ajena de PRODUCTO).        |
| cantidad    | INT        | Cantidad del producto en la línea del ticket.         |

### 10. AJENO
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| codigo      | INT        | Código del producto ajeno (clave primaria, clave ajena de PRODUCTO). |

### 11. PROPIO
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| codigo      | INT        | Código del producto propio (clave primaria, clave ajena de PRODUCTO). |

### 12. HACER
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| codProdPropio | INT      | Código del producto propio (clave primaria, clave ajena de PROPIO). |
| dniPanadero | VARCHAR(32)| DNI del panadero que hace el producto (clave ajena de PANADERO). |

### 13. PROVEEDOR
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| codProveedor | INT       | Código único del proveedor (clave primaria).         |
| nombre      | VARCHAR(128)| Nombre del proveedor.                                |

### 14. INGREDIENTE
| Nombre      | Tipo       | Descripción                                           |
|-------------|------------|-------------------------------------------------------|
| codIngrediente | INT     | Código único del ingrediente (clave primaria).       |
| nombre      | VARCHAR(128)| Nombre del ingrediente.                              |
| descripcion | TEXT       | Descripción del ingrediente.                          |

### 15. SUMINISTRAR
| Nombre         | Tipo       | Descripción                                           |
|----------------|------------|-------------------------------------------------------|
| codProdAjeno   | INT        | Código del producto ajeno (clave primaria, clave ajena de AJENO). |
| codProveedor   | INT        | Código del proveedor (clave primaria, clave ajena de PROVEEDOR). |

### 16. VENDER
| Nombre         | Tipo       | Descripción                                           |
|----------------|------------|-------------------------------------------------------|
| codProveedor   | INT        | Código del proveedor (clave primaria, clave ajena de PROVEEDOR). |
| codIngrediente | INT        | Código del ingrediente (clave primaria, clave ajena de INGREDIENTE). |

### 17. CONTENER
| Nombre         | Tipo       | Descripción                                           |
|----------------|------------|-------------------------------------------------------|
| codIngrediente | INT        | Código del ingrediente (clave primaria, clave ajena de INGREDIENTE). |
| codProdPropio  | INT        | Código del producto propio (clave primaria, clave ajena de PROPIO). |
| cantidad       | INT        | Cantidad del ingrediente en el producto propio.       |

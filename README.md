# Proyecto Intermodular
# Grupo 1

## Integrantes:
* Jessica Brotons Maciá (https://github.com/LaJessyMiau)
* Silvia Cachón Leiva (https://github.com/39Luka)
* Vanesa Sekeresh (https://github.com/Timia117)

## Sistema de información


## Modelo Entidad-Relación


![Modelo ER Panadería Actualizado](https://github.com/user-attachments/assets/0d594cc3-9119-453a-9438-af149405fd22)



## Justificaciones
El atributo fecha va en compra y no en la relación, porque una compra tiene la fecha del momento en que se realizó y no depende del cliente, ya que esa compra no se vende en diferentes fechas.

En cuanto a los productos, tenemos dos tipos: los suministrados y los que hace la panadería. Como tienen relaciones diferentes, hemos creado una generalización para distinguirlos, la cual, es disjunta porque un producto propio no puede ser ajeno y viceversa. También hemos hecho una generalización en empleados porque comparten ciertos datos, como el DNI, nombre, etc.; pero a su vez hay varios tipos de empleados: panadero, dependiente y repartidor; que desempeñan diferentes funciones y, por tanto, tienen distintas relaciones.

Hemos generado una entidad débil llamada línea de ticket porque un ticket de una compra tiene varias líneas donde se especifica cada uno de los productos que se ha comprado. La cantidad de un producto se incluye en la relación porque la cantidad hace referencia a la entidad de producto y también a la línea de ticket, ya que tenemos cierta cantidad del producto en una línea en específico.

Lo mismo ocurre entre producto propio e ingrediente, ya que un producto propio contiene cierta cantidad de un ingrediente; entre compra y dependiente, ya que una compra la vende un dependiente en una fecha y con un descuento determinado; entre repartidor y compra, ya que un repartidor reparte una compra en una fecha y hora concreta.

En la relación reflexiva de ser empleado en la entidad empleado, hemos utilizado la cardinalidad ninguno o una a ninguno o muchos, porque un empleado no está obligado a ser encargado ni está obligado a tener encargado.



## Dependencias de las tablas

![Orden BD](https://github.com/user-attachments/assets/cab0af55-6317-405e-86fd-b44f1031bb18)

## Modelo Relacional

**PRODUCTO** (<ins>codigo</ins>, nombre, tipo, precio)  
PK ->(codigo)  

---

**CLIENTE** (<ins>idCliente</ins>, direccion, nombre, apellido1, apellido2)  
PK ->(idCliente)  

---

**TELEFONO** (<ins>numTelefono</ins>, idCliente*)  
PK ->(numTelefono, idCliente)  
FK ->(idCliente) -> CLIENTE  
VNN ->(idCliente)  

---

**EMPLEADO** (<ins>dni</ins>, salario, fnac, nombre, encargado*)  
PK ->(dni)  
FK ->(encargado) -> EMPLEADO  

---

**PANADERO**(<ins>dni*</ins>)  
PK ->(dni)  
FK ->(dni) -> EMPLEADO  

---

**DEPENDIENTE** (<ins>dni*</ins>, horario)  
PK ->(dni)  
FK ->(dni) -> EMPLEADO  

---

**REPARTIDOR** (<ins>dni*</ins>, matricula)  
PK ->(dni)  
FK ->(dni) -> EMPLEADO  

---

**COMPRA** (<ins>numCompra</ins>, fecha, idCliente*, dniDependiente, descuentoDependiente, fechaDependiente, dniRepartidor*, fechaRepartidor, horaRepartidor)  
PK ->(numCompra)  
FK ->(idCliente) -> CLIENTE  
   ->(dniDependiente) -> DEPENDIENTE  
   ->(dniRepartidor) -> REPARTIDOR  
VNN ->(idCliente)  
    ->(dniDependiente)  
    ->(dniRepartidor)  

---

**LINEA_DE_TICKET** (<ins>numCompra*</ins>, <ins>numLinea</ins>, codProducto*, cantidad)  
PK ->(numCompra, numLinea)  
FK ->(numCompra) -> COMPRA  
   ->(codProducto) -> PRODUCTO  
VNN ->(codProducto)  

---

**AJENO** (<ins>codigo*</ins>)  
PK ->(codigo)  
FK ->(codigo) -> PRODUCTO  

---

**PROPIO** (<ins>codigo*</ins>)  
PK ->(codigo)  
FK ->(codigo) -> PRODUCTO  

---

**HACER** (<ins>codProdPropio*</ins>, <ins>dniPanadero*</ins>)  
PK ->(codProdPropio, dniPanadero)  
FK ->(codProdPropio) -> PROPIO  
   ->(dniPanadero) -> PANADERO  

---

**PROVEEDOR** (<ins>codProveedor</ins>, nombre)  
PK ->(codProveedor)  

---

**INGREDIENTE**(<ins>codIngrediente</ins>, nombre, descripción)  
PK ->(codIngrediente)  

---

**SUMINISTRAR** (<ins>codProdAjeno*</ins>, <ins>codProveedor*</ins>)  
PK ->(codProdAjeno, codProveedor)  
FK ->(codProdAjeno) -> AJENO  
   ->(codProveedor) -> PROVEEDOR  

---

**VENDER** (<ins>codProveedor*</ins>, <ins>codIngrediente*</ins>)  
PK ->(codProveedor, codIngrediente)  
FK ->(codProveedor) -> PROVEEDOR  
   ->(codIngrediente) -> INGREDIENTE  

---

**CONTENER** (<ins>codIngrediente*</ins>, <ins>codProdPropio*</ins>, cantidad)  
PK ->(codIngrediente, codProdPropio)  
FK ->(codIngrediente) -> INGREDIENTE  
   ->(codProdPropio) -> PROPIO  


## Esquema Relacional
![ESQUEMA RELACIONAL PANADERÍA](https://github.com/user-attachments/assets/fc26f1f9-7ef3-478e-8a56-4db942970b73)

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


## Relaciones y Restricciones de la Base de Datos

### CLIENTE y TELEFONO
- **Clave primaria en CLIENTE**: `idCliente`
- **Clave primaria en TELEFONO**: `numTelefono`
- **Clave ajena en TELEFONO**: `idCliente` referencia a `idCliente` en la tabla CLIENTE, indica la relación entre un teléfono y el cliente que lo posee.
  - **Restricción de borrado**: propagar
  - **Restricción de modificación**: propagar

### EMPLEADO
- **Clave primaria en EMPLEADO**: `dni`
- **Clave ajena en EMPLEADO**: `encargado` referencia a `dni` en la tabla EMPLEADO, indica la relación entre un empleado y otro que es su encargado.
  - **Restricción de borrado**: anular
  - **Restricción de modificación**: propagar

### EMPLEADO y PANADERO
- **Clave primaria en EMPLEADO**: `dni`
- **Clave primaria en PANADERO**: `dni`
- **Clave ajena en PANADERO**: `dni` referencia a `dni` en la tabla EMPLEADO, indica que un panadero es un empleado.
  - **Restricción de borrado**: propagar
  - **Restricción de modificación**: propagar

### EMPLEADO y DEPENDIENTE
- **Clave primaria en EMPLEADO**: `dni`
- **Clave primaria en DEPENDIENTE**: `dni`
- **Clave ajena en DEPENDIENTE**: `dni` referencia a `dni` en la tabla EMPLEADO, indica que un dependiente es un empleado.
  - **Restricción de borrado**: propagar
  - **Restricción de modificación**: propagar

### EMPLEADO y REPARTIDOR
- **Clave primaria en EMPLEADO**: `dni`
- **Clave primaria en REPARTIDOR**: `dni`
- **Clave ajena en REPARTIDOR**: `dni` referencia a `dni` en la tabla EMPLEADO, indica que un repartidor es un empleado.
  - **Restricción de borrado**: propagar
  - **Restricción de modificación**: propagar

### COMPRA
- **Clave primaria en COMPRA**: `numCompra`
- **Clave primaria en CLIENTE**: `idCliente`
- **Clave primaria en DEPENDIENTE**: `dni`
- **Clave primaria en REPARTIDOR**: `dni`
- **Clave ajena en COMPRA**: `idCliente` referencia a `idCliente` en la tabla CLIENTE, indica la relación entre una compra y el cliente que la ha realizado.
- **Clave ajena en COMPRA**: `dniDependiente` referencia a `dni` en la tabla DEPENDIENTE, indica la relación entre una compra y el dependiente que la gestiona.
- **Clave ajena en COMPRA**: `dniRepartidor` referencia a `dni` en la tabla REPARTIDOR, indica la relación entre una compra y el repartidor que la gestiona.
  - **Restricción de borrado**: rechazar
  - **Restricción de modificación**: propagar

### LINEA_DE_TICKET
- **Clave primaria en LINEA_DE_TICKET**: `numCompra, numLinea`
- **Clave primaria en COMPRA**: `numCompra`
- **Clave primaria en PRODUCTO**: `codigo`
- **Clave ajena en LINEA_DE_TICKET**: `numCompra` referencia a `numCompra` en la tabla COMPRA, indica la relación de identificación entre una compra y una de sus líneas de ticket.
- **Clave ajena en LINEA_DE_TICKET**: `codProducto` referencia a `codigo` en la tabla PRODUCTO, indica la relación entre una línea de ticket y el producto que contiene.
  - **Restricción de borrado**: rechazar
  - **Restricción de modificación**: propagar

### AJENO
- **Clave primaria en PRODUCTO**: `codigo`
- **Clave primaria en AJENO**: `codigo`
- **Clave ajena en AJENO**: `codigo` referencia a `codigo` en la tabla PRODUCTO, indica que un producto ajeno es un producto.
  - **Restricción de borrado**: propagar
  - **Restricción de modificación**: propagar

### PROPIO
- **Clave primaria en PRODUCTO**: `codigo`
- **Clave primaria en PROPIO**: `codigo`
- **Clave ajena en PROPIO**: `codigo` referencia a `codigo` en la tabla PRODUCTO, indica que un producto propio es un producto.
  - **Restricción de borrado**: propagar
  - **Restricción de modificación**: propagar

### HACER
- **Clave primaria en HACER**: `codProdPropio, dniPanadero`
- **Clave primaria en PROPIO**: `codigo`
- **Clave primaria en PANADERO**: `dni`
- **Clave ajena en HACER**: `codProdPropio` referencia a `codigo` en la tabla PROPIO.
- **Clave ajena en HACER**: `dniPanadero` referencia a `dni` en la tabla PANADERO.
  - **Restricción de borrado**: rechazar
  - **Restricción de modificación**: propagar

### SUMINISTRAR
- **Clave primaria en SUMINISTRAR**: `codProdAjeno, codProveedor`
- **Clave primaria en AJENO**: `codigo`
- **Clave primaria en PROVEEDOR**: `codProveedor`
- **Clave ajena en SUMINISTRAR**: `codProdAjeno` referencia a `codigo` en la tabla AJENO.
- **Clave ajena en SUMINISTRAR**: `codProveedor` referencia a `codProveedor` en la tabla PROVEEDOR.
  - **Restricción de borrado**: rechazar
  - **Restricción de modificación**: propagar

### VENDER
- **Clave primaria en VENDER**: `codProveedor, codIngrediente`
- **Clave primaria en PROVEEDOR**: `codProveedor`
- **Clave primaria en INGREDIENTE**: `codIngrediente`
- **Clave ajena en VENDER**: `codProveedor` referencia a `codProveedor` en la tabla PROVEEDOR.
- **Clave ajena en VENDER**: `codIngrediente` referencia a `codIngrediente` en la tabla INGREDIENTE.
  - **Restricción de borrado**: rechazar
  - **Restricción de modificación**: propagar

### CONTENER
- **Clave primaria en CONTENER**: `codIngrediente, codProdPropio`
- **Clave primaria en INGREDIENTE**: `codIngrediente`
- **Clave primaria en PROPIO**: `codigo`
- **Clave ajena en CONTENER**: `codIngrediente` referencia a `codIngrediente` en la tabla INGREDIENTE.
- **Clave ajena en CONTENER**: `codProdPropio` referencia a `codigo` en la tabla PROPIO.
  - **Restricción de borrado**: rechazar
  - **Restricción de modificación**: propagar


# DDL, DML y Script de vaciado de tablas

En este proyecto, trabajamos juntas para crear las tablas y la base de datos. Jessica, Vanesa y Silvia participamos activamente en todas las tareas. Nos basamos en el modelo EER y relacional, así como en el diccionario de datos que habíamos elaborado previamente. Primero, nos encargamos de escribir el DDL (lenguaje de definición de datos), es decir, la estructura de las tablas, y luego definimos las restricciones de clave primaria y foránea. A medida que escribíamos, nos ayudábamos mutuamente, revisábamos errores y ajustábamos los detalles. También creamos los scripts de inserción de datos (DML) y los scripts de borrado de datos. Cada una de nosotras aportó en diferentes partes del proceso, pero lo hicimos de manera colaborativa, asegurándonos de que todo fuera coherente y funcional.



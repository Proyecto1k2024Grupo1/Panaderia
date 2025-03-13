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

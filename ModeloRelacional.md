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

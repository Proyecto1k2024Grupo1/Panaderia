-- Vanesa  Sekeresh
--Lista el codigo, nombre y el tipo de productos.
```sql
select codigo, nombre, tipo from PRODUCTO;
```

--Lista los teléfonos y el id de los clientes que han realizado una compra el 01/01/2024.
```sql
select distinct t.numTelefono, c.idCliente from TELEFONO t 
join CLIENTE c on t.idCliente = c.idCliente
join COMPRA co on c.idCliente = co.idCliente
where co.fecha = '2024-01-01';
```

--Lista el nombre de los repartidores y su dni.
```sql
select e.nombre, r.dni 
from REPARTIDOR r
join EMPLEADO e ON r.dni = e.dni;
```

-- Jessica Brotons Maciá
-- Lista el empleado más joven junto con su fecha de nacimiento.
```sql
SELECT nombre, fnac
FROM EMPLEADO
ORDER BY fnac DESC
LIMIT 1;
```

-- Lista los clientes los cuales su número de teléfono empiece por "1111".
```sql
SELECT c.nombre, c.apellido1, c.apellido2, t.numTelefono
FROM CLIENTE c
JOIN TELEFONO t ON c.idCliente = t.idCliente
WHERE t.numTelefono LIKE '1111%'
ORDER BY c.nombre;
```

-- Lista los productos de tipo "dulce" que su precio sea entre 0,5€ y 2€.
```sql
SELECT nombre, precio
FROM PRODUCTO
WHERE tipo = 'dulce'
  AND precio BETWEEN 0.5 AND 2
ORDER BY precio;
```

-- Silvia Cachón Leiva
-- Lista de productos con su precio y precio sin IVA.
```sql
SELECT 
    p.nombre, 
    p.precio, 
    p.precio / 1.21 AS Precio_Sin_IVA
FROM 
    PRODUCTO p;

-- Suma total de todas las compras en marzo
SELECT 
    SUM(tl.cantidad * p.precio) AS Total_Ingresos_Marzo
FROM 
    LINEA_DE_TICKET tl
JOIN 
    PRODUCTO p ON tl.codProducto = p.codigo
JOIN 
    COMPRA t ON tl.numCompra = t.numCompra
WHERE 
    MONTH(t.fecha) = 3;  
```

-- Obtener los repartidores que han realizado entregas entre las 11:00 y las 12:00 horas según las compras.
```sql
SELECT DISTINCT c.dniRepartidor, e.nombre
FROM COMPRA c
JOIN REPARTIDOR r ON c.dniRepartidor = r.dni
JOIN EMPLEADO e ON r.dni = e.dni
WHERE HOUR(c.horaRepartidor) BETWEEN 11 AND 12;
```

-- Gasto por compra en abril, mostrando nombre del cliente, gasto por compra, dirección y fecha, ordenado por importe.
```sql
SELECT 
    c.nombre,
    (tl.cantidad * p.precio) AS Gasto, 
    c.direccion,
    t.fecha
FROM 
    CLIENTE c
JOIN 
    COMPRA t ON c.idCliente = t.idCliente
JOIN 
    LINEA_DE_TICKET tl ON t.numCompra = tl.numCompra
JOIN 
    PRODUCTO p ON tl.codProducto = p.codigo
WHERE 
    MONTH(t.fecha) = 4  
ORDER BY 
    Gasto DESC; 
```

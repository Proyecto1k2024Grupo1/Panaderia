-- Vanesa  Sekeresh

--Lista el codigo, nombre y el tipo de productos.
```sql
select codigo, nombre, tipo from PRODUCTO;
```
![imagen](https://github.com/user-attachments/assets/543b230e-3a0f-4785-b52a-1b1d620ea5e5)

--Lista los teléfonos y el id de los clientes que han realizado una compra el 01/01/2024.
```sql
select distinct t.numTelefono, c.idCliente from TELEFONO t 
join CLIENTE c on t.idCliente = c.idCliente
join COMPRA co on c.idCliente = co.idCliente
where co.fecha = '2024-01-01';
```
![imagen](https://github.com/user-attachments/assets/86bd1897-192b-41c9-b323-8d733c4cc504)


--Lista el nombre de los repartidores y su dni.
```sql
select e.nombre, r.dni 
from REPARTIDOR r
join EMPLEADO e ON r.dni = e.dni;
```
![imagen](https://github.com/user-attachments/assets/7d6e1013-1cb4-463c-bbc9-891618e749f0)


-- Jessica Brotons Maciá

-- Lista el empleado más joven junto con su fecha de nacimiento.
```sql
SELECT nombre, fnac
FROM EMPLEADO
ORDER BY fnac DESC
LIMIT 1;
```
![imagen](https://github.com/user-attachments/assets/b4aa9067-2953-47f4-9426-479da16ac102)

-- Lista los clientes los cuales su número de teléfono empiece por "1111".
```sql
SELECT c.nombre, c.apellido1, c.apellido2, t.numTelefono
FROM CLIENTE c
JOIN TELEFONO t ON c.idCliente = t.idCliente
WHERE t.numTelefono LIKE '1111%'
ORDER BY c.nombre;
```
![imagen](https://github.com/user-attachments/assets/56ea95cc-fe80-4bd5-a328-226102f04964)


-- Lista los productos de tipo "dulce" que su precio sea entre 0,5€ y 2€.
```sql
SELECT nombre, precio
FROM PRODUCTO
WHERE tipo = 'dulce'
  AND precio BETWEEN 0.5 AND 2
ORDER BY precio;
```
![imagen](https://github.com/user-attachments/assets/28889623-d979-4649-aa83-a1dbf146041a)


-- Silvia Cachón Leiva

-- Lista de productos con su precio y precio sin IVA.
```sql
SELECT 
    p.nombre, 
    p.precio, 
    p.precio / 1.21 AS Precio_Sin_IVA
FROM 
    PRODUCTO p;
```
![imagen](https://github.com/user-attachments/assets/0b4dd661-b347-430d-826f-d3353011b152)


-- Suma total de todas las compras en marzo
```sql
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
![imagen](https://github.com/user-attachments/assets/3f197464-e993-4a85-87d6-54bba20a324f)


-- Obtener los repartidores que han realizado entregas entre las 11:00 y las 12:00 horas según las compras.
```sql
SELECT DISTINCT c.dniRepartidor, e.nombre
FROM COMPRA c
JOIN REPARTIDOR r ON c.dniRepartidor = r.dni
JOIN EMPLEADO e ON r.dni = e.dni
WHERE HOUR(c.horaRepartidor) BETWEEN 11 AND 12;
```
![imagen](https://github.com/user-attachments/assets/e4db7363-1070-4300-90ff-68858b6c0e56)


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
![imagen](https://github.com/user-attachments/assets/0506589f-3bc2-44e0-b670-658baf10f5b2)

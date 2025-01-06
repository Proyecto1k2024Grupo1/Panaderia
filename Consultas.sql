--Lista el codigo y el tipo de productos.
select codigo, tipo from PRODUCTO;

--Lista los teléfonos y el id de los clientes que han realizado una compra el 01/01/2024.
select t.numTelef, c.idCliente from telefono t 
join cliente c on t.idCliente = c.idCliente
join compra co on c.idCliente = co.idCliente
where co.fecha = '2024-01-01';

--Lista el nombre de los repartidores y su dni.
select e.nombre, r.dni 
from repartidor r
join empleado e ON r.dni = e.dni;


-- 1. Lista el empleado más joven junto con su fecha de nacimiento.
SELECT nombre, fnac
FROM EMPLEADO
ORDER BY fnac DESC
LIMIT 1;

-- 2. Lista los clientes los cuales su número de teléfono empiece por "1111".
SELECT c.nombre, c.apellido1, c.apellido2, t.numTelefono
FROM CLIENTE c
INNER JOIN TELEFONO t ON c.idCliente = t.idCliente
WHERE t.numTelefono LIKE '1111%'
ORDER BY c.nombre;

-- 3.Lista los productos cuyo precio no es compartido por ningún otro producto.
SELECT p1.nombre, p1.precio
FROM PRODUCTO p1
WHERE NOT EXISTS (
    SELECT 1
    FROM PRODUCTO p2
    WHERE p1.precio = p2.precio
      AND p1.codigo != p2.codigo
)
ORDER BY p1.precio;

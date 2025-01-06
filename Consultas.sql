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

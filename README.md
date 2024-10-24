# Proyecto Intermodular
# Grupo 1

## Integrantes:
* Jessica Brotons Maciá (https://github.com/LaJessyMiau)
* Doaa  Chaoui Ragaoui (https://github.com/DoaaChaoui)
* Silvia Cachón Leiva (https://github.com/39Luka)
* Vanesa Sekeresh (https://github.com/Timia117)

## Sistema de información

Somos una panadería y deseamos crear una base de datos para nuestro negocio.

Necesitamos guardar información de nuestros clientes: nombre completo, dirección, números de teléfono, qué compras ha realizado y en qué fecha.

De los productos queremos saber el tipo (dulce, salado, etc.), si es suministrado por un proveedor o elaborado por nuestros panaderos. Si son propios, además, los ingredientes utilizados y qué proveedor los suministra.

En cada ticket de compra tiene que venir el nombre del producto que se ha comprado, la cantidad, el precio, la fecha, si se le aplicó algún descuento y qué dependiente le atendió. Para realizar las posteriores facturas, también necesitamos saber qué ticket pertenece a cada cliente.

Además, de nuestros servicios a domicilio queremos llevar un control de las entregas donde quede registrado en qué fecha y hora un repartidor ha entregado un pedido a un cliente.

De todos nuestros empleados debemos guardar su DNI, nombre, edad, salario, su puesto de trabajo y si son supervisados por un encargado y cuál es.

## Modelo Entidad-Relación


![Modelo ER Panadería Actualizado](https://github.com/user-attachments/assets/0d594cc3-9119-453a-9438-af149405fd22)



## Justificaciones
El atributo fecha va en compra y no en la relación porque una compra tiene la fecha del momento en que se realizó y no depende del cliente, ya que esa compra no se vende en diferentes fecchas. En cuanto a los productos, tenemos dos tipos: los suministrados y los que hace la panadería. Como tienen relaciones diferentes hemos creado una generalización para distinguirlos, la cual, es disjunta porque un producto propio no puede ser ajeno y viceversa. Además, hemos generado una entidad débil llamada línea de ticket porque un ticket de una compra tiene varias líneas donde se especifica cada uno de los productos que se ha comprado. La cantidad de un producto se incluye en la relación porque la cantidad hace referencia a la entidad de producto y también a la linea de ticket, ya que tenemos cierta cantidad del producto en una línea en especifico.

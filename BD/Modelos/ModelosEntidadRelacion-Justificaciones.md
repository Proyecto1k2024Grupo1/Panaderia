## Modelo entidad-relación
![imagen](https://github.com/user-attachments/assets/42ee941e-3059-42c0-aed4-fe7354d6a85f)



## Justificaciones
El atributo fecha va en compra y no en la relación, porque una compra tiene la fecha del momento en que se realizó y no depende del cliente, ya que esa compra no se vende en diferentes fechas.

En cuanto a los productos, tenemos dos tipos: los suministrados y los que hace la panadería. Como tienen relaciones diferentes, hemos creado una generalización para distinguirlos, la cual, es disjunta porque un producto propio no puede ser ajeno y viceversa. También hemos hecho una generalización en empleados porque comparten ciertos datos, como el DNI, nombre, etc.; pero a su vez hay varios tipos de empleados: panadero, dependiente y repartidor; que desempeñan diferentes funciones y, por tanto, tienen distintas relaciones.

Hemos generado una entidad débil llamada línea de ticket porque un ticket de una compra tiene varias líneas donde se especifica cada uno de los productos que se ha comprado. La cantidad de un producto se incluye en la relación porque la cantidad hace referencia a la entidad de producto y también a la línea de ticket, ya que tenemos cierta cantidad del producto en una línea en específico.

Lo mismo ocurre entre producto propio e ingrediente, ya que un producto propio contiene cierta cantidad de un ingrediente; entre compra y dependiente, ya que una compra la vende un dependiente en una fecha y con un descuento determinado; entre repartidor y compra, ya que un repartidor reparte una compra en una fecha y hora concreta.

En la relación reflexiva de ser empleado en la entidad empleado, hemos utilizado la cardinalidad ninguno o una a ninguno o muchos, porque un empleado no está obligado a ser encargado ni está obligado a tener encargado.

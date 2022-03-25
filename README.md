* Parte 1: SQL

* Realizar las consultas sql necesarias para obtener los siguientes datos:

* Todos los productos del rubro "libreria", creados hoy.
```sql
select p.*
from producto p join rubro r on r.id_rubro = p.id_rubro
where p.fecha_creacion = getdate()
and r.rubro like 'libreria'
```


* Monto total vendido por cliente (mostrar nombre del cliente y monto).
```sql
select sum(v.precio * v.cantidad) as'Monto Total Vendido', v.nombre
from venta v 
group by v.nombre
```

* Cantidad de ventas por producto.
```sql
select count(v.id_venta)as'Cantidad Ventas', codigo_producto
from venta v
group by codigo_producto
```

* Cantidad de productos comprados por cliente en el mes actual.
```sql
select sum(v.cantidad) as 'Cantidad de Productos',v.id_cliente
from venta v
where month(v.fecha) = month(getdate()) and year(v.fecha) = year(getdate())
group by v.id_cliente
```

* Ventas que tienen al menos un producto del rubro "bazar".

```sql
select v.*
from venta v join producto p on p.codigo = v.codigo_producto
where  1 <= (
                select p.id_rubro
                from producto p join rubro r on r.id_rubro = p.id_rubro
                where r.rubro like 'bazar'
            )
```

* Rubros que no tienen ventas en los ultimos 2 meses.
```sql
select r.*
from rubro r
where not exists (
                    select id_rubro
                    from producto p
                    where year(p.fecha_creacion) = year(getdate()) 
                    and (month(p.fecha_creacion) = month(getdate())-1 
                    or month(p.fecha_creacion) = month(getdate()))
                    and r.id_rubro = id_rubro
                )
```




Parte 2: Java
Crear un programa que simule un partido de tenis, el mismo debe solicitar al usuario ingresar los datos del partido (jugadores, nombre del torneo, etc) 
y con estos debe ejecutar punto por punto el transcurso del partido hasta llegar a su fin. 


El programa deberá tener en cuenta la puntuación y reglas utilizadas en este deporte.

Funcionalidades
Antes de comenzar la simulación, el usuario podrá ingresar los siguientes datos:
* Nombres de los jugadores 
* Nombre del torneo
* Definición de la cantidad de sets: al mejor de 3 o al mejor de 5
* Probabilidad de que cada jugador gane el partido (tiene que ir del 1 al 100% e influir en el resultado final)

El programa deberá simular punto por punto de forma automática, donde el ganador de cada uno sera 
determinado de forma aleatoria (teniendo en cuenta la probabilidad definida al principio), y los mismos 
se tienen que visualizar por pantalla. Datos a mostrar:

* Ganador del punto 
* Resultado parcial del game
* Al comenzar un game, mostrar el jugador que tiene el saque
* Al finalizar cada SET, se mostrará el ganador y el resultado parcial del partido.

Una vez finalizado el partido:
* Imprimir el resultado en formato de partido de tenis

* Imprimir el nombre del ganador y del torneo

* Preguntar al usuario si quiere jugar la revancha, en caso de que la respuesta sea si, simular nuevamente.

A considerar
* No se evaluará de forma estricta la interfaz, por lo que puede hacerse por consola.
* No es necesario que haya persistencia
* El programa tiene que compilar y poder ejecutarse sin problema
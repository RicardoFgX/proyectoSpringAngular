Este readme se va a tratar de una pequeña descripción de los archivos que lo componen asi como unas pequeñas pautas del mismo, podría explayarme elaborando un readme increiblemente largo y complejo pero he optado por un enfoque más básico.

Bien, como le comenté el último día, le entrego por una parte la parte del front, hecho con Angular, por supuesto y por otro lado dos carpetas más; backend y backend2, la parte de base de datos se realiza para este caso y no liar el proyecto mediante h2, se que hubiera sido más correcto con un MySql con un docker pero como era un proyecto cerrado en el sentido de que es de puertas para adentro que lo ves tu, yo y poco más he decidido realizarlo así. A continuación daré una pequeña descripción de las carpetas del back:

## Backend
- El primero, backend, tiene la parte de la aplicación del back, en Spring, de forma operativa para realizar las tareas del CRUD sin requisito de login ni nada. Un CRUD sencillo para realizar las 4 operaciones y que se vea que almenos esa parte de angular esta más que dominada con el uso de rutas, componentes y hijos y demás.
## Backend2
- El segundo, backend2, si, ese proyecto que tantos quebraderos de cabezas llevó el último día, aunque este es más que nada por curiosidad por si lo mismo con todo el codigo como tal por delante, lo mismo se da con el punto o el atributo mal puesto o que se yo.

No lo he expecificado pero tanto en backend como backend2, tiene una clase de java para inicializar datos en la BD, por lo que no se necesita que se añada inicialmente ninguno, ni ningún script de generación. Así es más rapido y sencillo creo yo.

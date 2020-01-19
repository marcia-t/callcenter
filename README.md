# callcenter

Existe un call center donde hay 3 tipos de empleados: operador, supervisor
y director. El proceso de la atención de una llamada telefónica en primera
instancia debe ser atendida por un operador, si no hay ninguno libre debe
ser atendida por un supervisor, y de no haber tampoco supervisores libres
debe ser atendida por un director.



### Extras/Plus

#### Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.
Se solucionó esta incidencia gracias a la PriorityBlockingQueue de Java que ofrece, además de ser threadsafe, el método take(), que devuelve un elemento si es que hay disponible o se queda esperando hasta que haya algún elemento en la cola.

#### Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes.
Cuando se crea el Dispatcher se setea la cantidad de threads (en este caso 'llamadas activas al mismo tiempo') que habrá disponibles en base a la cantidad de empleados que llegan por parámetro. Si hubiera más llamadas concurrentes, el fixedPool de threads utilizado dejará en una cola las llamadas entrantes hasta que se libere un thread y se pueda ejecutar el pedido. 

#### Agregar los tests unitarios que se crean convenientes.
Se agregaron test unitarios para operaciones atómicas e independientes.

#### Agregar documentación de código
Las clases se encuentran documentadas. Se adjunta además, en la carpeta doc, el diagrama de clases.

### Fuentes de consulta
Si bien no cuento con mucha experiencia trabajando en JAVA, pude resolver este ejercicio gracias a las siguientes fuentes:

https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/

https://www.tutorialspoint.com/java_concurrency/concurrency_newfixedthreadpool.htm

https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html

https://www.geeksforgeeks.org/priorityblockingqueue-class-in-java/


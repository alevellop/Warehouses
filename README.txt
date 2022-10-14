//------	INSTRUCCIONES	------\\

Contenido del fichero 'zip':
	1-	carpeta 'warehouses' con el proyecto backend
	2-	carpeta 'frontend-warehouse' con el proyecto frontend
	3-	colección de tipo 'json' para realizar llamadas de prueba de los distintos servicios desde Postman
	4-	Documento de tipo 'dcox' con los requisitos del proyecto
	5-	Documento 'README' con el contexto del proyecto y su uso


1- Proyecto backend 'Warehouse'

	-	Realizado con:
		-	Java 11
		-	Spring Boot
		-	IDE Intellij
		-	H2
		-	Hibernate
		-	JUnit
	
	-	Modelos:
		-	Warehouse	-	Representa a los almacenes (tiene una relación 'OneToMany' bidireccional con 'Rack')
		-	Rack		-	Representa a las estanterias (tiene una relación 'ManyToOne' bidireccional con 'Warehouse')
		-	RacksType	-	Representa a los tipos de estanterías asociadas a un tipo de familia (sin relación de ningún tipo con otro modelo)
		-	Permutation -	Modelo sencillo para generar las permutaciones de tipos de estanterías posibles (sin relación de ningún tipo con otro modelo)
	
	
	- Cómo ejecutar:
		Desde cualquier IDE al que se haya importado el proyecto, aunque se recomienda usar Intellij por ser donde se realizó
		para mayor compatibilidad.
		
		-	Al iniciar el proyecto ya crea la BBDD e inserta en ellas unos datos mínimos para realizar pruebas con Postman(por ejemplo).
		
	
	-	Tests Unitarios:
		-	Se ahn añadidos una serie de tests para los modelos
		-	Se ha iniciado tests para los controladores (aunque falla)
	

2-	Proyecto frontend 'frontend-warehouse

	-	Realizado con:
		-	Angular 14
		-	IDE Visual Studio Code
		-	Bootstrap
		
	- Vistas:
		-	Índice	-	/api/warehouses
			-	Listado de almacenes
		
		-	Detalle de almacen	-	/api/warehouses/{id_almacen}
			-	Detalles de un almacén junto con el listado de estantarías relacionadas
		
		-	Crear un almacén	-	/api/warehouses/create
		
		- Permutaciones	-	/api/permutations
			-	Información sobre las posibles permutaciones de los tipos de estanterias según la familia (sin terminar)
			
	-	Cómo ejecutar:
		1-	Ejecutar proyecto backend sobre el puerto '8080'.
		2-	Desde la consola de comandos buscar la carpeta de 'frontend-warehouse' y ejecutar desde ella el siguiente comando para auto-iniciar la aplicación desde le navegador:
			ng s --open
			
3-	Colección de llamadas de los distintos servicios en formato 'json'
	Juego de llamadas para cada uno de los servicios creados en la aplicación. Es necesario importarlos en Postman para poder lanzarlos con los datos ya incluidos (aunque se pueden insertar otros)
	


//----	Objetivos conseguido	----//
	
-	Backend
	-	Generar tablas en H2 e insertar información mínima viable
	-	Operaciones CRUD sobre los distintos modelos (sólo operaciones necesarias)
	-	Tests para los modelos
	-	Gestión de excepciones
	-	Cálculo de permutaciones (mediante libreria 'combinatoricslib3')
	
-	Frontend
	-	Vista de la lista de almacenes
	-	Vista detalle de un almacén (y sus estanterías)
	-	Formulario para crear un almacén
	-	Vista con las distintas permutaciones posibles de las estanterías (sin terminar)
	-	Operaciones que se pueden realizar:
		-	Ver detalle de almacen
		-	Eliminar/Crear un almacén


//----	Objetivos NO conseguido	----//

-	Backend
	-	Tests de todos los controladores, servicios, y gestor de excepciones
	-	Cálculo de permutaciones de manera interna, sin usar librerías externas
	
-	Frontend
	-	Diseño responsivo para las pantallas
	-	Terminar vista de permutaciones (sin terminar)
	-	Terminar la edición de un almacén y desde el que se pueda añadir y eliminar estanterias
	-	Paginar lista de almacenes y lista de estantarias en sus correspondientes tablas
	

//----	Dificultades encontradas	----//

-	Backend
	-	Cálculo de permutaciones	-	Por falta de tiempo se decidió usar una librería externa para continuar con el ejercicio
	-	Tests						-	Por falta de tiempo no se han podido corregir y añadir tests
	-	H2							-	Nunca había trabajado con H2 para BBDD y tuve que documentarme un poco para conocerlo y usarlo debidamente

-	Frontend
	-	Angular 14					-	Hasta ahora la última versión con la que he trabajado es la 9, esta nueva versión trae algunas mejoras de las que me tuve que documentar un poco para su uso
	-	Formularios reactivos		-	Concepto nuevo para mi, y con el que no he tenido tiempo de profundizar para desarrollar correctamente la edición de un almacen
	-	Tablas dinámicas con CSS	-	Bootstrap puede facilitar el trabajo a la hora de diseñar una web/aplicación, pero eso conlleva en muchos casos generar más código del necesario (y compartir un estilo my carácterístico entre quienes lo usan).
										Para este proyecto me hubiera gustado generar las tablas con las nuevas propiedades y funciones flexibles de CSS, sobre todo para las tablas de las permutaciones, ya que permite dimensionar y ubicar los elementos
										casi de manera automática indicando tan sólo una serie de condiciones. Lo que permite tener un código más limpio, y cumplir con el estandar de maquetación web.


//----	Conclusión	----//

Este ejercicio se me presentó como 'un ejercicio sencillo que se realiza en dos horas' (palabras textuales) y para nada lo es. Me explico: es un ejercicio sencillo por plantear una relación entre tablas sencilla y unas operaciones sencillas. Pero no por eso
quiere decir que se pueda realizar en dos horas, ya que implica generar dos mini proyectos con distintas tecnologías y conectarlos correctamente entre ellos, sobrepasando con facilidad cada proyecto las dos horas indicadas.

Me ha supuesto un reto al tener que trabajar con elementos desconocidos hasta ahora para mi (H2, formularios reactivos, trabajar con una versión actual de Angular,...), y es un conocimiento que puedo aportar a mi trabajo. Le he dedicado muchas horas de mi tiempo
libre, y lo he disfrutado mucho. Y aún entregándolo sin terminar, lo seguiré haciendo en mi tiempo libre para seguir aprendiendo de los distintos retos que me voy encontrando en su desarrollo.


//----	FIN	----//
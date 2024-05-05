# gapsi-web
GAPSI eval frontend

## Prerrequisitos para levantar el proyecto

1. Tener instalada una versión de JDK 17 o superior. En caso no se tenga, puede instalarse en la siguiente ruta: https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.msi

## Instrucciones para levantar el proyecto

1. Ejecutar el archivo "gapsi-ws.jar".
2. Ejecutar el archivo "gapsi-web.jar"

### Notas adicionales

* El backend "gapsi-ws" está configurado para correr en el puerto 6060.
* El frontend "gapsi-web" está configurado para correr en el puerto 8080.
* Se puede verificar que los proyectos han levanto exitosamente si es que en el mismo directorio donde estos se encuentran, aparecen los archivos de log "gapsi-web.log" y "gapsi-ws.log" respectivamente.
* La dirección para consultar la documentación de los servicios REST es la siguiente:

```
Swagger: http://localhost:6060/gapsi-ws/swagger-ui/index.html
openapi (exportable a Postman): http://localhost:6060/gapsi-ws/v3/api-docs
```

* La dirección para acceder a la aplicación frontend es la siguiente:

```
http://localhost:8080/gapsi-web/
```

* Las rutas de los repositorios Github públicos son las siguientes:

```
https://github.com/warlux/gapsi-web
https://github.com/warlux/gapsi-ws
```

## Consideraciones adicionales

* Ambos proyectos están construidos en Java v17 mediante Spring Boot 3.2.5. Para la estrategia de renderizado de plantillas se utiliza Spring MVC junto con Thymeleaf.
* Se ha tenido cuidado para cumplir a cabalidad todos los requerimientos funcionales y no funcionales que aplican a la tecnología utilizada.
* Se ha optado por utilizar la Base de Datos en memoria H2. Esta base de datos se inicializa con el contenido del archivo "proveedores.json" ubicado en el directorio "src/main/resources", y persiste mientras el proyecto "gapsi-ws" se encuentre en estado de ejecución. Cuando la aplicación es finalizada, la base de datos se elimina.
* La funcionalidad de virtual scroll se implementa a través del plugin "scroller" de datatables: https://datatables.net/extensions/scroller/
* Patrones de diseño utilizados (o heredados) en el proyecto:

```
* Inversión de Control
* N Tiers
* Factory
* Singleton
* Patrón estructural MVC
* Patrón estructural DAO
```

* La aplicación implementa un diseño responsive.
* Las librerías bootstrap, datatables, font-awesome y jquery son accedidas a través de CDN

## Autor

Miguel Angel Merino Vega
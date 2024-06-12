REQUISITOS FUNCIONALES:

Un requisito funcional es una declaración de cómo debe comportarse un sistema. Define lo que el sistema debe hacer para satisfacer las necesidades o expectativas del usuario. Los requisitos funcionales se pueden considerar como características que el usuario detecta. Son diferentes de los requisitos no funcionales, que definen cómo debe funcionar internamente el sistema 
- Historias Épicas: https://docs.google.com/spreadsheets/u/0/d/1Zn9bsSx7eAeilC15REzf2Q9giALNRyLaxSAkej18kLw/edit
- Historias de Usuario: https://docs.google.com/spreadsheets/u/0/d/1oLz2MHG8f-P4wrxAKdQlHT7bh6MhzyOPtvrheS23mPQ/edit

REQUISITOS NO FUNCIONALES:
Rendimiento:
Escenario: Durante un evento de ventas especiales, como el Black Friday, se registra un pico de tráfico en el sitio web.
Estímulo: Aumento repentino en el número de usuarios y solicitudes de compra.
Respuesta: El sistema debe mantener tiempos de respuesta rápidos y estables, con una capacidad para manejar al menos el doble de la carga habitual sin degradación del rendimiento.
Seguridad:
Escenario: Un hacker intenta acceder a la base de datos del sistema para robar información de clientes.
Estímulo: Intento de acceso no autorizado a través de técnicas de piratería.
Respuesta: El sistema debe resistir intentos de intrusión mediante medidas como el cifrado de datos, la autenticación de dos factores y la detección de intrusiones. Debe registrar y notificar cualquier intento de acceso no autorizado para su análisis posterior.
Disponibilidad:
Escenario: Durante el horario comercial, un cliente intenta acceder al sitio web para realizar una compra.
Estímulo: Acceso al sitio web a través de un navegador web estándar.
Respuesta: El sitio web debe estar disponible y accesible las 24 horas del día, los 7 días de la semana, con un tiempo de inactividad planificado mínimo para mantenimiento programado. El tiempo de respuesta para cargar la página principal no debe exceder los 3 segundos en condiciones normales de tráfico.
Escalabilidad:
Escenario: Hyun Seda lanza una nueva línea de productos que genera un aumento en el tráfico del sitio web.
Estímulo: Incremento en el número de usuarios y solicitudes de compra.
Respuesta: El sistema debe poder escalar horizontalmente para manejar el aumento en la carga sin afectar el rendimiento. Se deben implementar tecnologías y prácticas que permitan agregar recursos adicionales según sea necesario.
Usabilidad:
Escenario: Un cliente navega por el sitio web en busca de un producto específico.
Estímulo: Interacción con la interfaz de usuario del sitio web.

Respuesta: La interfaz de usuario debe ser intuitiva y fácil de usar, con un diseño limpio y una navegación clara. Se deben minimizar los clics y los tiempos de carga para mejorar la experiencia del usuario.
Mantenibilidad
Escenario: Un desarrollador necesita corregir un error en el sistema.
Estímulo: Identificación de un problema durante pruebas de calidad o revisiones de código.
Respuesta: El código del sistema debe estar bien estructurado, documentado y modularizado para facilitar la identificación y corrección de errores. Se deben seguir prácticas de desarrollo ágil y utilizar herramientas de gestión de versiones para mantener un código limpio y organizado.
Compatibilidad:
Escenario: Un cliente intenta acceder al sitio web desde su dispositivo móvil.
Estímulo: Acceso al sitio web a través de un navegador móvil en un dispositivo Android.
Respuesta: El sitio web debe ser compatible con una amplia gama de dispositivos y navegadores, incluidos dispositivos móviles, tabletas y computadoras de escritorio. Debe ajustarse automáticamente al tamaño de pantalla y mantener una funcionalidad completa en todos los dispositivos compatibles.
Legal y normativo:
Escenario: Un cliente realiza una compra y proporciona información personal y financiera.
Estímulo: Ingreso de datos personales y de pago durante el proceso de compra.
- Respuesta: El sistema debe cumplir con todas las leyes y regulaciones aplicables en cuanto a privacidad de datos, protección del consumidor y seguridad de la información. Debe seguir estándares de seguridad de la industria y utilizar prácticas recomendadas para proteger la información del cliente y garantizar transacciones seguras.

Escalabilidad
Uno de los principales beneficios de adoptar una arquitectura de microservicios es la capacidad de escalar los diferentes componentes del sistema de forma independiente según las necesidades de carga. En el sistema de gestión de ventas en línea de Hyun Seda, se implementaron estrategias para permitir la escalabilidad horizontal y vertical de los microservicios.

Escalabilidad Horizontal
La escalabilidad horizontal implica agregar más instancias de un microservicio para manejar un mayor volumen de solicitudes. Esto se logró mediante el uso de Docker y Kubernetes:
Cada microservicio se empaqueta como una imagen de Docker, lo que facilitó su implementación como contenedores ligeros e independientes.
Kubernetes se utilizó para orquestar y gestionar los contenedores de los microservicios, permitiendo escalar horizontalmente cada microservicio de forma dinámica según la demanda.
Se configuraron reglas de escalado automático en Kubernetes, que monitorean métricas como el uso de CPU y memoria, y ajustaban automáticamente el número de réplicas de cada microservicio según fuera necesario.

Escalabilidad Vertical
Además de la escalabilidad horizontal, también se implementó la escalabilidad vertical, que implica aumentar los recursos (CPU, memoria, etc.) asignados a cada instancia de un microservicio.
Se utilizaron instancias de computación escalables en la nube, lo que permitió ajustar fácilmente los recursos asignados a cada microservicio según sus necesidades.
Se monitorea continuamente el rendimiento y la utilización de recursos de cada microservicio, y se ajustaron los recursos verticalmente cuando se detectaron cuellos de botella o saturación de recursos.


ARQUITECTURA DE SOFTWARE DECISIONES DE ARQUITECTURA: 

- Arquitectura de Microservicios: Además de la arquitectura en capas, el patrón Modelo-Vista-Controlador (MVC) y la arquitectura microkernel descritas anteriormente, el sistema de gestión de ventas en línea de Hyun Seda también adopta una arquitectura de microservicios. Esto permite una mayor modularidad, escalabilidad y flexibilidad en el desarrollo y mantenimiento del sistema.

El sistema se compone de los siguientes microservicios, cada uno enfocado en un dominio específico del negocio:
Microservicio Usuario: Encargado de la gestión de usuarios y roles. Contiene las entidades User y Role.
Microservicio Cliente: Maneja la información de los clientes, como nombre, apellido, dirección, etc. Contiene la entidad Client.
Microservicio Producto: Gestiona el catálogo de productos, incluyendo detalles como id, nombre, stock y categoría asociada. Contiene las entidades Product y Category.
Microservicio Pedido: Responsable del proceso de realización de pedidos. Contiene las entidades Order e Ítem, donde Ítem representa los productos individuales dentro de un pedido.

La adopción de una arquitectura de microservicios en el sistema de gestión de ventas en línea de Hyun Seda ofrece varios beneficios:
Modularidad: Cada microservicio se enfoca en una funcionalidad específica, lo que facilita el desarrollo, pruebas y mantenimiento de cada componente de forma independiente.
Escalabilidad: Los microservicios pueden escalarse de forma individual según las necesidades de carga, sin afectar a otros componentes del sistema.
Flexibilidad: Debido a su naturaleza desacoplada, los microservicios permiten la incorporación de nuevas tecnologías y la actualización de componentes individuales sin interrumpir el funcionamiento del sistema completo.
Resiliencia: Si un microservicio falla, el resto del sistema puede continuar funcionando, lo que mejora la tolerancia a fallos y la disponibilidad general del sistema.

- Spring Boot: Para la implementación de la arquitectura de microservicios en el sistema de gestión de ventas en línea de Hyun Seda, se utilizó el framework Spring Boot como tecnología principal. Spring Boot facilita el desarrollo, prueba y despliegue de aplicaciones basadas en Spring, lo que lo convierte en una excelente opción para construir microservicios.

- Arquitectura Hexagonal: Se hizo uso de la arquitectura hexagonal dentro del microservicio de Cliente, esta se usó para mejorar la escalabilidad del proyecto, además para que exista una mejor organización
en cuanto a la lógica del negocio, la aplicación y lo que se conecta a la misma, así dando una flexibilidad y mejor escalabilidad a la hora de añadir elementos al microservicio.

DOCUMENTACION CON SWAGGER:

Para documentar las APIs REST de los microservicios, se utilizó la herramienta Swagger. Swagger genera documentación interactiva a partir de los comentarios en el código fuente, lo que elimina la necesidad de escribir documentación manualmente.
Se agregaron las dependencias necesarias de Swagger en cada proyecto de microservicio y se configuró mediante la anotación @EnableSwagger2. Luego, se documentaron las APIs utilizando anotaciones específicas de Swagger, como @Api, @ApiOperation y @ApiParam, para describir el propósito de los controladores, métodos y parámetros.
Una vez en ejecución, se pudo acceder a la interfaz de usuario de Swagger visitando la ruta /swagger-ui.html en cada microservicio, lo que permitió explorar y probar las APIs de manera interactiva.

SEGURIDAD:
 Se hizo uso del JWT para el tema de seguridad de la aplicación para el inicio de sesion del usuario, estp generalmente se usa para la autenticación y autorización en aplicaciones web y APIs, esto nos
 proporciona de manera compacta una manera segura de transmitir información entre partes como un objeto JSON.

REQUISITOS FUNCIONALES:

Un requisito funcional es una declaración de cómo debe comportarse un sistema. Define lo que el sistema debe hacer para satisfacer las necesidades o expectativas del usuario. Los requisitos funcionales se pueden considerar como características que el usuario detecta. Son diferentes de los requisitos no funcionales, que definen cómo debe funcionar internamente el sistema 
- Historias Épicas: https://docs.google.com/spreadsheets/u/0/d/1Zn9bsSx7eAeilC15REzf2Q9giALNRyLaxSAkej18kLw/edit
- Historias de Usuario: https://docs.google.com/spreadsheets/u/0/d/1oLz2MHG8f-P4wrxAKdQlHT7bh6MhzyOPtvrheS23mPQ/edit

REQUISITOS NO FUNCIONALES:
Rendimiento:
Escenario: Durante un evento de ventas especiales, como el Black Friday, se registra un pico de tráfico en el sitio web.
Estímulo: Aumento repentino en el número de usuarios y solicitudes de compra.
Respuesta: El sistema debe mantener tiempos de respuesta rápidos y estables, con una capacidad para manejar al menos el doble de la carga habitual sin degradación del rendimiento.
Seguridad:
Escenario: Un hacker intenta acceder a la base de datos del sistema para robar información de clientes.
Estímulo: Intento de acceso no autorizado a través de técnicas de piratería.
Respuesta: El sistema debe resistir intentos de intrusión mediante medidas como el cifrado de datos, la autenticación de dos factores y la detección de intrusiones. Debe registrar y notificar cualquier intento de acceso no autorizado para su análisis posterior.
Disponibilidad:
Escenario: Durante el horario comercial, un cliente intenta acceder al sitio web para realizar una compra.
Estímulo: Acceso al sitio web a través de un navegador web estándar.
Respuesta: El sitio web debe estar disponible y accesible las 24 horas del día, los 7 días de la semana, con un tiempo de inactividad planificado mínimo para mantenimiento programado. El tiempo de respuesta para cargar la página principal no debe exceder los 3 segundos en condiciones normales de tráfico.
Escalabilidad:
Escenario: Hyun Seda lanza una nueva línea de productos que genera un aumento en el tráfico del sitio web.
Estímulo: Incremento en el número de usuarios y solicitudes de compra.
Respuesta: El sistema debe poder escalar horizontalmente para manejar el aumento en la carga sin afectar el rendimiento. Se deben implementar tecnologías y prácticas que permitan agregar recursos adicionales según sea necesario.
Usabilidad:
Escenario: Un cliente navega por el sitio web en busca de un producto específico.
Estímulo: Interacción con la interfaz de usuario del sitio web.

Respuesta: La interfaz de usuario debe ser intuitiva y fácil de usar, con un diseño limpio y una navegación clara. Se deben minimizar los clics y los tiempos de carga para mejorar la experiencia del usuario.
Mantenibilidad
Escenario: Un desarrollador necesita corregir un error en el sistema.
Estímulo: Identificación de un problema durante pruebas de calidad o revisiones de código.
Respuesta: El código del sistema debe estar bien estructurado, documentado y modularizado para facilitar la identificación y corrección de errores. Se deben seguir prácticas de desarrollo ágil y utilizar herramientas de gestión de versiones para mantener un código limpio y organizado.
Compatibilidad:
Escenario: Un cliente intenta acceder al sitio web desde su dispositivo móvil.
Estímulo: Acceso al sitio web a través de un navegador móvil en un dispositivo Android.
Respuesta: El sitio web debe ser compatible con una amplia gama de dispositivos y navegadores, incluidos dispositivos móviles, tabletas y computadoras de escritorio. Debe ajustarse automáticamente al tamaño de pantalla y mantener una funcionalidad completa en todos los dispositivos compatibles.
Legal y normativo:
Escenario: Un cliente realiza una compra y proporciona información personal y financiera.
Estímulo: Ingreso de datos personales y de pago durante el proceso de compra.
- Respuesta: El sistema debe cumplir con todas las leyes y regulaciones aplicables en cuanto a privacidad de datos, protección del consumidor y seguridad de la información. Debe seguir estándares de seguridad de la industria y utilizar prácticas recomendadas para proteger la información del cliente y garantizar transacciones seguras.

Escalabilidad
Uno de los principales beneficios de adoptar una arquitectura de microservicios es la capacidad de escalar los diferentes componentes del sistema de forma independiente según las necesidades de carga. En el sistema de gestión de ventas en línea de Hyun Seda, se implementaron estrategias para permitir la escalabilidad horizontal y vertical de los microservicios.

Escalabilidad Horizontal
La escalabilidad horizontal implica agregar más instancias de un microservicio para manejar un mayor volumen de solicitudes. Esto se logró mediante el uso de Docker y Kubernetes:
Cada microservicio se empaqueta como una imagen de Docker, lo que facilitó su implementación como contenedores ligeros e independientes.
Kubernetes se utilizó para orquestar y gestionar los contenedores de los microservicios, permitiendo escalar horizontalmente cada microservicio de forma dinámica según la demanda.
Se configuraron reglas de escalado automático en Kubernetes, que monitorean métricas como el uso de CPU y memoria, y ajustaban automáticamente el número de réplicas de cada microservicio según fuera necesario.

Escalabilidad Vertical
Además de la escalabilidad horizontal, también se implementó la escalabilidad vertical, que implica aumentar los recursos (CPU, memoria, etc.) asignados a cada instancia de un microservicio.
Se utilizaron instancias de computación escalables en la nube, lo que permitió ajustar fácilmente los recursos asignados a cada microservicio según sus necesidades.
Se monitorea continuamente el rendimiento y la utilización de recursos de cada microservicio, y se ajustaron los recursos verticalmente cuando se detectaron cuellos de botella o saturación de recursos.


ARQUITECTURA DE SOFTWARE DECISIONES DE ARQUITECTURA: 

- Arquitectura de Microservicios: Además de la arquitectura en capas, el patrón Modelo-Vista-Controlador (MVC) y la arquitectura microkernel descritas anteriormente, el sistema de gestión de ventas en línea de Hyun Seda también adopta una arquitectura de microservicios. Esto permite una mayor modularidad, escalabilidad y flexibilidad en el desarrollo y mantenimiento del sistema.

El sistema se compone de los siguientes microservicios, cada uno enfocado en un dominio específico del negocio:
Microservicio Usuario: Encargado de la gestión de usuarios y roles. Contiene las entidades User y Role.
Microservicio Cliente: Maneja la información de los clientes, como nombre, apellido, dirección, etc. Contiene la entidad Client.
Microservicio Producto: Gestiona el catálogo de productos, incluyendo detalles como id, nombre, stock y categoría asociada. Contiene las entidades Product y Category.
Microservicio Pedido: Responsable del proceso de realización de pedidos. Contiene las entidades Order e Ítem, donde Ítem representa los productos individuales dentro de un pedido.

La adopción de una arquitectura de microservicios en el sistema de gestión de ventas en línea de Hyun Seda ofrece varios beneficios:
Modularidad: Cada microservicio se enfoca en una funcionalidad específica, lo que facilita el desarrollo, pruebas y mantenimiento de cada componente de forma independiente.
Escalabilidad: Los microservicios pueden escalarse de forma individual según las necesidades de carga, sin afectar a otros componentes del sistema.
Flexibilidad: Debido a su naturaleza desacoplada, los microservicios permiten la incorporación de nuevas tecnologías y la actualización de componentes individuales sin interrumpir el funcionamiento del sistema completo.
Resiliencia: Si un microservicio falla, el resto del sistema puede continuar funcionando, lo que mejora la tolerancia a fallos y la disponibilidad general del sistema.

- Spring Boot: Para la implementación de la arquitectura de microservicios en el sistema de gestión de ventas en línea de Hyun Seda, se utilizó el framework Spring Boot como tecnología principal. Spring Boot facilita el desarrollo, prueba y despliegue de aplicaciones basadas en Spring, lo que lo convierte en una excelente opción para construir microservicios.

- Arquitectura Hexagonal: Se hizo uso de la arquitectura hexagonal dentro del microservicio de Cliente, esta se usó para mejorar la escalabilidad del proyecto, además para que exista una mejor organización
en cuanto a la lógica del negocio, la aplicación y lo que se conecta a la misma, así dando una flexibilidad y mejor escalabilidad a la hora de añadir elementos al microservicio.

DOCUMENTACION CON SWAGGER:

Para documentar las APIs REST de los microservicios, se utilizó la herramienta Swagger. Swagger genera documentación interactiva a partir de los comentarios en el código fuente, lo que elimina la necesidad de escribir documentación manualmente.
Se agregaron las dependencias necesarias de Swagger en cada proyecto de microservicio y se configuró mediante la anotación @EnableSwagger2. Luego, se documentaron las APIs utilizando anotaciones específicas de Swagger, como @Api, @ApiOperation y @ApiParam, para describir el propósito de los controladores, métodos y parámetros.
Una vez en ejecución, se pudo acceder a la interfaz de usuario de Swagger visitando la ruta /swagger-ui.html en cada microservicio, lo que permitió explorar y probar las APIs de manera interactiva.

SEGURIDAD:
 Se hizo uso del JWT para el tema de seguridad de la aplicación para el inicio de sesion del usuario, estp generalmente se usa para la autenticación y autorización en aplicaciones web y APIs, esto nos
 proporciona de manera compacta una manera segura de transmitir información entre partes como un objeto JSON.

VIDEO DEMO DE LA APLICACIÓN:
https://drive.google.com/file/d/1v51bapFkBrp_OvZqDlXigPE2UU3suyCx/view?usp=sharing










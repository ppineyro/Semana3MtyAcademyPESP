Para esto tomé el proyecto de spring JPA que ya tenía hecho de la semana pasada y le cambié para que contara con todas las tecnologías relevantes.

1. HTTP Basic:
Desde un inicio estaba presente  HTTP basic en el proyecto, está la autenticación básica; todas las peticiones requieren traer consigo mismas las credenciales del usuario que están codificdas en el encabezado Authorization en el SecurityConfig.java

2. JWT:
Se tenía ya implementado el stateless flow, el cliente se autentica en un endpoint público `/api/auth/login` para conseguir un token que se debe incluir como token bearer en cualquier petición que siga para que sea válida y pueda consumir recursos protegidos.

3. OAuth2 Login:
Se configuró un cliente OAuth2 para el login delegado, usé GitHub como ejemplo pero si uno lo corre así regular no funciona, esto es porque en application.properties hay que especificar el client ID y client SECRET y obviamente es un riesgo de seguridad si yo me voy a mi GitHub y saco mis propias credenciales de OAuth2 para que se valide (sin mencionar que no le funcionaría a nadie más.)
Si alguien quiere correrlo pues tiene que modificar eso, pero la delegación funciona

La aplicación nunca ve la contraseña porque le delega esa parte a GitHub, si el usuario accede con éxito a los servidores de GitHub éste último envía un código de autorización temporal que mi backend nada más intercambia por u n token de acceso, en ningún momento el backend contiene la contraseña.
en el flujo de oauth2 en este proyecto el resource owner es el usuario que quiere acceder, el cliente es la aplicación en sí, y el auth server es GitHub porque se le relegó la responsabilidad de autenticar

También implementé lo de BCrypt, fue muy fácil nada más tuve que poner un Bean chiquito en SecurityConfig, lo único con esto es que para que funcione con la base de datos, las contraseñas en la base de datos tienen que estar ya encriptadas con BCrypt, lo hice en mi máquina y jaló perfecto pero con las inyecciones SQL que vienen en el proyecto probablemente vaya a tirar error.
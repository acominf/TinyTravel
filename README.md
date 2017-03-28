### Objetivo del juego/aplicación
El objetivo es llegar lo más lejos posible y obtener el mayor número de puntos que se pueda. 

### Descripción del juego/aplicación
El jugador célula recorrerá un húmedo, pegajoso y peligroso entorno dentro del cuerpo y sistemas de una criatura extraña, con el objeto de mantenerse viva dentro de la criatura, en su recorrido encontrara glóbulos blancos que le aportarán energía para seguir moviéndose, también pastillas o píldoras que incrementarán sus capacidades metabólicas permitiéndole absorber virus por un breve periodo de tiempo, encontrara virus que si llegasen a tocarla esta se morirá, a excepción de que esté potenciada con una pastilla, en este caso podría devorar al virus sin hacerse daño. La célula ganará puntos mientras su recorrido sea más y más largo a través de la criatura. Obtendrá  3 puntos por cada cierta distancia recorrida, si se come una pastilla ganará  2 y si devora a un virus obtendrá  5. 
Existen 2 tipos de virus potencialmente peligrosos, uno el virus H de aspecto pequeño, amarillento y adormecido, este disminuirá la vida de la célula, y está el virus T de aspecto grande, grotesco y agresivo que al menor contacto con la célula esta morirá inmediatamente. 

### Clases principales y sus características
1. Mundo
* Tiene los elementos del juego(Personajes, Potenciadores y elementos de entorno).

2. Elemento
* Posee atributos para las clases de Personaje y Potenciador(posicion y tamaño).
* Dibuja los personajes y potenciadores.

3. Personaje
* Super clase que engloba las clases Celula y Virus.
* Posee un metodo para moverse.
* Sobreescribe el método dibuja.

4. Célula
* Contiene un atributo de tipo Pastilla.
* Tiene un metodo para comer.
* Sobreescribe los métodos dibuja y moverse.

5. Virus
* Tiene un metodo para atacar.
* Sobreescribe los métodos dibuja y moverse.

6. VT
* Mortal para la celula.
* Sobreescribe el método atacar.

7. VH
* Decrementa vida a la celula.
* Sobreescribe el método atacar.

8. Potenciador
* Super clase que engloba a las clases Globulo y Pastilla.
* Sobreescribe el método dibuja. 

9. Globulo
* Elemento que incrementa la vida de la celula.
* Sobreescribe el método dibuja.

10. Pastilla
* Proporciona poderes a la celula.
* Posee el método poder.
* Sobreescribe el método dibuja.

11. Invencibilidad
* Permite que la célula sea inmune a los virus
* Sobreescribe el metodo poder.

12. Duplicidad
* Hace que los puntos obtenidos en el tiempo que este activo el poder valgan el doble.
* Sobreescribe el metodo poder.

13. Tamaño
* Hace que la célula modifique su tamaño.
* Sobreescribe el metodo poder.

14. Pared
* Super clase que engloba los tipos de paredes que pueden existir.

15. Lisa
* Tipo de pared donde la celula puede desplazarse con facilidad.
* Sobreeescribe el metodo dibuja.

16. Pegajosa
* Tipo de pared donde la celula puedetiene cierta dificultad de desplazarse.
* Sobreeescribe el metodo dibuja.

### Diagrama de clases
![Diagrama de clases](https://github.com/acominf/TinyTravel/blob/master/Imagenes/DiagramaClasesTinyTravel.png)

### Autor(es)
El autor(es) del proyecto son:
- Alvarez Ruiz Alejandro Esaú (@AlexMethod)
- Ibarra Cuevas Zazil Josefina (@zazilibarra)

 Materia(s)
- Programación Orientada a Objetos

####Semestre
- 2016-2017/II

### Markdown
El contenido de esta página está escrito en un lenguaje de marcado sencillo llamado *Markdown*. Para más detalles consulta la página de [Markdown para GitHub](https://guides.github.com/features/mastering-markdown/).

### Temas de Jekyll
El estilo y presentación de esta página utiliza el tema de Jekyll seleccionado en la configuración del repositorio. El nombre de este tema está almacenado en el archivo de configuración `_config.yml`. Para más información acerca de los temas de Jekyll soportados por GitHub [haz click en este enlace](https://pages.github.com/themes/).

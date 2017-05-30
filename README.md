### Objetivo del juego/aplicación
El objetivo es llegar lo más lejos posible y obtener el mayor número de puntos que se pueda tratando siempre de superar el ultimo puntaje mas alto. 

### Descripción del juego/aplicación
El jugador célula recorrerá un húmedo, pegajoso y peligroso entorno dentro del cuerpo y sistemas de una criatura extraña, con el objeto de mantenerse viva dentro de la criatura, en su recorrido encontrara glóbulos blancos que le aportarán energía para seguir moviéndose, también pastillas o píldoras que incrementarán sus capacidades metabólicas permitiéndole duplicar sus puntos, encontrará virus que si llegasen a tocarla esta se morirá. La célula ganará puntos mientras su recorrido sea más y más largo a través de la criatura. Obtendrá 10 puntos por cada globulo, si se come una pastilla ganará  20.
Existen 2 tipos de virus potencialmente peligrosos, uno el virus H de aspecto pequeño, rosado y adormecido, este disminuirá la vida de la célula, y está el virus T de aspecto grande, grotesco y agresivo que al menor contacto con la célula esta morirá inmediatamente. 

### Personajes

Jugador
![Jugador](https://raw.githubusercontent.com/acominf/TinyTravel/master/Imagenes/png1.png)

Virus H
![Virus H](https://raw.githubusercontent.com/acominf/TinyTravel/master/Imagenes/vir4.png)

Virus T
![Virus T](https://raw.githubusercontent.com/acominf/TinyTravel/master/Imagenes/VT.png)

Globulos
![Globulos](https://raw.githubusercontent.com/acominf/TinyTravel/master/Imagenes/Globulo.png)

Pastillas
![Pastillas](https://raw.githubusercontent.com/acominf/TinyTravel/master/Imagenes/18762418_1387050718055457_2124542227_n.png)

### Pantallas de Juego

![Menú](https://raw.githubusercontent.com/acominf/TinyTravel/master/Game/core/assets/menu.jpg)

![Ayuda](https://raw.githubusercontent.com/acominf/TinyTravel/master/Game/core/assets/Ayuda.jpg)

![Créditos](https://raw.githubusercontent.com/acominf/TinyTravel/master/Game/core/assets/Creditos.jpg)

![Puntuaciones](https://raw.githubusercontent.com/acominf/TinyTravel/master/Game/core/assets/Puntos.jpg)


### Clases principales y sus características

1. Tiny
* Es la clase principal.

2. Juego
* Contiene todos los elementos que se crean al comenzar a jugar dentro de la pantalla.

3. Jugador
* Contiene la infomacion de la puntuacion cuando se juega.

4. Elemento
* Posee atributos para las clases de Personaje y Potenciador.

5. Personaje
* Super clase que engloba las clases Celula y Virus.

6. Célula
* Es el icono del jugador

7. Virus
* Super clase que engloba las clases VH y VT.

8. VT
* Mortal para la celula.

9. VH
* Decrementa vida a la celula.

10. Potenciador
* Super clase que engloba a las clases Globulo y Pastilla.

11. Globulo
* Elemento que incrementa la vida de la celula.

12. Pastilla
* Proporciona poderes a la celula.

13. Invencibilidad
* Duplica los puntos de los globulos.

13. F1...F6
* Son los fragmentos de las imagenes de fondo.


### Diagrama de clases
![Diagrama de clases](https://raw.githubusercontent.com/acominf/TinyTravel/master/Imagenes/Tiny%20Travel%20Inside%20Beasts.png)

### Autor(es)
El autor(es) del proyecto son:
- Alvarez Ruiz Alejandro Esaú (@AlexMethod)
- Ibarra Cuevas Zazil Josefina (@zazilibarra)

 Materia(s)
- Programación Orientada a Objetos

### Semestre
- 2016-2017/II

### Markdown
El contenido de esta página está escrito en un lenguaje de marcado sencillo llamado *Markdown*. Para más detalles consulta la página de [Markdown para GitHub](https://guides.github.com/features/mastering-markdown/).

### Temas de Jekyll
El estilo y presentación de esta página utiliza el tema de Jekyll seleccionado en la configuración del repositorio. El nombre de este tema está almacenado en el archivo de configuración `_config.yml`. Para más información acerca de los temas de Jekyll soportados por GitHub [haz click en este enlace](https://pages.github.com/themes/).

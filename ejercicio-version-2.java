programaVideoClub
inicio
	//10 peliculas maximo, con sus datos: nombre, director, disponible (si/no)
	//10 filas y 3 columnas
    //agregue una fila para los datos del socio
	var string peliculas[10][4]
	var integer cantidadPeliculas=0

	//************************************************************************************************

	funcion principal()

		var integer opcion=0
		mostrar: "Menu"
		mostrar: "----"
		mostrar: "1. Alta"
		mostrar: "2. Listar todas"
		mostrar: "3. Buscar pelicula"
		mostrar: "4. Alquilar"
		mostrar: "5. Devolver"
        //nuevas opciones
        mostrar: "6. Alquiler por socio"
        mostrar: "7. Recaudacion semanal"
        mostrar: "S. salir"
		mostrar: "Ingrese opcion"
		ingresar: opcion

	       //verifico que se haya ingresado un n�mero entre 1 y 5
	       si opcion>0 y opcion<6 entonces
		       en caso de opcion
			       caso = 1
					      si altaPelicula()=verdadero entonces
							      mostrar: "Pelicula creada OK"
					      sino
							      mostrar: "No se pueden ingresar mas peliculas"
					      fin si
			       fin caso
			       caso = 2
					      listarPeliculas()
			       fin caso
			       caso = 3
					      //abajo llamo a una funcion y le mando como par�metro lo
					      //que devuelve la funcion "ingresarPelicula()"
					      buscarPelicula(ingresarPelicula())
			       fin caso
			       caso = 4
					      alquilarPelicula(ingresarPelicula())
			       fin caso
			       caso = 5
					      devolverPelicula(ingresarPelicula())
			       fin caso
                   //nuevos casos por nuevas opciones
                   caso = 6
                        buscarAlquileresDelSocio()
                    fin caso
                    caso = 7
                        calcularYMostrarRecaudacion()
                    fin caso
		       fin en caso de
               principal()
            sino si caso = "S" entonces
                mostrar: "cerrando..."
            sino 
            mostrar: "opcion incorrecta reintente"
            principal()   
	       fin si

	fin funcion

    funcion agregarSocio()
        var string socio 
        mostrar: "ingrese nuevo socio"
        ingresar: socio
        retornar: socio
    fin funcion

    funcion buscarAlquileresDelSocio()
        var string socioABuscar
        i = 1
        var integer cantidadAlquiladas = 0 
        socioABuscar = agregarSocio()

        mientras i <=  cantidadAlquiladas hacer
            si peliculas[i][4] = socioABuscar entonces
                mostrar: "alquilo" + peliculas [i][1]
                cantidadAlquiladas = cantidadAlquiladas + 1
            fin si
            i = i + 1
        fin mientras
        si cantidadAlquiladas = 0 entonces
            mostrar: "El socio no alquilo peliculas"
        sino
            mostrar: "el socio alquiló" + cantidadAlquiladas
        fin si
        fin funcion

    funcion calcularYMostrarRecaudacion()
        var float acumulado = 0 
        var float recauda [7]
        var integer i=1

        mostrar: "1: lunes, 2: martes, 3: miercoles, 4: jueves, 5: viernes, 6: sabado, 7: domingo"

        mientras i<8 hacer
            mostrar: "ingrese la recaudacion del dia"
            ingresar: recauda[i]
            acumulado = acumulado + recauda[i]
            i = i + 1
        fin mientras

        mostrar: "la recaudacion es " + acumulado
    fin funcion

	funcion listarPeliculas()
	       var integer i=1
	       //recorro la matriz usando una variable auxiliar "i", mientras i sea menor o igual a la
	       //cantidad de peliculas que hay en la matriz
	       mientras i <= cantidadPeliculas
			       mostrar: "Nombre: " + peliculas[i][1] + " - Director: " + peliculas[i][2] + " � Disponible?: " + peliculas[i][3]
			       i = i + 1
	       fin mientras

	fin funcion


	 //esta funcion recibe como parametro el nombre de la pelicula que quiero buscar
	funcion integer buscarPelicula(String peliculaParaBuscar)
	       var integer i=1
	       var boolean salgo=falso
	       var integer posicion=0
 
	       //recorro la matriz usando una variable auxiliar "i", mientras i sea menor o igual a la
	       //cantidad de peliculas que hay en la matriz y se cumpla la segunda condicion de 
	      //salida. A la primera de las dos que sea falsa, se interrumpe el ciclo

	       mientras i <= cantidadPeliculas Y salgo=falso

			//comparo el nombre a buscar que recibe la funcion contra el nombre de la posicion actual de la 
			//matriz�si coincide, se guarda la posicion de la matriz (fila) en la que se encuentra el nombre y lo 
			//devuelvela funcion. Tambien sefuerza la salida del ciclo "mientras" haciendo que no se cumpla
			// la segunda condicion

			si peliculaParaBuscar = peliculas[i][1] entonces
				salgo=verdadero
				posicion=i
			fin si
			i = i + 1
	       fin mientras�
	       retornar posicion
	 fin funcion


	funcion boolean altaPelicula()

	       //compruebo que la matriz no est� llena
	       si cantidadPeliculas = 10 entonces
			       retornar: falso
	       fin si

	       //incremento la cantidad de peliculas que hay en la matriz
	       cantidadPeliculas = cantidadPeliculas + 1

	       mostrar: "Ingrese nombre "
	       ingresar: peliculas[cantidadPeliculas][1]

	       mostrar: "Ingrese director "
	       ingresar: peliculas[cantidadPeliculas][2]

	       peliculas[cantidadPeliculas][3] = "si"

	       retornar: verdadero

	fin funcion


	 //esta funcion la uso para evitar repetir c�digo en los casos 3, 4 y 5
	funcion string ingresarPelicula()
	       var string nombrePelicula=""

	       mostrar: "Ingrese nombre pelicula "
	       ingresa: nombrePelicula�

	       retornar: nombrePelicula
	fin funcion


	funcion alquilarPelicula(String nombrePeliculaAAlquilar)

	       var integer peliculaAAlquilar=0

	       //busco la pel�cula a alquilar seg�n el par�metro que recibe la funci�n
	       peliculaAAlquilar = buscarPelicula(nombrePeliculaAAlquilar)

	       //a continuaci�n se hacen las siguientes validaciones:
	       //- si la funci�n "buscarPelicula" devolvi� "0" significa que la pel�cula no existe
	       //- si la funcion "buscarPelicula" encontr� una pel�cula, pero esta tiene la tercer 
	       //columna un "no",significa que ya est� alquilada ("no disponible")
	       //- si no ocurre nada de lo anterior, cambiamos el valor de la tercer columna por "no" 
		// y ya queda alquilada
	       si peliculaAAlquilar = 0 entonces
		       mostrar:"No se encontr� la pel�cula buscada"
	       sino
		       si peliculas[peliculaAAlquilar][3] = "no" entonces
			       mostrar:"La pel�cula ya se encuentra alquilada"
		       sino
			       peliculas[peliculaAAlquilar][3]="no"
		       fin sin
	       fin si

	fin  funcion


	funcion devolverPelicula(String nombrePeliculaADevolver)

	       var integer peliculaADevolver=0

	       //busco la pel�cula a alquilar seg�n el par�metro que recibe la funci�n
	       peliculaADevolver = buscarPelicula(nombrePeliculaADevolver)

	       //a continuaci�n se hacen las siguientes validaciones:
	       //- si la funci�n "buscarPelicula" devolvi� "0" significa que la pel�cula no existe
	       //- si la funcion "buscarPelicula" encontr� una pel�cula, pero esta tiene la tercer 
	       //columna un "si",significa que ya fue devuelta ("si disponible")
	       //- si no ocurre nada de lo anterior, cambiamos el valor de la tercer columna por "si" y 
		// ya queda disponibles
	       si peliculaADevolver = 0 entonces
		       mostrar:"No se encontr� la pel�cula buscada"
	       sino
		       si peliculas[peliculaADevolver][3] = "si" entonces
			       mostrar:"La pel�cula ya se encuentra disponible"
		       sino
			       peliculas[peliculaADevolver][3]="si"
		       fin sin
	       fin si

	fin funcion
fin�

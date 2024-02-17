programa Bibleoteca
inicio
    var string libros [10][4]
    var integer cantidadLibros

    funcion principal()
        var integer opcion = 0
        mostrar: "menu"
        mostrar: "----"
        mostrar: "1. Alta"
        mostrar: "2. Listar libros"
        mostrar: "3. Buscar libros"
        mostrar: "4. Alquilar libros"
        mostrar: "5. Devolver libros"
        mostrar: "6. Alquileres por socio"
        mostrar: "S. salir"
        ingresar: opcion
        
        si opcion >0 y opcion <8 entonces
            en caso de opcion
            caso = 1 
                si altaLibro() es verdadero entonces
                    mostrar: "Libro agregado"
                sino
                    mostrar: "No se pueden agregar más libros"
                fin si
            fin caso
            caso = 2 
                listarLibros()
            fin caso
            caso = 3
                buscarLibro(ingresarLibro())
            fin caso
            caso = 4
                alquilarLibro (ingresarLibro())
            fin caso
            caso = 5 
                devolverLibro(ingresarLibro())
            fin caso
            caso = 6 
                buscarAlquileresdelSocio()
            fin caso
        fin en caso de
        principal()
        si opcion = "s"
            mostrar: "saliendo"
        sino
            mostrar: "No es una opcion valida reintente"
        principal()
        fin si
    fin funcion

    funcion boolean altaLibro()
        si cantidadDeLibros = 10 entonces
           retornar: falso
        fin si

        cantidadDeLibros = cantidadDeLibros + 1

        mostrar: "ingrese libro"
        ingresar: libros[cantidadDeLibros][1]
        mostrar: "ingrese autor"
        ingresar: libros[cantidadDeLibros][2]
        libros[cantidadDeLibros][3] "si" 
        retornar: verdadero
    fin funcion
    
    funcion listarLibros()
        var integer i = 1
        
        mientras i <= cantidadDeLibros hacer
        mostrar: "Nombre" + libros[i][1] + "Autor" + libros[i][2] + "disponible?" + libros[i][3]
        i = i + 1
        fin mientras
    fin funcion

    funcion ingresarLibro()
        var string nombreDeLibro = ""
        mostrar: "Ingrese nombre de libro"
        ingresar: nombreDeLibro
        retornar: nombreDeLibro
    fin funcion

    funcion integer buscarLibro(string libroABuscar)
        var integer i = 1
        var boolean salgo = falso
        var integer posicion = 0

        mientras i <= cantidadDeLibros Y salgo=falso 
            si libroABuscar = libros[i][1] entonces
            salgo = verdadero
            posicion = i
            fin si
        i = i + 1
        fin mientras
        retornar: posicion
    fin funcion

    funcion alquilarLibro(string nombreDeLibro)
        var integer libroAAlquilar = 0

        libroAAlquilar = buscarLibro(nombreDeLibroAAlquilar)

        si libroAAlquilar = 0 entonces
            mostrar: "No se encontro el libro buscado"
        sino
            si libro[libroAAlquilar][3] = "No" entonces
                mostrar: "Libro no disponible"
            sino
                libro[libroAAlquilar][3] = "No"
            fin si
        fin si
    fin funcion

    funcion devolverLibro(string nombreDeLibroADevolver)
        var integer libroAAlquilar = 0

        libroADevolver = buscarLibro(nombreDeLibroADevolver)

        si libroAAlquilar = 0 entonces
            mostrar: "No se encontro el libro buscado"
        sino
            si libro[libroAAlquilar][3] = "si" entonces
                mostrar: "Libro ya esta disponible"
            sino
                libro[libroAAlquilar][3] = "si"
            fin si
        fin si
    fin funcion

    funcion string ingresarSocio()
        var string socio
        mostrar: "Ingrese nuevo socio"
        ingresar: socio
        retornar: socio
    fin funcion

    funcion buscarAlquileresDelSocio()
        var string socioABuscar
        var integer i = 1
        var integer cantidadAlquiladas = 0 

        socioABuscar = agregarSocio()

        mientras i <= cantidadAlquiladas hacer
            si libros[i][4] = socioABuscar entonces
                mostrar: "Alquilo estos libros" + libros[i][1]
            cantidadAlquiladas = cantidadAlquiladas + 1
        fin si
        i = i + 1

        si cantidadAlquiladas = 0 entonces
            mostrar: "El socio no tiene libros alquilados"
        sino
            mostrar: "alquilo" + cantidadAlquiladas
        fin si
    fin funcion
        
        



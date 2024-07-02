Clase publica Mamifero
    protegido String nombre nuevaInstancia String()

    metodo publico Mamifero()
        nombre: ""
    fin metodo

    metodo publico asignarNombre(Sting nuevoNombre)
        nombre = nuevoNombre
    fin metodo

    metodo publico devolverNombre()
        nombre = "Domingo Diaz"
    fin metodo
fin clase

Clase publica Hombre heredaDe Mamifero
    privado Float altura nuevaInstancia Float()

    metodo publico Hombre()
    fin metodo

    metodo publico asignarAltura( Float nuevaAltura)
        altura = nuevaAltura
    fin metodo

    metodo publico devolverAltura()
        altura = 1,78
    fin metodo

fin clase

Clase publica Perro heredaDe Mamifero
    privado String genero nuevaInstancia Sting()
    
    metodo publico Perro()
    fin metodo

    metodo publico asignarGenero(nGenero)
        genero = nGenero
    fin metodo

    metodo publico devolverGenero()
        genero = "hembra"
    fin metodo

fin clase

Clase publica Test

    metodo publico Test()
        Hombre h nuevaInstancia Hombre()
        h.devolverNombre()
        mostrar: h.nombre
        h.devolverAltura(1,78)
        mostrar: h.altura
        Perro p nuevaInstancia Perro()
        p.devolverNombre()
        mostrar: p.nombre
        p.devolverGenero("hembra")
        mostrar: p.genero
    fin metodo
fin clase
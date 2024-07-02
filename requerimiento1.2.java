Clase publica Auto 

    privado String patente nuevaInstancia String()
    privado Integer anio nuevaInstancia Integer()
    
    metodo publico Auto()
        patente = ""
        anio = 0
    fin metodo

    metodo publico setPatente(String nPatente)
        patente = nPatente
    fin metodo
    
    metodo publico setAnio(Integer nAnio)
        anio =  nAnio
    fin metodo

    metodo privado getPatente()
        retornar: patente
    fin metodo

    metodo privado getAnio()
        retornar: anio
    fin metodo

    metodo publico mostrarPatente()
        si patente != "" entonces
            mostrar: "la patente ingresada es" + getPatente()
        sino 
            mostrar: "usted no ingreso ninguna patente"
        fin si
    fin metodo

    metodo publico mostrarAnio()
        si anio != 0 entonces
            mostrar: "el año de fabricacion de su auto es" + getAnio()
        sino
            mostrar: "usted no ingreso ningun año"
        fin si
    fin metodo

fin clase

Clase publica AutoTest()
    metodo publico AutoTest()
    Auto a nuevaInstancia Auto()
    a.setPatente("LBZ 639")
    a.setAnio(2010)
    a.mostrarPatente()
    a.mostrarAnio()
fin clase

    
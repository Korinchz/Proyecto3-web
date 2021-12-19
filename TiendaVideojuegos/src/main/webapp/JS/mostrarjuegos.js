function cargar(){
    $.get("http://localhost/CRUD-1.0-SNAPSHOT/miApi/juego/juegos", (data, status) => {
        const juegos = data.juegos;
        let juegosString = "";
        for(i in juegos){
            const desarrollador = juegos[i].desarrollador;
            const fechaLanzamiento = juegos[i].fechaLanzamiento;
            const genero = juegos[i].genero;
            const modoJuego = juegos[i].modoJuego;
            const nombre = juegos[i].nombre;
            const plataforma = juegos[i].plataforma;
            const precio = juegos[i].precio;
            const idioma = juegos[i].idioma;
            const idJuego = juegos[i].idJuego;
            juegosString += 
           "ID: "+ idJuego+ "\n Nombre: "+nombre+"\n Desarrollado: "+ desarrollador + "\n Genero: " + genero+"\n Precio: "+ precio+"\n Modo Juego: "+modoJuego+"\n Fecha Lazanmiento: "+ fechaLanzamiento + "\n Plataforma: "+plataforma
                    + "\n Idioma: "+ idioma+"\n -------------------\n";
        }
        $("#resultado").val(juegosString);
    })
}



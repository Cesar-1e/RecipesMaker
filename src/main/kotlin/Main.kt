val recetas:List<String> = listOf<String>("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")
val recetasSeleccionadas:ArrayList<String> = ArrayList()
val mensajeErrorEntrada:String = "Porfavor seleccione la opción correcta"

fun main() {
    val menu = """:: Bienvenido a Recipe Maker ::
        |
        |Selecciona la opción deseada
        |1. Hacer una receta
        |2. Ver mis recetas
        |3. Salir
    """.trimMargin()
    var opcion: Int = 0;
    do{
        println(menu);
        opcion = readLine()!!?.toInt() ?: 0
        when(opcion){
            1 -> hacerReceta()
            2 -> mostrarReceta()
            3 -> println("\nHasta luego!!")
            else -> println(mensajeErrorEntrada)
        }
    }while(opcion != 3)
}

fun hacerReceta() {
    println()
    println()
    println()
    println(": Hacer una receta :");
    do{
        println("Porfavor seleccione las siguientes recetas")

        //Imprime la lista de recetas a seleccionar
        println("0. Regresar")
        for ((indice, receta) in recetas.withIndex()) {
            println("${indice.plus(1)}. $receta")
        }
        var seleccion:Int = readLine()!!?.toInt() ?: 0
        when(seleccion){
            0 -> println("Regresando...")
            in 1..recetas.size -> recetasSeleccionadas.add(recetas[seleccion.minus(1)]);
            else -> println(mensajeErrorEntrada)
        }
    }while (seleccion != 0)
}

fun mostrarReceta(){
    if(recetasSeleccionadas.size == 0){
        return;
    }
    println()
    println()
    println()
    println(": Mostrar recetas :")
    for (receta in recetasSeleccionadas){
        println(receta)
    }
    readLine()
}
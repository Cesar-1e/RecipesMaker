val recetas:List<String> = listOf<String>("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")
val recetasSeleccionadas:ArrayList<String> = ArrayList()
val mensajeErrorEntrada = {println("Porfavor seleccione la opción correcta")}

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
            1 -> makeRecipe()
            2 -> viewRecipe()
            3 -> println("\nHasta luego!!")
            else -> mensajeErrorEntrada()
        }
    }while(opcion != 3)
}

fun makeRecipe() {
    println()
    println()
    println()
    println(": Hacer una receta :");
    do{
        println("Selecciona por categoría el ingrediente que buscas")

        //Imprime la lista de recetas a seleccionar
        println("0. Regresar")
        for ((indice, receta) in recetas.withIndex()) {
            println("${indice.plus(1)}. $receta")
        }

        var seleccion:Int?
        do{
            var detener = false
            seleccion = readLine()!!?.toInt() ?: recetas.size
            when(seleccion){
                0 -> println("Regresando...")
                in 1..recetas.size -> recetasSeleccionadas.add(recetas[seleccion.minus(1)]);
                else ->{mensajeErrorEntrada()
                    detener = true}
            }
        }while (detener)
    }while (seleccion != 0)
}

fun viewRecipe(){
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
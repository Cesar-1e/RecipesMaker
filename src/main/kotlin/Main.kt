import model.Food
import model.Group
import model.Recipe

val groups: ArrayList<Group> = ArrayList()
val recipe:Recipe = Recipe()
val messageErrorInput = {println("Porfavor seleccione la opción correcta")}

fun main() {
    loadGroups()
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
            else -> messageErrorInput()
        }
    }while(opcion != 3)
}

fun makeRecipe() {
    var groupSelect: Group
    println()
    println()
    println()
    println(": Hacer una receta :");
    do{
        println("Selecciona por categoría el ingrediente que buscas")

        //Imprime la lista de recetas a seleccionar
        println("0. Regresar")
        for ((index, group) in groups.withIndex()) {
            println("${index.plus(1)}. ${group.name}")
        }

        var seleccion:Int?
        do{
            var detener = false
            seleccion = readLine()!!?.toInt() ?: groups.size
            when(seleccion){
                0 -> println("Regresando...")
                in 1..groups.size+1 -> {
                    groupSelect = Group(groups[seleccion-1].name)
                    makeFoods(groups[seleccion-1], groupSelect)
                }
                else ->{messageErrorInput()
                    detener = true}
            }
        }while (detener)
    }while (seleccion != 0)
}

fun makeFoods(group: Group, groupSelect: Group){
    do{
        println("0. Regresar")
        for((index, food) in group.getFoods().withIndex()){
            println("${index+1}. ${food.name}")
        }
        var seleccion: Int
        do{
            var detener = false
            seleccion = readLine()!!?.toInt() ?: group.getFoods().size+1
            when(seleccion){
                0 -> println("Regresando...")
                in 1..group.getFoods().size+1 -> {
                    var food = group.getFoods()[seleccion-1]
                    print("Cantidad: ")
                    food.quantity = readLine()!!?.toInt() ?: 1
                    groupSelect.addFood(food)
                }
                else ->{messageErrorInput()
                    detener = true}
            }
        }while (detener)
    }while (seleccion != 0)
    if(!recipe.existGroup(groupSelect.name)) recipe.addGroup(groupSelect) else recipe.addFood(groupSelect.name, groupSelect.getFoods())
}

fun viewRecipe(){
    if(recipe.getGroups().size == 0){
        return;
    }
    println()
    println()
    println()
    println(": Mostrar recetas :")
    println(recipe)
    readLine()
}

fun loadGroups(){
    var group:Group = Group("Frutas")
    group.addFood(Food("Fresa"))
    group.addFood(Food("Plátano"))
    group.addFood(Food("Uvas"))
    group.addFood(Food("Manzana"))
    group.addFood(Food("Naranja"))
    group.addFood(Food("Pera"))
    group.addFood(Food("Cereza"))
    groups.add(group)

    group = Group("Cereal")
    group.addFood(Food("Avena"))
    group.addFood(Food("Trigo"))
    group.addFood(Food("Arroz"))
    group.addFood(Food("Maiz"))
    groups.add(group)

    group = Group("Verduras")
    group.addFood(Food("Zanahoria"))
    group.addFood(Food("Cebolla"))
    group.addFood(Food("Espárrago"))
    group.addFood(Food("Espinaca"))
    groups.add(group)
}
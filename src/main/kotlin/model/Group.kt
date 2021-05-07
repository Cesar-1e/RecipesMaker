package model

class Group(var name: String) {
    private var foods: ArrayList<Food> = ArrayList()

    override fun toString(): String {
        var message:String = ": Grupo: $name\n"
        for ((index, food) in foods.withIndex()){
            message += "${index+1}. ${food.name} - cantidad: ${food.quantity}\n"
        }
        return message
    }

    fun addFood(food: Food){
        foods.add(food)
    }

    fun getFoods(): ArrayList<Food>{
        return foods
    }

    fun existFood(food: String): Boolean{
        var exist = false
        for(foodAux in foods){
            if(foodAux.name == food) exist = true
        }
        return exist
    }
}
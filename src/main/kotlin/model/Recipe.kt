package model

class Recipe {
    private val groups: ArrayList<Group> = ArrayList()

    override fun toString(): String {
        var message:String = ""
        for (group in groups){
            message += group.toString()
        }
        return message
    }

    fun addGroup(group: Group){
        if(!existGroup(group.name)) groups.add(group)
    }

    fun getGroups(): ArrayList<Group>{
        return groups
    }

    fun addFood(groupName: String, food: Food){
        var index = getIndex(groupName)
        if(index != -1){
            if(!groups[index].existFood(food.name)) groups[index].addFood(food)
        }
    }

    fun addFood(groupName: String, foods: ArrayList<Food>){
        var index = getIndex(groupName)
        if(index != -1){
            for (food in foods)
            this.addFood(groupName, food)
        }
    }

    fun existGroup(groupName: String): Boolean{
        var exist: Boolean = false
        for (group in groups){
            if(group.name == groupName){
                exist = true
                break;
            }
        }
        return exist
    }

    fun getIndex(groupName: String): Int{
        var indexAux = -1
        for ((index,group) in groups.withIndex()){
            if(group.name == groupName){
                indexAux = index
                break;
            }
        }
        return indexAux
    }
}
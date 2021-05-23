package curso_paradigma_funcional.model

class Person (val name: String, var age: Int?=null, var city: String?=null) {
    fun completo(): String {
        return "$name - $age - $city"
    }
}
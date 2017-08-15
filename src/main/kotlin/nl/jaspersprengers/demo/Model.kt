package nl.jaspersprengers.demo

/**
 * Ons fruitmodel. Merk op dat klassen in Kotlin standaard niet te subclassificeren zijn, tenzij met het keyword open.
 * Dit is dus het omgekeerde gedrag van Java's final keyword.
 */
open abstract class Fruit

open class Apple : Fruit()

open class Juice
open class AppleJuice : Juice()

/**
 * De in en out keywords maken covariance en contravariance mogelijk
 */
interface Juicer<in F : Fruit, out J : Juice> {
    fun squeeze(f: F): J
}

//Meer is er niet nodig om een class te initialiseren!
class Cat

/**
 * Een data class voegt verschillende standaard implementaties voor methodes als toString, equals en hashCode
 */
data class Customer(val name: String = "Bruce")

class Dollar(val cents: Int) {
    operator fun plus(cts: Int): Dollar = Dollar(cts + cents)
    operator fun plus(money: Dollar): Dollar = Dollar(cents + money.cents)
    override fun toString() = "$" + (cents.toFloat() / 100.0)
}


class Employee(val name: String, val salary: Int)

class Department(val name: String, var employees: List<Employee> = listOf()) {
    var manager: Employee? = null
        get() = if (field == null && !employees.isEmpty()) employees[0] else field
        set(value) {
            if (value == null) throw IllegalArgumentException("We need a real manager")
        }
}
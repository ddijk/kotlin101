package nl.jaspersprengers.demo

class Demo {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            propertiesAndConstructorsExample()
            fruitExample()
            nullabilityExample()
            operatorOverloadingExample()
        }

        fun propertiesAndConstructorsExample() { //return type van deze method is Unit (vgl. Java void)
            println("Properties and constructors")
            val it = Department(name = "IT") // employees niet verplicht, standaard lege lijst
            println(it.manager ?: "No boss!")
            it.employees = listOf(Employee("Moss", 4000), Employee("Roy", 3500))
            println(it.manager!!.name) // make sure you know what you're doing!!

            // dit compileert naar it.getManager().setEmployee(..)
            it.manager = Employee("Jenn", 5000)
            println(it.manager!!.name)

            fun printSalary(salary: Int, name: String) = "$name earns $salary per month"

            println(it.employees.map { it.name }.reduce { acc, s -> "$acc and  $s" })
            println(it.employees.maxBy { it.salary }?.name)

            it.employees.forEach { println(printSalary(it.salary, it.name)) }
        }


        fun nullabilityExample() {
            println("Nullability")
            fun findCustomer(id: Long): Customer? = Customer(id)
            fun getAllCustomers() = listOf(Customer(42))
            val customer: Customer = findCustomer(123) ?: throw IllegalArgumentException("No customer 123")
            val customerOrNone: Customer? = findCustomer(123)
            //customerOrNone.name //Compiler error, want winnerOrNone kan null zijn
            val nameorNull: String? = customerOrNone?.name // gebruik de elvis notatie
            val name: String = customerOrNone?.name ?: "No name"
            // == does structural equality (equals) and is null safe. No silly Joda syntax.
            val ladiesAndBruces = getAllCustomers().filter { it.name == "Bruce" || it.gender == Gender.F }

        }

        fun fruitExample() {
            println("The magic juicer")
            val appleInAppleJuiceOut: Juicer<Apple, AppleJuice>? = null // deze pers maakt van appels appelsap

            /**
             * Deze pers maakt van appels fruitsap: OK.
             * Als je de 'out' modifier verwijdert in de interface Juicer geeft dit een compiler error
             */
            val appleInFruitJuiceOut: Juicer<Apple, Juice>? = appleInAppleJuiceOut
            //val fruitInAppleJuiceOut: Juicer<Fruit, AppleJuice>? = appleInAppleJuiceOut //Deze pers maakt van fruit appelsap: FOUT. Verwijder het commentaar en je ziet de compiler error.

            val fruitInJuiceOut: Juicer<Fruit, Juice>? = null // deze pers maakt van elk soort fruit sap
            /**
             * deze pers maakt van appels appelsap.
             * Als je de 'in' modifier verwijdert in de interface Juicer geeft dit een compiler error
             */
            val applesInFruitJuiceOut: Juicer<Apple, Juice>? = fruitInJuiceOut
            //val applesInAppleJuiceOut: Juicer<Fruit, AppleJuice>? = fruitInJuiceOut // Compile fout: je mag er niet vanuit gaan
        }


        operator fun Int.plus(money: Dollar): Dollar = money.plus(this)

        fun operatorOverloadingExample() {
            println("Operator overloading")
            val p1 = Dollar(1200)
            val p2 = Dollar(800)
            println(p1 + p2 + 3)// invokes p1.plus(p2).plus(3)
            println(3 + p1 + p2)// invokes 3.plus(p1).plus(p2)
            val totalPrice = 300 + currentPrice() + orderTotal()
            println("total price = $totalPrice")
        }

        fun currentPrice() = Dollar(550)
        fun orderTotal() = 400

    }

}
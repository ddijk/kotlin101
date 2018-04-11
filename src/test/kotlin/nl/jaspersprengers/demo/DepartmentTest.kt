package nl.jaspersprengers.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DepartmentTest {

    @Test
    fun getManager() {
        val dept1 = Department("HR")

        println(dept1.manager?.name ?: "no boss");
        assertThat(dept1.manager).isSameAs(null)
    }

    @Test
    fun getManager2() {
        val dept1 = Department("HR", listOf(Employee()));

        assertThat(dept1.manager).isEqualTo(Employee())
    }

    @Test
    fun getManager3() {
        val dept1 = Department("HR", listOf(Employee()));

        val man1 = Employee(name = "joop")
        dept1.manager = man1

        assertThat(dept1.manager).isEqualTo(man1)
    }

    @Test
    fun testMap() {
        val dept1 = Department("HR", listOf(Employee(name = "dick", salary = 1000), Employee(name = "jens", salary = 99), Employee("Lieve", salary = 88))); assertThat("dick en jens en Lieve").isEqualTo(dept1.employees.map { i -> i.name }.reduce { acc, s -> "$acc en $s" })
    }

    fun printSalary(salary: Int, name: String) = "werknemer $name verdient $salary"


    @Test
    fun testTemplateString() {

        val dept1 = Department("HR", listOf(Employee(name = "dick", salary = 1000), Employee(name = "jens", salary = 99), Employee("Lieve", salary = 88)));

        val regels = dept1.employees.map { it -> printSalary(it.salary, it.name) }

        val expected = listOf("werknemer dick verdient 1000", "werknemer jens verdient 99", "werknemer Lieve verdient 88");
        assertThat(regels).isEqualTo(expected);
    }

    @Test

    fun testMaxBy() {

        val dept1 = Department("HR", listOf(Employee(name = "dick", salary = 1000), Employee(name = "jens", salary = 1001), Employee("Lieve", salary = 88)));

        val iter = dept1.employees.maxBy { it.salary }?.name
        println("iter is $iter")
    }
}
package nl.jaspersprengers.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmployeeTest {

    @Test
    fun getName() {
        val e1 = Employee("jaap");

        assertThat("jaap").isEqualTo(e1.name);
    }

    @Test
    fun getSalary() {

        val e1 = Employee(salary =  1000);

        assertThat(1000).isEqualTo(e1.salary);

    }
}
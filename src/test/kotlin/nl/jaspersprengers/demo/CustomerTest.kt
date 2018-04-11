package nl.jaspersprengers.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class CustomerTest {

    @Test
    fun getId() {
        val custA = Customer(3);
        val custB = Customer(3);

        assertThat(custA).isEqualTo(custB);

    }

    @Test
    fun getName() {
        val custA = Customer(3, "jaap");
        val custB = Customer(3,"jaap");

        assertThat(custA).isEqualTo(custB);
    }

    @Test
    fun getGender() {

        val custA = Customer(3, "jaap");

        val g = custA.gender ?: Gender.U;

        assertThat(g).isEqualTo(Gender.U);
    }

    @Test
    fun getGenderNull() {

        val custA = Customer(3, "jaap");

        val g = custA.gender;

        assertThat(g).isEqualTo(null);
    }
}
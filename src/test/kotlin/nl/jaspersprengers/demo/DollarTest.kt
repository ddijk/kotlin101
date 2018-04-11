package nl.jaspersprengers.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DollarTest {

    @Test
    fun plus() {

        val d1 = Dollar(5);
        val d2 = Dollar(10);


        assertThat(Dollar(15)).isEqualToComparingOnlyGivenFields( d1+d2, "cents");
    }

    @Test
    fun plus1() {
        assertThat(Dollar(5)).`as`("bla").isEqualToComparingOnlyGivenFields(Dollar(5),"cents");
    }

    @Test
    fun getCents() {
        val d1 = Dollar(5);

        assertThat(d1.cents).isEqualTo(5);
    }
}
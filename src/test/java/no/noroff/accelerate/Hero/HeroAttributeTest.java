package no.noroff.accelerate.Hero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroAttributeTest {

    @Test
    public void testIncrease(){
        Wizard wiz = new Wizard("Harry");

        HeroAttribute expected = new HeroAttribute(2,2,13);
        wiz.levelUp();

        assertEquals(expected.toString(), wiz.getLevelAttributes().toString());
    }

}
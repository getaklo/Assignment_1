package no.noroff.accelerate.ItemTests;

import no.noroff.accelerate.Hero.HeroAttribute;
import no.noroff.accelerate.Item.Armor.Armor;
import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmorTest {

    @Test
    void createArmor_validInputs_shouldHaveCorrectName(){
        Armor armor = new Armor("Simple chestplate",1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1,0,0));

        String expectedName = "Simple chestplate";

        assertEquals(expectedName, armor.getName());

    }
    @Test
    void createArmor_validInputs_shouldHaveCorrectType(){
        Armor armor = new Armor("Simple chestplate",1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1,0,0));

        ArmorType expectedType = ArmorType.PLATE;

        assertEquals(expectedType, armor.getType());

    }

    @Test
    void createArmor_validInputs_shouldHaveCorrectAttributes(){
        Armor armor = new Armor("Simple chestplate",1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1,0,0));

        HeroAttribute expected = new HeroAttribute(1,0,0);
        HeroAttribute actual = armor.getArmorAttribute();


        assertEquals(expected, actual);

    }
    @Test
    void createArmor_validInputs_shouldHaveCorrectReqLvl(){
        Armor armor = new Armor("Simple chestplate",3, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1,0,0));

        int expected = 3;

        int actual = armor.getRequiredLevel();


        assertEquals(expected, actual);

    }
    @Test
    void createArmor_validInputs_shouldHaveCorrectSlot(){
        Armor armor = new Armor("Simple chestplate",3, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1,0,0));

        Slot expected = Slot.BODY;

        Slot actual = armor.getSlot();


        assertEquals(expected, actual);

    }
}

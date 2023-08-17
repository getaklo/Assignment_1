package no.noroff.accelerate.HeroTests;

import no.noroff.accelerate.Exceptions.InvalidArmorException;
import no.noroff.accelerate.Hero.HeroAttribute;
import no.noroff.accelerate.Hero.Wizard;
import no.noroff.accelerate.Item.Armor.Armor;
import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroAttributeTest {

    @Test
    public void testIncrease_validInput_shouldAddTwoHeroAttributesTogether(){


        HeroAttribute attribute = new HeroAttribute(3, 3,3);
        HeroAttribute toBeAdded = new HeroAttribute(2,1,4);

        attribute.increase(toBeAdded);

        HeroAttribute expected = new HeroAttribute(5,4,7);

        HeroAttribute actual = attribute;
        assertEquals(expected,actual);
    }

    @Test
    void testTotalAttributes_noEquipment_shouldReturnTotalOfLevelAttributes(){

        // Arrange
        Wizard wizard = new Wizard("HarryP");
        HeroAttribute expected = new HeroAttribute(1,1,8);

        // Act
        HeroAttribute actual = wizard.getTotalAttributes();
        // Assert
        assertEquals(expected, actual);


    }
    @Test
    void totalAttributes_HelmetAndBodyEquipped_shouldReturnTotalAttributes() throws InvalidArmorException {
        Wizard wizard = new Wizard("HarryP");

        Armor helmet = new Armor("Helmet", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));
        Armor body = new Armor("Body", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(2,2,2));

        wizard.equipArmor(Slot.HEAD,helmet);
        wizard.equipArmor(Slot.BODY,body);

        HeroAttribute expected = new HeroAttribute(4,4,11);

        HeroAttribute actual = wizard.getTotalAttributes();

        assertEquals(expected, actual);
    }
    @Test
    void totalAttributes_HelmetEquipped_shouldReturnTotalAttributes() throws InvalidArmorException {
        Wizard wizard = new Wizard("HarryP");

        Armor helmet = new Armor("Helmet", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));


        wizard.equipArmor(Slot.HEAD,helmet);

        HeroAttribute expected = new HeroAttribute(2,2,9);

        HeroAttribute actual = wizard.getTotalAttributes();

        assertEquals(expected, actual);
    }
    @Test
    void totalAttributes_WithReplacedArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        // Arrange

        Wizard wizard = new Wizard("HarryP");
        Armor helmet = new Armor("Helmet", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));
        Armor betterHelmet = new Armor("betterHelmet", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(2,2,2));

        // Act

        wizard.equipArmor(Slot.HEAD,helmet);
        wizard.equipArmor(Slot.HEAD,betterHelmet);

        // Assert
        HeroAttribute expected = new HeroAttribute(3,3,10);
        HeroAttribute actual = wizard.getTotalAttributes();

        assertEquals(expected, actual);
    }

}
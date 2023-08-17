package no.noroff.accelerate.HeroTests.Subclasses;

import no.noroff.accelerate.Exceptions.InvalidArmorException;
import no.noroff.accelerate.Exceptions.InvalidWeaponException;
import no.noroff.accelerate.Hero.Barbarian;
import no.noroff.accelerate.Hero.HeroAttribute;
import no.noroff.accelerate.Item.Armor.Armor;
import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BarbarianTest {

    @Test
    void testCreateBarbarian_validInputs_shouldCreateNewArcherWithCorrectName(){
        Barbarian barb = new Barbarian("Bobby");

        String expectedName = "Bobby";

        assertEquals(expectedName, barb.getName());
    }
    @Test
    void testCreateBarbarian_validInputs_shouldCreateNewArcherWithCorrectLevel(){
        Barbarian barb = new Barbarian("Bobby");

        int expectedLevel = 1;

        assertEquals(expectedLevel, barb.getLevel());
    }
    @Test
    void testCreateBarbarian_validInputs_shouldCreateNewArcherWithCorrectStats(){
        Barbarian barb = new Barbarian("Bobby");

        HeroAttribute expectedStats = new HeroAttribute(5,2,1);

        assertEquals(expectedStats, barb.getLevelAttributes());
    }
    @Test
    void levelUpBarbarian_validInput_shouldIncreaseAttributesForAnArcher() {

        // Arrange
        Barbarian barb = new Barbarian("Bobby");

        // Act
        barb.levelUp();

        //Assert
        HeroAttribute expected = new HeroAttribute(8, 4, 2);
        HeroAttribute actual = barb.getLevelAttributes();

        assertEquals(expected, actual);

    }

    @Test
    void calculateDamageBarbarian_withoutWeapon_shouldReturnDamageAtLevelOneWithoutWeapon() {
        Barbarian barb = new Barbarian("Bobby");

        double expected = 1 * (1 + ((double) 5 / 100));

        double actual = barb.damage();

        assertEquals(expected, actual);

    }

    @Test
    void calculateDamageBarbarian_withAxe_shouldReturnDamageAtLevelOneWithoutWeapon() throws InvalidWeaponException {
        Barbarian barb = new Barbarian("Bobby");
        Weapon weapon = new Weapon("Big axe", 1, 10, WeaponType.HATCHET);


        barb.equipWeapon(weapon);

        double expected = 10 * (1 + ((double) 5 / 100));

        double actual = barb.damage();


        assertEquals(expected, actual);

    }

    @Test
    void calculateDamageBarbarian_withAxeAndArmor_shouldReturnDamageAtLevelOneWithArmorAndWeapon() throws InvalidWeaponException, InvalidArmorException {
        Barbarian barb = new Barbarian("Bobby");
        Armor armor = new Armor("BarbBody", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 1, 1));
        Weapon weapon = new Weapon("Big axe", 1, 10, WeaponType.HATCHET);


        barb.equipWeapon(weapon);
        barb.equipArmor(Slot.BODY, armor);

        double expectedStrength = 6;
        double expectedWeaponDamage = 10;
        double expected = expectedWeaponDamage * (1 + (expectedStrength / 100));


        double actual = barb.damage();


        assertEquals(expected, actual);

    }
    @Test
    void calculateDamageBarbarian_withReplacedHatchet_shouldReturnDamageAtLevelOneWithReplacedWeapon() throws InvalidWeaponException, InvalidArmorException {
        Barbarian barb = new Barbarian("Bobby");
        Weapon weapon = new Weapon("Big axe", 1, 5, WeaponType.HATCHET);
        Weapon newWeapon = new Weapon("Bigger axe", 1, 10, WeaponType.HATCHET);


        barb.equipWeapon(weapon);
        barb.equipWeapon(newWeapon);

        double expectedStrength = 5;
        double expectedWeaponDamage = 10;
        double expected = expectedWeaponDamage * (1 + (expectedStrength / 100));


        double actual = barb.damage();


        assertEquals(expected, actual);

    }


    @Test
    void equipArmor_invalidTypeofArmorForBarbarian_shouldThrowInvalidArmorException() {
        Barbarian barb = new Barbarian("Bobby");

        Armor armor = new Armor("Helmet", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));

        assertThrows(InvalidArmorException.class, () -> {barb.equipArmor(Slot.HEAD, armor);});

    }
    @Test
    void equipWeapon_wrongWeaponTypeforBarbarian_shouldThrowInvalidWeaponException() {
        Barbarian barb = new Barbarian("Bobby");
        Weapon weapon = new Weapon("Bow", 1, 1, WeaponType.BOW);

        assertThrows(InvalidWeaponException.class, () -> {barb.equipWeapon(weapon);});

    }

    @Test
    void totalAttributes_validInputWithNoEquippedItems_shouldReturnTotalAttributes() throws InvalidArmorException {
        Barbarian barb = new Barbarian("Bobby");

        HeroAttribute expected = new HeroAttribute(5,2,1);

        HeroAttribute actual = barb.getTotalAttributes();

        assertEquals(expected, actual);
    }

    @Test
    void totalAttributes_validInputWithOneArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        Barbarian barb = new Barbarian("Bobby");
        Armor body = new Armor("BarbBody", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1, 1, 1));

        barb.equipArmor(Slot.BODY, body);

        HeroAttribute expected = new HeroAttribute(6,3,2);

        HeroAttribute actual = barb.getTotalAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void totalAttributes_validInputWithTwoArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        Barbarian barb = new Barbarian("Bobby");
        Armor body = new Armor("BarbBody", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1, 1, 1));
        Armor legs = new Armor("BarbLegs", 1, Slot.LEGS, ArmorType.PLATE, new HeroAttribute(1, 1, 1));

        barb.equipArmor(Slot.BODY, body);
        barb.equipArmor(Slot.LEGS, legs);

        HeroAttribute expected = new HeroAttribute(7,4,3);

        HeroAttribute actual = barb.getTotalAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void totalAttributes_validInputWithReplacedArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        Barbarian barb = new Barbarian("Bobby");
        Armor body = new Armor("PlateBody", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1, 1, 1));
        Armor newBody = new Armor("PlateBody2", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(3, 3, 3));

        barb.equipArmor(Slot.BODY, body);
        barb.equipArmor(Slot.BODY, newBody);

        HeroAttribute expected = new HeroAttribute(8,5,4);

        HeroAttribute actual = barb.getTotalAttributes();
        assertEquals(expected, actual);
    }
}

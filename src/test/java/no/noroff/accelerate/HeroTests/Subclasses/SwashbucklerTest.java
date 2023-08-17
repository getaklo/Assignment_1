package no.noroff.accelerate.HeroTests.Subclasses;

import no.noroff.accelerate.Exceptions.InvalidArmorException;
import no.noroff.accelerate.Exceptions.InvalidWeaponException;
import no.noroff.accelerate.Hero.Barbarian;
import no.noroff.accelerate.Hero.HeroAttribute;
import no.noroff.accelerate.Hero.Swashbuckler;
import no.noroff.accelerate.Item.Armor.Armor;
import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SwashbucklerTest {

    @Test
    void testCreateSwashbuckler_validInputs_shouldCreateNewSwashbucklerWithCorrectName(){
        Swashbuckler swash = new Swashbuckler("Swashy");

        String expectedName = "Swashy";

        assertEquals(expectedName, swash.getName());
    }
    @Test
    void testCreateSwashbuckler_validInputs_shouldCreateNewSwashbucklerWithCorrectLevel(){
        Swashbuckler swash = new Swashbuckler("Swashy");

        int expectedLevel = 1;

        assertEquals(expectedLevel, swash.getLevel());
    }
    @Test
    void testCreateSwashbuckler_validInputs_shouldCreateNewSwashbucklerWithCorrectStats(){
        Swashbuckler swash = new Swashbuckler("Swashy");

        HeroAttribute expectedStats = new HeroAttribute(2,6,1);

        assertEquals(expectedStats, swash.getLevelAttributes());
    }
    @Test
    void levelUpSwashbuckler_validInput_shouldIncreaseAttributesForAnSwashbuckler() {

        // Arrange
        Swashbuckler swash = new Swashbuckler("Swashy");

        // Act
        swash.levelUp();

        //Assert
        HeroAttribute expected = new HeroAttribute(3, 10, 2);
        HeroAttribute actual = swash.getLevelAttributes();

        assertEquals(expected, actual);

    }

    @Test
    void calculateDamageSwashbuckler_withoutWeapon_shouldReturnDamageAtLevelOneWithoutWeapon() {
        Swashbuckler swash = new Swashbuckler("Swashy");

        double expected = 1 * (1 + ((double) 6 / 100));

        double actual = swash.damage();

        assertEquals(expected, actual);

    }

    @Test
    void calculateDamageSwashbuckler_withAxe_shouldReturnDamageAtLevelOneWithoutWeapon() throws InvalidWeaponException {
        Swashbuckler swash = new Swashbuckler("Swashy");
        Weapon weapon = new Weapon("Big dagger", 1, 10, WeaponType.DAGGER);


        swash.equipWeapon(weapon);

        double expected = 10 * (1 + ((double) 6 / 100));

        double actual = swash.damage();


        assertEquals(expected, actual);

    }

    @Test
    void calculateDamageSwashbuckler_withDaggerAndArmor_shouldReturnDamageAtLevelOneWithArmorAndWeapon() throws InvalidWeaponException, InvalidArmorException {
        Swashbuckler swash = new Swashbuckler("Swashy");
        Armor armor = new Armor("Body", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 1, 1));
        Weapon weapon = new Weapon("Big dagger", 1, 10, WeaponType.DAGGER);


        swash.equipWeapon(weapon);
        swash.equipArmor(Slot.BODY, armor);

        double expectedDexterity = 7;
        double expectedWeaponDamage = 10;
        double expected = expectedWeaponDamage * (1 + (expectedDexterity / 100));


        double actual = swash.damage();


        assertEquals(expected, actual);

    }
    @Test
    void calculateDamageSwashbuckler_withReplacedDagger_shouldReturnDamageAtLevelOneWithReplacedWeapon() throws InvalidWeaponException, InvalidArmorException {
        Swashbuckler swash = new Swashbuckler("Swashy");
        Weapon weapon = new Weapon("Big dagger", 1, 5, WeaponType.DAGGER);
        Weapon newWeapon = new Weapon("Bigger dagger", 1, 10, WeaponType.DAGGER);


        swash.equipWeapon(weapon);
        swash.equipWeapon(newWeapon);

        double expectedDexterity = 6;
        double expectedWeaponDamage = 10;
        double expected = expectedWeaponDamage * (1 + (expectedDexterity / 100));


        double actual = swash.damage();


        assertEquals(expected, actual);

    }


    @Test
    void equipArmor_invalidTypeofArmorForSwashbuckler_shouldThrowInvalidArmorException() {
        Swashbuckler swash = new Swashbuckler("Swashy");

        Armor armor = new Armor("Helmet", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));

        assertThrows(InvalidArmorException.class, () -> {swash.equipArmor(Slot.HEAD, armor);});

    }
    @Test
    void equipWeapon_wrongWeaponTypeforSwashbuckler_shouldThrowInvalidWeaponException() {
        Swashbuckler swash = new Swashbuckler("Swashy");
        Weapon weapon = new Weapon("Bow", 1, 1, WeaponType.BOW);

        assertThrows(InvalidWeaponException.class, () -> {swash.equipWeapon(weapon);});

    }

    @Test
    void totalAttributes_validInputWithNoEquippedItems_shouldReturnTotalAttributes() throws InvalidArmorException {
        Swashbuckler swash = new Swashbuckler("Swashy");

        HeroAttribute expected = new HeroAttribute(2,6,1);

        HeroAttribute actual = swash.getTotalAttributes();

        assertEquals(expected, actual);
    }

    @Test
    void totalAttributes_validInputWithOneArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        Swashbuckler swash = new Swashbuckler("Swashy");
        Armor armor = new Armor("Body", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 1, 1));

        swash.equipArmor(Slot.BODY, armor);

        HeroAttribute expected = new HeroAttribute(3,7,2);

        HeroAttribute actual = swash.getTotalAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void totalAttributes_validInputWithTwoArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        Swashbuckler swash = new Swashbuckler("Swashy");
        Armor body = new Armor("Body", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 1, 1));
        Armor legs = new Armor("Legs", 1, Slot.LEGS, ArmorType.MAIL, new HeroAttribute(1, 1, 1));

        swash.equipArmor(Slot.BODY, body);
        swash.equipArmor(Slot.LEGS, legs);

        HeroAttribute expected = new HeroAttribute(4,8,3);

        HeroAttribute actual = swash.getTotalAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void totalAttributes_validInputWithReplacedArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        Swashbuckler swash = new Swashbuckler("Swashy");
        Armor body = new Armor("PlateBody", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 1, 1));
        Armor newBody = new Armor("PlateBody2", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(3, 3, 3));

        swash.equipArmor(Slot.BODY, body);
        swash.equipArmor(Slot.BODY, newBody);

        HeroAttribute expected = new HeroAttribute(5,9,4);

        HeroAttribute actual = swash.getTotalAttributes();
        assertEquals(expected, actual);
    }
}

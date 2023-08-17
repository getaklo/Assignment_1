package no.noroff.accelerate.HeroTests.Subclasses;

import no.noroff.accelerate.Exceptions.InvalidArmorException;
import no.noroff.accelerate.Exceptions.InvalidWeaponException;
import no.noroff.accelerate.Hero.Archer;
import no.noroff.accelerate.Hero.Hero;
import no.noroff.accelerate.Hero.HeroAttribute;
import no.noroff.accelerate.Hero.Wizard;
import no.noroff.accelerate.Item.Armor.Armor;
import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArcherTest {

    @Test
    void testCreateArcher_validInputs_shouldCreateNewArcherWithCorrectName(){
        Archer archer = new Archer("Hawkeye");

        String expectedName = "Hawkeye";

        assertEquals(expectedName, archer.getName());
    }
    @Test
    void testCreateArcher_validInputs_shouldCreateNewArcherWithCorrectLevel(){
        Archer archer = new Archer("Hawkeye");

        int expectedLevel = 1;

        assertEquals(expectedLevel, archer.getLevel());
    }
    @Test
    void testCreateArcher_validInputs_shouldCreateNewArcherWithCorrectStats(){
        Archer archer = new Archer("Hawkeye");

        HeroAttribute expectedStats = new HeroAttribute(1,7,1);

        assertEquals(expectedStats, archer.getLevelAttributes());
    }
    @Test
    void levelUpArcher_validInput_shouldIncreaseAttributesForAnArcher() {

        // Arrange
        Archer archer = new Archer("Hawkeye");

        // Act
        archer.levelUp();

        //Assert
        HeroAttribute expected = new HeroAttribute(2, 12, 2);
        HeroAttribute actual = archer.getLevelAttributes();

        assertEquals(expected, actual);

    }

    @Test
    void calculateDamageArcher_withoutWeapon_shouldReturnDamageAtLevelOneWithoutWeapon() {
        Archer archer = new Archer("Hawkeye");

        double expected = 1 * (1 + ((double) 7 / 100));

        double actual = archer.damage();

        assertEquals(expected, actual);

    }

    @Test
    void calculateDamageArcher_withBow_shouldReturnDamageAtLevelOneWithoutWeapon() throws InvalidWeaponException {
        Archer archer = new Archer("Hawkeye");
        Weapon weapon = new Weapon("Big bow", 1, 10, WeaponType.BOW);


        archer.equipWeapon(weapon);

        double expected = 10 * (1 + ((double) 7 / 100));

        double actual = archer.damage();


        assertEquals(expected, actual);

    }

    @Test
    void calculateDamageArcher_withBowAndArmor_shouldReturnDamageAtLevelOneWithArmorAndWeapon() throws InvalidWeaponException, InvalidArmorException {
        Archer archer = new Archer("Hawkeye");
        Armor armor = new Armor("ArcherBody", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(1, 1, 1));
        Weapon weapon = new Weapon("Big bow", 1, 10, WeaponType.BOW);


        archer.equipWeapon(weapon);
        archer.equipArmor(Slot.BODY, armor);

        double expectedDexterity = 8;
        double expectedWeaponDamage = 10;
        double expected = expectedWeaponDamage * (1 + (expectedDexterity / 100));


        double actual = archer.damage();


        assertEquals(expected, actual);

    }
    @Test
    void calculateDamageArcher_withReplacedBow_shouldReturnDamageAtLevelOneWithReplacedWeapon() throws InvalidWeaponException, InvalidArmorException {
        Archer archer = new Archer("Hawkeye");
        Weapon weapon = new Weapon("Big bow", 1, 5, WeaponType.BOW);
        Weapon newWeapon = new Weapon("Bigger bow", 1, 10, WeaponType.BOW);


        archer.equipWeapon(weapon);
        archer.equipWeapon(newWeapon);

        double expectedDexterity = 7;
        double expectedWeaponDamage = 10;
        double expected = expectedWeaponDamage * (1 + (expectedDexterity / 100));


        double actual = archer.damage();


        assertEquals(expected, actual);

    }

    @Test
    void equipArmorTest_validInput_shouldIncreaseTotalAttributes() throws InvalidArmorException {
        Archer archer = new Archer("Hawkeye");
        Armor armor = new Armor("ArcherBody", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(1, 1, 1));

        archer.equipArmor(Slot.BODY, armor);

        HeroAttribute expected = new HeroAttribute(2,8,2);

        HeroAttribute actual = archer.getTotalAttributes();

        assertEquals(expected, actual);

    }

    @Test
    void equipArmor_invalidTypeofArmorForArcher_shouldThrowInvalidArmorException() {
        Archer archer = new Archer("Hawkeye");

        Armor armor = new Armor("Helmet", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(1,1,1));

        assertThrows(InvalidArmorException.class, () -> {archer.equipArmor(Slot.HEAD, armor);});

    }
    @Test
    void equipWeapon_wrongWeaponTypeforArcher_shouldThrowInvalidWeaponException() {
        Archer archer = new Archer("Hawkeye");
        Weapon weapon = new Weapon("Name", 1, 1, WeaponType.HATCHET);

        assertThrows(InvalidWeaponException.class, () -> {archer.equipWeapon(weapon);});

    }

    @Test
    void totalAttributes_validInputWithNoEquippedItems_shouldReturnTotalAttributes() throws InvalidArmorException {
        Archer archer = new Archer("Hawkeye");

        HeroAttribute expected = new HeroAttribute(1,7,1);

        HeroAttribute actual = archer.getTotalAttributes();

        assertEquals(expected, actual);
    }

    @Test
    void totalAttributes_validInputWithOneArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        Archer archer = new Archer("Hawkeye");
        Armor body = new Armor("ArcherBody", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(1, 1, 1));

        archer.equipArmor(Slot.BODY, body);

        HeroAttribute expected = new HeroAttribute(2,8,2);

        HeroAttribute actual = archer.getTotalAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void totalAttributes_validInputWithTwoArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        Archer archer = new Archer("Hawkeye");
        Armor body = new Armor("ArcherBody", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(1, 1, 1));
        Armor legs = new Armor("ArcherLegs", 1, Slot.LEGS, ArmorType.LEATHER, new HeroAttribute(1, 1, 1));

        archer.equipArmor(Slot.BODY, body);
        archer.equipArmor(Slot.LEGS, legs);

        HeroAttribute expected = new HeroAttribute(3,9,3);

        HeroAttribute actual = archer.getTotalAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void totalAttributes_validInputWithReplacedArmor_shouldReturnTotalAttributes() throws InvalidArmorException {
        Archer archer = new Archer("Hawkeye");
        Armor body = new Armor("ArcherBody", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(1, 1, 1));
        Armor newBody = new Armor("ArcherBody2", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(3, 3, 3));

        archer.equipArmor(Slot.BODY, body);
        archer.equipArmor(Slot.BODY, newBody);

        HeroAttribute expected = new HeroAttribute(4,10,4);

        HeroAttribute actual = archer.getTotalAttributes();
        assertEquals(expected, actual);
    }



}

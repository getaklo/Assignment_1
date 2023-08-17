package no.noroff.accelerate.HeroTests.Subclasses;

import no.noroff.accelerate.Exceptions.InvalidArmorException;
import no.noroff.accelerate.Exceptions.InvalidWeaponException;
import no.noroff.accelerate.Hero.HeroAttribute;
import no.noroff.accelerate.Hero.Wizard;
import no.noroff.accelerate.Item.Armor.Armor;
import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

    @Test
    void testDisplay_validInputs_shouldDisplayHeroNameClassLevelStrDexIntDamage(){
        Wizard wizard = new Wizard("Wizzy");

        String expected = "Name: Wizzy, Class: Wizard, Level: 1, Strength: 1, Dexterity: 1, Intelligence: 8, Damage: 1.08";

        String actual = wizard.display();

        assertEquals(expected, actual);

    }

    @Test
    void equipWeapon_wrongWeaponTypeforWizard_shouldThrowInvalidWeaponException() {
        Wizard w = new Wizard("Wizzy");
        Weapon weapon = new Weapon("Name", 1, 1, WeaponType.BOW);

        assertThrows(InvalidWeaponException.class, () -> {w.equipWeapon(weapon);});

    }

    @Test
    void equipWeapon_invalidLevelToEquipWeapon_shouldThrowInvalidWeaponException() {
        Wizard w = new Wizard("Wizz");
        Weapon weapon = new Weapon("Name", 2, 1, WeaponType.WAND);

        assertThrows(InvalidWeaponException.class, () -> {w.equipWeapon(weapon);});

    }


    @Test
    void equipArmor_invalidTypeofArmorForWizard_shouldThrowInvalidArmorException() {
        Wizard wizard = new Wizard("HarryP");

        Armor armor = new Armor("Helmet", 1, Slot.HEAD, ArmorType.MAIL, new HeroAttribute(1,1,1));

        assertThrows(InvalidArmorException.class, () -> {wizard.equipArmor(Slot.HEAD, armor);});



    }
    @Test
    void equipArmor_invalidLevelToEquipArmor_shouldThrowInvalidArmorException() {
        Wizard wizard = new Wizard("HarryP");

        Armor armor = new Armor("Helmet", 4, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,1));

        assertThrows(InvalidArmorException.class, () -> {wizard.equipArmor(Slot.HEAD, armor);});

    }
    @Test
    void totalAttributes_validInputWithNoEquippedItems_shouldReturnTotalAttributes() throws InvalidArmorException {
        Wizard wizard = new Wizard("HarryP");

        HeroAttribute expected = new HeroAttribute(1,1,8);

        HeroAttribute actual = wizard.getTotalAttributes();

        assertEquals(expected, actual);
    }


    @Test
    void calculateDamageWizard_withWeapon_shouldReturnDamageWithWeapon() throws InvalidWeaponException {
        Wizard wiz = new Wizard("HarryP");
        Weapon weapon = new Weapon("BasicWand",1,10,WeaponType.WAND);

        wiz.equipWeapon(weapon);

        double expected = 10 *(1 + ((double) 8 / 100));;

        double actual = wiz.damage();

        assertEquals(expected, actual);

    }
    @Test
    void calculateDamageWizard_withoutWeapon_shouldReturnDamageAtLevelOneWithoutWeapon() throws InvalidWeaponException {
        Wizard wiz = new Wizard("HarryP");

        double expected = 1 *(1 + ((double) 8 / 100));;

        double actual = wiz.damage();

        assertEquals(expected, actual);

    }

    @Test
    void levelUpWizard_validInput_shouldIncreaseLevelAttributes() {
        // Arrange
        Wizard wiz = new Wizard("HarryP");

        HeroAttribute expected = new HeroAttribute(2,2,13);

        wiz.levelUp();
        HeroAttribute actual = wiz.getLevelAttributes();

        assertEquals(expected,actual);

    }

    @Test
    void levelUpWizard_validInput_shouldLevelUpCharacter(){
        Wizard wiz = new Wizard("HarryP");

        wiz.levelUp();

        int expected = 2;
        int actual = wiz.getLevel();

        assertEquals(expected, actual);
    }
}
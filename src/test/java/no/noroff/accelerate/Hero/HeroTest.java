package no.noroff.accelerate.Hero;

import no.noroff.accelerate.Exceptions.InvalidArmorException;
import no.noroff.accelerate.Exceptions.InvalidWeaponException;
import no.noroff.accelerate.Item.Armor.Armor;
import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void equipWeapon_wrongWeaponTypeforHero_shouldThrowInvalidWeaponException() {
        Wizard w = new Wizard("W");
        Weapon weapon = new Weapon("Name", 1, 1, WeaponType.BOW);
       // w.equipWeapon(weapon);

        assertThrows(InvalidWeaponException.class, () -> {w.equipWeapon(weapon);});

    }

    @Test
    void equipWeapon_invalidLevelToEquipWeapon_shouldThrowInvalidWeaponException() {
        Wizard w = new Wizard("Wizz");
        Weapon weapon = new Weapon("Name", 2, 1, WeaponType.WAND);
        // w.equipWeapon(weapon);

        assertThrows(InvalidWeaponException.class, () -> {w.equipWeapon(weapon);});

    }


    @Test
    void equipArmor_invalidTypeofArmor_shouldThrowInvalidArmorException() {
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
}
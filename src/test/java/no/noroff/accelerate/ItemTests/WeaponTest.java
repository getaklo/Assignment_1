package no.noroff.accelerate.ItemTests;

import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponTest {
    @Test
    void testCreateWeapon_validInput_shouldHaveCorrectName(){
        Weapon weapon = new Weapon("BasicWand",1,10, WeaponType.WAND);

        String expected = "BasicWand";

        String actual = weapon.getName();

        assertEquals(expected,actual);

    }

    @Test
    void testCreateWeapon_validInput_shouldHaveCorrectRequiredLvl(){
        Weapon weapon = new Weapon("BasicWand",1,10, WeaponType.WAND);

        int expected = 1;

        int actual = weapon.getRequiredLevel();

        assertEquals(expected,actual);

    }

    @Test
    void testCreateWeapon_validInput_shouldHaveCorrectSlot(){
        Weapon weapon = new Weapon("BasicWand",1,10, WeaponType.WAND);

        Slot expected = Slot.WEAPON;

        Slot actual = weapon.getSlot();

        assertEquals(expected,actual);

    }
    @Test
    void testCreateWeapon_validInput_shouldHaveCorrectWeaponType(){
        Weapon weapon = new Weapon("BasicWand",1,10, WeaponType.WAND);

        WeaponType expected = WeaponType.WAND;

        WeaponType actual = weapon.getWeaponType();

        assertEquals(expected,actual);

    }

    @Test
    void testCreateWeapon_validInput_shouldHaveCorrectDamage(){
        Weapon weapon = new Weapon("BasicWand",1,10, WeaponType.WAND);

        int expected = 10;

        int actual = weapon.getDamage();

        assertEquals(expected,actual);

    }
}

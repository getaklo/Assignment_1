package no.noroff.accelerate.Hero;

import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Item;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;

import java.util.HashMap;
import java.util.Map;

public class Wizard extends Hero {
    public Wizard(String name) {
        super(name);
        LevelAttributes = new HeroAttribute(1, 1, 8);
        validArmorTypes.add(ArmorType.CLOTH);
        validWeaponTypes.add(WeaponType.STAFF);
        validWeaponTypes.add(WeaponType.WAND);
    }

    /**
     * Method to level up Wizard by increasing levelattributes.
     */
    @Override
    public void levelUp() {
        this.level++;
        LevelAttributes.increase(new HeroAttribute(1, 1, 5));

    }

    @Override
    public double damage() {
        double damage = 1;
        Weapon weapon = (Weapon) equipment.get(Slot.WEAPON);

        HeroAttribute attribute = this.getTotalAttributes();
        int damagingAttribute = attribute.getIntelligence();

        if (weapon != null) {
            damage = weapon.getDamage();
        }

        damage *= (1 + ((double) damagingAttribute / 100));
        return damage;
    }
}

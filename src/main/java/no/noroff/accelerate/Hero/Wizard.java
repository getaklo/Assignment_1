package no.noroff.accelerate.Hero;

import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Weapon.WeaponType;

import java.util.HashMap;

public class Wizard extends Hero{
    public Wizard(String name) {
        super(name);
        LevelAttributes = new HeroAttribute(1,1,8);
        validArmorTypes.add(ArmorType.CLOTH);
        validWeaponTypes.add(WeaponType.STAFF);
        validWeaponTypes.add(WeaponType.WAND);
    }

    @Override
    public void levelUp() {
        this.level++;
        LevelAttributes.increase(new HeroAttribute(1,1,5));
       //TODO

    }
    //TODO
}

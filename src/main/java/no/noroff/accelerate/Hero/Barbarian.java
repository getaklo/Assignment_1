package no.noroff.accelerate.Hero;

import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Weapon.WeaponType;

public class Barbarian extends Hero{
    public Barbarian(String name) {
        super(name);
        LevelAttributes = new HeroAttribute(5,2,1);
        validArmorTypes.add(ArmorType.PLATE);
        validArmorTypes.add(ArmorType.MAIL);
        validWeaponTypes.add(WeaponType.MACE);
        validWeaponTypes.add(WeaponType.HATCHET);
        validWeaponTypes.add(WeaponType.SWORD);

    }

    @Override
    public void levelUp() {
    this.level++;
    LevelAttributes.increase(new HeroAttribute(3,2,1));
    }
    //TODO
}

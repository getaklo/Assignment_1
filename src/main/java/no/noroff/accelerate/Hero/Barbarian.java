package no.noroff.accelerate.Hero;

import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;

public class Barbarian extends Hero {
    public Barbarian(String name) {
        super(name);
        LevelAttributes = new HeroAttribute(5, 2, 1);
        validArmorTypes.add(ArmorType.PLATE);
        validArmorTypes.add(ArmorType.MAIL);
        validWeaponTypes.add(WeaponType.MACE);
        validWeaponTypes.add(WeaponType.HATCHET);
        validWeaponTypes.add(WeaponType.SWORD);

    }

    @Override
    public void levelUp() {
        this.level++;
        LevelAttributes.increase(new HeroAttribute(3, 2, 1));
    }

    @Override
    public double damage() {
        double damage = 1;
        Weapon weapon = (Weapon) equipment.get(Slot.WEAPON);

        HeroAttribute attribute = this.getTotalAttributes();
        int damagingAttribute = attribute.getStrength();

        if (weapon != null) {
            damage = weapon.getDamage();
        }

        damage *= (1 + ((double) damagingAttribute / 100));
        return damage;
    }
    //TODO
}

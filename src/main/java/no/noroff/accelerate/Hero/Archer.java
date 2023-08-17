package no.noroff.accelerate.Hero;

import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;

public class Archer extends Hero{

    public Archer(String name) {
        super(name);
        LevelAttributes=new HeroAttribute(1,7,1);
        validArmorTypes.add(ArmorType.LEATHER);
        validWeaponTypes.add(WeaponType.BOW);

    }


    @Override
    public void levelUp() {
        this.level++;
        LevelAttributes.increase(new HeroAttribute(1,5,1));

    }

    @Override
    public double damage() {
        double damage = 1;
        Weapon weapon = (Weapon) equipment.get(Slot.WEAPON);

        HeroAttribute attribute = this.getTotalAttributes();
        int damagingAttribute = attribute.getDexterity();

        if (weapon != null) {
            damage = weapon.getDamage();
        }

        damage *= (1 + ((double) damagingAttribute / 100));
        return damage;
    }

}

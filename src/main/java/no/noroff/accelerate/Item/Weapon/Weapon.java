package no.noroff.accelerate.Item.Weapon;

import no.noroff.accelerate.Item.Item;
import no.noroff.accelerate.Item.Slot;

public class Weapon extends Item {
    protected int damage;
    protected WeaponType type;

    public Weapon(String name, int requiredLevel, int damage, WeaponType type) {
        super(name, requiredLevel);
        this.damage = damage;
        this.type = type;
        this.slot = Slot.WEAPON;
    }

    public WeaponType getWeaponType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }
}

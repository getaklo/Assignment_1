package no.noroff.accelerate.Item.Weapon;

import no.noroff.accelerate.Item.Item;
import no.noroff.accelerate.Item.Slot;

public class Weapon extends Item {
    protected int damage;
    protected WeaponType type;

    public Weapon(String name, int requiredLevel, Slot slot, int damage, WeaponType type) {
        super(name, requiredLevel, slot =Slot.WEAPON);
        this.damage = damage;
        this.type = type;
    }
}

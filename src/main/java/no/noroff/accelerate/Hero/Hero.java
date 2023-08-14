package no.noroff.accelerate.Hero;

import no.noroff.accelerate.Exceptions.InvalidArmorException;
import no.noroff.accelerate.Exceptions.InvalidWeaponException;
import no.noroff.accelerate.Item.Armor.Armor;
import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Item;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.Weapon;
import no.noroff.accelerate.Item.Weapon.WeaponType;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Hero {

    protected String name;
    protected int level;
    protected HeroAttribute LevelAttributes;
    protected ArrayList<WeaponType> validWeaponTypes;
    protected ArrayList<ArmorType> validArmorTypes;
    protected HashMap<Slot, Item> equipment;

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.validArmorTypes = new ArrayList<>();
        this.validWeaponTypes = new ArrayList<>();
        this.equipment = new HashMap<Slot, Item>();
        this.equipment.put(Slot.HEAD, null);
        this.equipment.put(Slot.BODY, null);
        this.equipment.put(Slot.LEGS, null);
        this.equipment.put(Slot.WEAPON, null);
    }

    public int getLevel() {
        return level;
    }

    public abstract void levelUp();


    public void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if(this.level >= weapon.getRequiredLevel() && this.validWeaponTypes.contains(weapon.getWeaponType()))
            equipment.put(Slot.WEAPON, weapon);
        else throw new InvalidWeaponException("Invalid weapon!");
    }

    public void equipArmor(Slot slot, Armor armor) throws InvalidArmorException {
        if(this.level >= armor.getRequiredLevel() && this.validArmorTypes.contains(armor.getType()))
            equipment.put(slot, armor);
        else throw new InvalidArmorException("Invalid armor!");
    }

    public void display() {
        //TODO
    }

    public HeroAttribute getLevelAttributes() {
        return LevelAttributes;
    }

}

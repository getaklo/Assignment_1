package no.noroff.accelerate.Hero;

import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Item;
import no.noroff.accelerate.Item.Slot;
import no.noroff.accelerate.Item.Weapon.WeaponType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    }

    public int getLevel() {
        return level;
    }

    public abstract void levelUp();

    public void equipWeapon(Item item) {
        equipment.put(Slot.WEAPON, item);
    }

    public void equipArmor(Slot slot, Item item) {
        equipment.put(slot, item);
    }

    public void display() {
        //TODO
    }

    public HeroAttribute getLevelAttributes() {
        return LevelAttributes;
    }

    public ArrayList<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }

    public ArrayList<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }

    public HashMap<Slot, Item> getEquipment() {
        return equipment;
    }
}

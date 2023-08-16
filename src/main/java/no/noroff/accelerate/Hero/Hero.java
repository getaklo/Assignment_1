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
import java.util.Map;

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

    /**
     * Method for leveling up a hero
     */
    public abstract void levelUp();


    /**
     * Method to equip weapon
     *
     * @param weapon
     * @throws InvalidWeaponException
     */
    public void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if (this.level >= weapon.getRequiredLevel() && this.validWeaponTypes.contains(weapon.getWeaponType()))
            equipment.put(Slot.WEAPON, weapon);
        else throw new InvalidWeaponException("Invalid weapon!");
    }

    /**
     * Method to equip armor in specified slot
     *
     * @param slot
     * @param armor
     * @throws InvalidArmorException
     */
    public void equipArmor(Slot slot, Armor armor) throws InvalidArmorException {
        if (this.level >= armor.getRequiredLevel() && this.validArmorTypes.contains(armor.getType()))
            equipment.put(slot, armor);
        else throw new InvalidArmorException("Invalid armor!");
    }

    public String display() {
        //TODO
        StringBuilder builder = new StringBuilder();
        builder.append("Name: "+this.name + " ");
        builder.append("Class: "+this.getClass()+ " ");
        builder.append("Strength: "+this.getTotalAttributes().getStrength()+ " ");
        builder.append(("Dexterity: "+this.getTotalAttributes().getDexterity())+ " ");
        builder.append("Intelligence: "+this.getTotalAttributes().getIntelligence()+ " ");
        builder.append("Damage: "+this.damage());

        return builder.toString();

    }

    public HeroAttribute getLevelAttributes() {
        return LevelAttributes;
    }

    public abstract double damage();


    public HeroAttribute getTotalAttributes() {
        HeroAttribute total = this.LevelAttributes;

        for (Map.Entry<Slot, Item> set : equipment.entrySet()) {
            if (set.getKey() != Slot.WEAPON && set.getValue() != null) {
                Armor armor = (Armor) set.getValue();
                total.increase(armor.getArmorAttribute());
            }
        }

        return total;
    }



}

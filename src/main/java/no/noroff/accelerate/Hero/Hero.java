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

    public String getName() {
        return name;
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

    /**
     * Method to display the stats of a character.
     *
     * @return String with characters stats.
     */
    public String display() {
        //TODO
        StringBuilder builder = new StringBuilder();
        builder.append("Name: " + this.name + ", ");
        builder.append("Class: " + this.getClass().getSimpleName() + ", ");
        builder.append("Level: " + this.getLevel() + ", ");
        builder.append("Strength: " + this.getTotalAttributes().getStrength() + ", ");
        builder.append("Dexterity: " + this.getTotalAttributes().getDexterity() + ", ");
        builder.append("Intelligence: " + this.getTotalAttributes().getIntelligence() + ", ");
        builder.append("Damage: " + this.damage());

        return builder.toString();

    }

    public HeroAttribute getLevelAttributes() {
        return LevelAttributes;
    }

    /**
     * Method to calculate damage.
     *
     * @return Damage as a double
     */
    public abstract double damage();


    /**
     * Method to calculate a heros total stats, including stats from armor.
     *
     * @return HeroAttribute object with total stats.
     */
    public HeroAttribute getTotalAttributes() {

        //Make empty attribute object
        HeroAttribute total = new HeroAttribute(0, 0, 0);
        // Increase by level attributes
        total.increase(this.getLevelAttributes());

        // Increase total for each piece of armor
        for (Map.Entry<Slot, Item> set : equipment.entrySet()) {
            if (set.getKey() != Slot.WEAPON && set.getValue() != null) {
                Armor armor = (Armor) set.getValue();
                total.increase(armor.getArmorAttribute());
            }
        }

        return total;
    }


}

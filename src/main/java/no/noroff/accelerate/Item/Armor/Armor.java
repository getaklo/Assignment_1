package no.noroff.accelerate.Item.Armor;

import no.noroff.accelerate.Hero.HeroAttribute;
import no.noroff.accelerate.Item.Item;
import no.noroff.accelerate.Item.Slot;

public class Armor extends Item {

    protected ArmorType type;

    protected HeroAttribute armorAttribute;

    public Armor(String name, int requiredLevel, Slot slot, ArmorType type, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.armorAttribute = armorAttribute;
    }
}

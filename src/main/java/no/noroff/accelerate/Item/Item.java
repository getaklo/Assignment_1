package no.noroff.accelerate.Item;

public abstract class Item {

    protected String name;
    protected int requiredLevel;
    protected Slot slot;

    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    public Item(String name, int requiredLevel) {
        this.name = name;
        this.requiredLevel= requiredLevel;
    }
    public Item() {

    }
    public int getRequiredLevel() {
        return requiredLevel;
    }


    //todo
}

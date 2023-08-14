package no.noroff.accelerate.Hero;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void increase(HeroAttribute att){
      this.strength += att.strength;
      this.dexterity += att.dexterity;
      this.intelligence += att.intelligence;
    }

    public HeroAttribute inc(HeroAttribute att){
        int newStrength = this.strength += att.strength;
        int newDex = this.dexterity += att.dexterity;
        int newInt = this.intelligence += att.intelligence;

        return new HeroAttribute(newStrength, newDex, newInt);
    }

    @Override
    public String toString() {
        return "HeroAttribute{" +
                "strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                '}';
    }
}

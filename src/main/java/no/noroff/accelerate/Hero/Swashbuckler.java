package no.noroff.accelerate.Hero;

import no.noroff.accelerate.Item.Weapon.WeaponType;

public class Swashbuckler extends Hero{
    public Swashbuckler(String name) {
        super(name);
        LevelAttributes = new HeroAttribute(2,6,1);
        validWeaponTypes.add(WeaponType.DAGGER);
        validWeaponTypes.add(WeaponType.SWORD);
    }

    @Override
    public void levelUp() {
        this.level++;
        LevelAttributes.increase(new HeroAttribute(1,4,1));

    }
    //TODO
}

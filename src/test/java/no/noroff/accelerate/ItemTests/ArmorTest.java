package no.noroff.accelerate.ItemTests;

import no.noroff.accelerate.Hero.HeroAttribute;
import no.noroff.accelerate.Item.Armor.Armor;
import no.noroff.accelerate.Item.Armor.ArmorType;
import no.noroff.accelerate.Item.Slot;
import org.junit.jupiter.api.Test;

public class ArmorTest {

    @Test
    void createArmor_validInputs_shouldHaveCorrectName_ReqLvl_Slot_ArmorType_ArmorAttributes(){
        Armor armor = new Armor("Simple chestplate",1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1,0,0));


    }
}

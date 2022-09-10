package TheTerrarianMod.powers;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import basemod.interfaces.CloneablePowerInterface;

public class PlatinumPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("Platinum");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public PlatinumPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
    
    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new PlatinumPower(owner, amount);
    }
}

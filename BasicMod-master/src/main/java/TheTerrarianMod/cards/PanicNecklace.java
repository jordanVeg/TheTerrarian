package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.modifiers.CrimsonModifier;
import TheTerrarianMod.util.CardInfo;
import basemod.helpers.CardModifierManager;

public class PanicNecklace extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "PanicNecklace",
            1, 
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int BLOCK = 6;
    private static final int UPG_BLOCK = 1;


    
    public PanicNecklace() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        CardModifierManager.addModifier(this, new CrimsonModifier());
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToBot(new ApplyPowerAction(p, p, new NextTurnBlockPower(p, block-2), block-2));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new PanicNecklace();
    }
    
}

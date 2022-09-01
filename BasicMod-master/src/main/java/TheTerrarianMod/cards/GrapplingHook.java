package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class GrapplingHook extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "GrapplingHook",
            0, 
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int BLOCK = 4;
    private static final int UPG_BLOCK = 3;

    
    public GrapplingHook() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GrapplingHook();
    }
    
}

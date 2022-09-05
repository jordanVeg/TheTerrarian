package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.powers.SharpenedPower;
import TheTerrarianMod.util.CardInfo;

public class SharpeningStation extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "SharpeningStation",
            1, 
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int BLOCK = 6;
    private static final int UPG_BLOCK = 4;
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    
    public SharpeningStation() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC, UPG_MAGIC);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new SharpenedPower(p, magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SharpeningStation();
    }
    
}

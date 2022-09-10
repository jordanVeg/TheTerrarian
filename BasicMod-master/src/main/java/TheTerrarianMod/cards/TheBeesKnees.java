package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class TheBeesKnees extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "TheBeesKnees",
            1, 
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 1;

    
    public TheBeesKnees() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        this.cardsToPreview = new Bee();
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInHandAction(new Bee(), magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new TheBeesKnees();
    }
    
}

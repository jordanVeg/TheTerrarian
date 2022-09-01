package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class Beenade extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "Beenade",
            0, 
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);

    private static int emptyCardsInHand;
    
    public Beenade() {
        super(cardInfo);
        this.cardsToPreview = new Bee();
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        emptyCardsInHand =  10 - (p.hand.group.size()-1);
        addToBot(new MakeTempCardInHandAction(new Bee(), emptyCardsInHand));
    }

    public void upgrade() {
        if (!this.upgraded) {
           this.upgradeName();
           this.selfRetain = true;
           this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
           this.initializeDescription();
        }
        super.upgrade();
  
     }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Beenade();
    }
    
}

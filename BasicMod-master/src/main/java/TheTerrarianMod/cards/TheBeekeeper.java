package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class TheBeekeeper extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "TheBeekeeper",
            1, 
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 3;
    
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    
    public TheBeekeeper() {
        super(cardInfo);

        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
        this.cardsToPreview = new Bee();
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        addToBot(new MakeTempCardInHandAction(new Bee(), this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new TheBeekeeper();
    }
    
}

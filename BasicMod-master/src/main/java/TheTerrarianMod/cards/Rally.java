package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.BetterDiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class Rally extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "Rally",
            1, 
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 3;
    
    public Rally() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        this.exhaust=true;
    }
    
    @Override
    public void upgrade() {
        this.exhaust = false;
        this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
        super.upgrade();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SMASH));
        addToBot(new BetterDiscardPileToHandAction(1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Rally();
    }
    
}

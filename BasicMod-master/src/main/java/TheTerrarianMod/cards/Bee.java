package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class Bee extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "Bee",
            0, 
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 2;
    private static final int UPG_DAMAGE = 2;
    
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    
    public Bee() {
        super(cardInfo);

        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
        this.exhaust=true;
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, magicNumber), magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Bee();
    }
    
}

package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.powers.PlatinumPower;
import TheTerrarianMod.util.CardInfo;

public class SmashPots extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "SmashPots",
            1, 
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.BASIC,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;
    //private static final int MAX_PLAT = 15;
    //private int platAmount;
    
    public SmashPots() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
    }
/* 
    private int randomInt(int min, int max) {
        return (int) ((Math.random() * max - min) + min);
    }
*/   
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        //platAmount = this.randomInt(this.magicNumber, MAX_PLAT);
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new PlatinumPower(p, magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SmashPots();
    }
    
}

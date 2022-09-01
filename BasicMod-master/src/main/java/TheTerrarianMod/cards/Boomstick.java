package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import java.util.Iterator;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class Boomstick extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "Boomstick",
            2, 
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 9;
    private static final int UPG_DAMAGE = 2;
    
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    
    public Boomstick() {
        super(cardInfo);

        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SMASH));

        Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        while(var3.hasNext()) {
           AbstractMonster mo = (AbstractMonster)var3.next();
           addToBot(new ApplyPowerAction(mo, p, new VulnerablePower(mo, magicNumber, false), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        }
  
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Boomstick();
    }
    
}

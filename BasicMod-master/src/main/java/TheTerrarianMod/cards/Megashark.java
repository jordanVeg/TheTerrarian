package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class Megashark extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "Megashark",
            3, 
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 3;
    private static final int UPG_DAMAGE = 1;
    
    private static final int MAGIC = 7;
    private static final int UPG_MAGIC = 0;

    
    public Megashark() {
        super(cardInfo);

        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);

        this.exhaust=true;
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (Integer i = 0; i < magicNumber; i++ ) {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Megashark();
    }
    
}

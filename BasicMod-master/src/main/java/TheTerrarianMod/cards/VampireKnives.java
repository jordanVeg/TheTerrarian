package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.VampireDamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class VampireKnives extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "VampireKnives",
            2, 
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.RARE,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 1;
    private static final int UPG_DAMAGE = 0;
    
    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 1;

    
    public VampireKnives() {
        super(cardInfo);

        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
        this.isMultiDamage = true;
        this.exhaust = true;
        this.tags.add(CardTags.HEALING);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (Integer i = 0; i < magicNumber; i++ ) {
            addToBot(new VampireDamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new VampireKnives();
    }
    
}


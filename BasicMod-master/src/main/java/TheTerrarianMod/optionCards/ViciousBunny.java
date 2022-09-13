package TheTerrarianMod.optionCards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import TheTerrarianMod.cards.BaseCard;
import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;


public class ViciousBunny extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "ViciousBunny",
            -2, 
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;
    private AbstractMonster target;

    
    public ViciousBunny(AbstractMonster m) {
        super(cardInfo);
        this.target = m;
        setMagic(MAGIC, UPG_MAGIC);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.onChoseThisOption();
    }

    public void onChoseThisOption() {
        AbstractPlayer p = AbstractDungeon.player;
        addToBot(new ApplyPowerAction(target, p, new WeakPower(target, magicNumber, false)));
     }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ViciousBunny(target);
    }
    
}

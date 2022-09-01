package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class SmashPots extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "SmashPots",
            1, 
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 5;
    private static final int MAX_GOLD = 25;
    private int goldAmount;
    
    public SmashPots() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        this.isEthereal=true;
        this.exhaust=true;
    }

    private int randomInt(int min, int max) {
        return (int) ((Math.random() * max - min) + min);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        goldAmount = this.randomInt(this.magicNumber, MAX_GOLD);
        AbstractDungeon.player.gainGold(goldAmount);

        for(int i = 0; i < goldAmount; ++i) {
            AbstractDungeon.effectList.add(new GainPennyEffect(p, p.hb.cX, p.hb.cY, p.hb.cX, p.hb.cY, true));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SmashPots();
    }
    
}

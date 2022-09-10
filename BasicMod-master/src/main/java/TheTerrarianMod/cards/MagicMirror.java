package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

public class MagicMirror extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "MagicMirror",
            0, 
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    
    public MagicMirror() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, magicNumber), magicNumber));
        this.addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, 1), 1));
        this.addToBot(new PressEndTurnButtonAction());
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MagicMirror();
    }
    
}

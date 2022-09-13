package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import java.util.ArrayList;

import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.modifiers.CrimsonModifier;
import TheTerrarianMod.optionCards.ViciousBunny;
import TheTerrarianMod.optionCards.ViciousGoldfish;
import TheTerrarianMod.util.CardInfo;
import basemod.helpers.CardModifierManager;

public class ViciousCritters extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "ViciousCritters",
            1, 
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    
    public ViciousCritters() {
        super(cardInfo);
        CardModifierManager.addModifier(this, new CrimsonModifier());
        setMagic(MAGIC, UPG_MAGIC);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> cardOptions = new ArrayList();
        cardOptions.add(new ViciousBunny(m));
        cardOptions.add(new ViciousGoldfish(m));

        if(this.upgraded) { 
            for (AbstractCard card : cardOptions) {
                card.upgrade();
            }
        }

        this.addToBot(new ChooseOneAction(cardOptions));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ViciousCritters();
    }
    
}

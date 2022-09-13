package TheTerrarianMod.cards;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.actions.PurifyAction;
import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.tags.CustomTags;
import TheTerrarianMod.util.CardInfo;

public class ProtectTheBase extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "ProtectTheBase",
            1, 
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);
    
    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 3;
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    
    public ProtectTheBase() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC, UPG_MAGIC);
        tags.add(CustomTags.PURE);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new PurifyAction(magicNumber, false));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ProtectTheBase();
    }
    
}

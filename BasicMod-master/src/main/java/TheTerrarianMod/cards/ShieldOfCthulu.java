package TheTerrarianMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.util.CardInfo;

import static TheTerrarianMod.TheTerrarianMod.*;

public class ShieldOfCthulu extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "ShieldOfCthulu",
            2, 
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 3;
    private static final int UPG_DAMAGE = 2;
    
    private static final int BLOCK = 7;
    private static final int UPG_BLOCK = 2;

    
    public ShieldOfCthulu() {
        super(cardInfo);

        setBlock(BLOCK, UPG_BLOCK);
        setDamage(DAMAGE, UPG_DAMAGE);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SMASH));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ShieldOfCthulu();
    }
    
}

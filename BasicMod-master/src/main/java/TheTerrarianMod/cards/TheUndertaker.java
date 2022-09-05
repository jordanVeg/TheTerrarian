package TheTerrarianMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.character.TheTerrarian;
import TheTerrarianMod.modifiers.CrimsonModifier;
import TheTerrarianMod.util.CardInfo;
import basemod.helpers.CardModifierManager;

import static TheTerrarianMod.TheTerrarianMod.*;

public class TheUndertaker extends BaseCard{

    private final static CardInfo cardInfo = new CardInfo(
            "TheUndertaker",
            1, 
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            TheTerrarian.Enums.CARD_COLOR
    );
    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 11;
    private static final int UPG_DAMAGE = 3;

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 0;

    
    public TheUndertaker() {
        super(cardInfo);
        CardModifierManager.addModifier(this, new CrimsonModifier());
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
    }
    
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SMASH));
        addToBot(new DrawCardAction(p, this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new TheUndertaker();
    }
    
}

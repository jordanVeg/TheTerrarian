package TheTerrarianMod.modifiers;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.actions.SpreadCrimsonAction;
import TheTerrarianMod.powers.BarbedPower;
import basemod.abstracts.AbstractCardModifier;

public class CrimsonModifier extends AbstractCardModifier {

    private int DAMAGE_BONUS = 1;
    private int BLOCK_BONUS  = 1;
    //TODO: Figure out how to modify MagicNumber
    private int MAGIC_BONUS  = 1;

    public CrimsonModifier() {
    }

    @Override
    public  String identifier(AbstractCard card) {
        return makeID("CrimsonModifier");
    }

    @Override
    public float modifyBaseDamage(float damage, DamageInfo.DamageType type, AbstractCard card, AbstractMonster target) {
        return damage + this.DAMAGE_BONUS;
    }

    @Override
    public float modifyBaseBlock(float block, AbstractCard card) {
        return block + this.BLOCK_BONUS;
    }

    @Override
     public String modifyDescription(String rawDescription, AbstractCard card) {
        return rawDescription + " NL theterrarianmodid:Crimson.";
     }

     @Override
     public void onUse(AbstractCard card, AbstractCreature target, UseCardAction action) {
        AbstractPlayer p = AbstractDungeon.player;
        this.addToBot(new ApplyPowerAction(p, p, new BarbedPower(p, 1), 1));
    }

    @Override
    public void onDrawn(AbstractCard card) {
        this.addToBot(new SpreadCrimsonAction(card));
        super.onDrawn(card);
    }
 

    protected void addToBot(AbstractGameAction action) {
        AbstractDungeon.actionManager.addToBottom(action);
    }

    @Override
     public void onRender(AbstractCard card, SpriteBatch sb) {
        card.glowColor = new Color(1.0F, 0.0F, 0.0F, 0.25F);
     }

    @Override
    public AbstractCardModifier makeCopy() {
        return new CrimsonModifier();
    }
}
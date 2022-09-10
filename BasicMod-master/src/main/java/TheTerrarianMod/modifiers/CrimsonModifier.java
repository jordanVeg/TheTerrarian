package TheTerrarianMod.modifiers;

import static TheTerrarianMod.TheTerrarianMod.makeID;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import TheTerrarianMod.actions.SpreadCrimsonAction;
import TheTerrarianMod.powers.BarbedPower;
import basemod.abstracts.AbstractCardModifier;

public class CrimsonModifier extends AbstractCardModifier {

    private int DAMAGE_BONUS = 1;
    private int BLOCK_BONUS  = 1;
    //TODO: Figure out how to modify MagicNumber
    //private int MAGIC_BONUS  = 1;
    private Color CRIMSON_GLOW_COLOR = new Color(1.0F, 0.0F, 0.0F, 0.25F);
    private Color CRIMSON_CARD_COLOR = new Color(1.0F, 0.0F, 0.0F, 1.0F);

    public CrimsonModifier() {
    }

    @Override
    public String identifier(AbstractCard card) {
        return makeID("CrimsonModifier");
    }

    @Override
    public float modifyDamage(float damage, DamageInfo.DamageType type, AbstractCard card, AbstractMonster target) {
        return damage + this.DAMAGE_BONUS;
    }

    @Override
    public float modifyBlock(float block, AbstractCard card) {
        return block + this.BLOCK_BONUS;
    }

    @Override
     public String modifyDescription(String rawDescription, AbstractCard card) {
        return "theterrarianmodid:Crimson. NL " + rawDescription;
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
       card.glowColor = CRIMSON_GLOW_COLOR;
       FontHelper.renderRotatedText(sb, FontHelper.cardTitleFont, card.name, card.current_x, card.current_y, 0.0F, 175.0F * card.drawScale * Settings.scale, card.angle, false, CRIMSON_CARD_COLOR);
     }

    @Override
    public AbstractCardModifier makeCopy() {
        return new CrimsonModifier();
    }
}
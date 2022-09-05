package TheTerrarianMod.actions;

import java.util.ArrayList;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import TheTerrarianMod.modifiers.CrimsonModifier;
import basemod.helpers.CardModifierManager;

public class SpreadCrimsonAction extends AbstractGameAction {
    private ArrayList<AbstractCard> hand;
    private AbstractCard caller;
    private AbstractCard nextCard;
    private AbstractCard prevCard;

    public SpreadCrimsonAction(AbstractCard card) {
        this.caller = card;
        this.hand   = AbstractDungeon.player.hand.group;
    }

    @Override
    public void update() {
        if (!this.isDone) {
            for(int i = 0; i < this.hand.size(); i++) {
                if(this.hand.get(i) == this.caller) {
                    /* Only Spread to next card if it is between 0 and HandSize-1 */
                    if(i >= 0 && i < this.hand.size()-1) {
                        this.nextCard = (AbstractCard)this.hand.get(i+1);
                        if (!CardModifierManager.hasModifier(nextCard, "TheTerrarianModID:CrimsonModifier")){
                            CardModifierManager.addModifier(nextCard, new CrimsonModifier());
                        }
                    }
                    /* Only Spread to next card if it is between 1 and HandSize */
                    if (i > 0 && i <= this.hand.size()-1) {
                        this.prevCard = (AbstractCard)this.hand.get(i-1);
                        if (!CardModifierManager.hasModifier(prevCard, "TheTerrarianModID:CrimsonModifier")){
                            CardModifierManager.addModifier(prevCard, new CrimsonModifier());
                        }
                    }
                    this.isDone = true; 
                }
            }
        }
    }



}
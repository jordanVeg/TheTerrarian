package TheTerrarianMod.actions;

import java.util.ArrayList;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import basemod.helpers.CardModifierManager;

public class PurifyAction extends AbstractGameAction {
    private AbstractPlayer p;
    private ArrayList<AbstractCard> hand = new ArrayList<>();
    private ArrayList<AbstractCard> crimsonCards = new ArrayList<>();
    private ArrayList<AbstractCard> uninfectedCards = new ArrayList<>();
    private int amount;
    private boolean fullHand;

    public PurifyAction(int amount, boolean fullHand) {
        this.hand   = AbstractDungeon.player.hand.group;
        this.p = AbstractDungeon.player;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_FAST;
        this.amount = amount;
        this.fullHand = fullHand;
    }

    @Override
    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            /* Add all cards that are currently infected to a list */
            for (AbstractCard card : hand) {
                if(CardModifierManager.hasModifier(card, "TheTerrarianModID:CrimsonModifier")) {
                    crimsonCards.add(card);
                } else {
                    uninfectedCards.add(card);
                }
            }

            /* If there are no crimson cards in your hand, return. */
            if(crimsonCards.size() == 0) {
                this.isDone = true;
                return;
            }

            if(this.fullHand) {
                /* 
                * If you are purifying the whole hand, add all Crimson cards 
                * to the toPurify list 
                */
                for (AbstractCard card : crimsonCards) {
                    CardModifierManager.removeModifiersById(card, "TheTerrarianModID:CrimsonModifier", false);
                    card.superFlash();
                    card.applyPowers();
                }
                this.isDone = true;
                return;
            } else {
                /* 
                * Choose a number of cards up to amount to add to the toPurify
                * list
                */
                this.hand.removeAll(this.uninfectedCards);
 
                AbstractDungeon.handCardSelectScreen.open("to Purify", amount, false, true, false, false);
                this.tickDuration();
                return;
            }
        }
 
        /* Check if Card selection has been returned yet */
        if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {

            for(AbstractCard card : AbstractDungeon.handCardSelectScreen.selectedCards.group) {
                CardModifierManager.removeModifiersById(card, "TheTerrarianModID:CrimsonModifier", false);
                card.superFlash();
                card.applyPowers();
                this.p.hand.addToTop(card);
            }

            this.returnCards();
            AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            AbstractDungeon.handCardSelectScreen.selectedCards.group.clear();
            this.isDone = true;
        }

        this.tickDuration();
    }


    private void returnCards() {
        for(AbstractCard card : uninfectedCards) {
            this.p.hand.addToTop(card);
        }

        this.p.hand.refreshHandLayout();
    }


}
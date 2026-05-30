import java.util.ArrayList;
import java.util.List;

public class character { ///// Will use a ":green" coin as the only coin for now will implement coins when merging (remind me if i forget)
    //attributes
    private int hp; //health points
    private int maxHp;
    private int def; //defence
    private int power;// to be added 
    private int cmv; //coin mood value (-100 to 100) 0 is default :|

    private ArrayList<Integer> cardList; //Empty as player doesnt start with enough cards to edit their deck ?
    private ArrayList<Integer> activeDeck; // populate default list with 2 t1, t2, t3  1 t4

    //default constructor
    public character(){

        this.maxHp = 20;
        this.hp = 20;
        this.def = 12;
        this.cmv = 0;

        this.activeDeck = new ArrayList<>(List.of(1,2,3,4,5,6,7));
    }

    public int getHp(){
        return hp;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public ArrayList<Integer> getDeck(){
        return activeDeck;
    }
    public int getDef(){
        return def;
    }
    public int getPwr(){
        return power;
    }
    public int getCmv(){
        return cmv;
    }
    public void takeDmg(int dmgTaken){ //for healing just do negative dmg
        hp -= dmgTaken;
    }

    public void showCardDeck(){
        System.out.println("\n =========Card Deck");
        System.out.println(" === Active Card Deck === ");
        for (Integer card : activeDeck) {
            String CardDets = Cards.cardDictionary.get(card).display;
            System.out.println("Card ID :"+ card);
            System.out.println(CardDets);
        }
        if(!cardList.isEmpty()){
            System.out.println(" === List of all Cards === ");
            for (Integer card : cardList) {
                String CardDets = Cards.cardDictionary.get(card).display;
                System.out.println("Card ID :"+ card);
                System.out.println(CardDets);
            }
        }
        // add deck edititing
    }
}

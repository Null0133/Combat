import java.util.ArrayList;
import java.util.Random;

// This class handles most enemy related thing such as creation and their desicion tree
public class Ai {
    public int aiType;
    public String name;
    public int aiHealth;
    public int aiHealthMax;
    public int aiDef;
    public int aiCMV;

    public Ai(int aiType, String name, int aiHealthMax, int aiDef, int aiCMV){
        this.name = name;
        this.aiHealth = aiHealthMax;
        this.aiHealthMax = aiHealthMax;
        this.aiDef = aiDef;
        this.aiCMV = aiCMV;
    }
    // Ai thought process different types of ai will have slightly different priorities in the trees based of their factions description
    // I did make it a bit dumb so that the game is begginer freindly without hours upon hours of testing and balancing the cards
    public static int aiTree(int playerHp, int aiHp, int lowestAllyHp , int aiType){  //atk target must be specified outside of this (eg if when it goes thru the tree it decides to atk an ally here the ai must know that before this tree)
        Random random = new Random();
        Cards.cards();
        int chosenCard = 1;
        switch (aiType) {
            case -1:
                ///Add different types of Ai
                break;
            default:
                if (aiHp < 11){
                    if (playerHp<5){
                        int length = Cards.getCardsByType(1).size();
                        ArrayList<Integer> Temp = new ArrayList<>(Cards.getCardsByType(1));
                        chosenCard = Temp.get(random.nextInt(1, length + 1));
                    }
                    else{ 
                        if (lowestAllyHp!=0){
                            if(lowestAllyHp<playerHp){  // only instance where we atk the ally
                                int length = Cards.getCardsByType(1).size();
                                ArrayList<Integer> Temp = new ArrayList<>(Cards.getCardsByType(1));
                                chosenCard = Temp.get(random.nextInt(1, length + 1));
                            }
                            else {
                                int length = Cards.getCardsByType(1).size() + Cards.getCardsByType(2).size() + Cards.getCardsByType(3).size();
                                ArrayList<Integer> Temp = new ArrayList<>(Cards.getCardsByType(3));
                                Temp.addAll(Cards.getCardsByType(2));
                                Temp.addAll(Cards.getCardsByType(1));
                                chosenCard = Temp.get(random.nextInt(1, length + 1));
                            }
                        }
                        else{
                            int temp = random.nextInt(1,10);
                            if (temp == 10){
                                int length = Cards.getCardsByType(4).size();
                                ArrayList<Integer> Temp = new ArrayList<>(Cards.getCardsByType(4));
                                chosenCard = Temp.get(random.nextInt(1, length + 1));
                            }
                            else {
                                int length = Cards.getCardsByType(2).size() + Cards.getCardsByType(3).size();
                                ArrayList<Integer> Temp = new ArrayList<>(Cards.getCardsByType(2));
                                Temp.addAll(Cards.getCardsByType(2));
                                chosenCard = Temp.get(random.nextInt(1, length + 1));
                            }
                        }
                    }
                }
                else{
                    int length = Cards.getCardsByType(1).size();
                    ArrayList<Integer> Temp = new ArrayList<>(Cards.getCardsByType(1));
                    chosenCard = Temp.get(random.nextInt(1, length + 1));
                }
                break;
        }
        int temp = random.nextInt(1,10);
        if (temp == 10){
            int length = Cards.getCardsByType(1).size() + Cards.getCardsByType(2).size() + Cards.getCardsByType(3).size();
            ArrayList<Integer> Temp = new ArrayList<>(Cards.getCardsByType(3));
            Temp.addAll(Cards.getCardsByType(2));
            Temp.addAll(Cards.getCardsByType(1));
            chosenCard = Temp.get(random.nextInt(1, length + 1));
        }
        return chosenCard;
    }
}

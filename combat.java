import java.util.Random;

import javax.smartcardio.Card;

import java.util.ArrayList;
import java.util.List;

record diceResult(int sum, List<Integer> rolls) {}
public class combat{
    character player = new character();
    public void main(String[] args) {   //replace main with the combat start string thingy also my main is going to be different to the main in the project
        
        Cards.cards();
        System.out.println(Cards.getCardsByType(2).size());
        System.out.println("2. Move to a new location");
        System.out.println("3. Show inventory");
        System.out.println("4. View and edit Card Deck"); // change debug to 5 when mearging

    }
    public static int aiTurn(int playerHp, int aiHp, int lowestAllyHp , int aiType){  //atk target must be specified outside of this (eg if when it goes thru the tree it decides to atk an ally here the ai must know that before this tree)
        Random random = new Random();
        Cards.cards();
        int chosenCard = 1;
        switch (aiType) {
            case 0:
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
                                ArrayList<Integer> Temp = new ArrayList<>(Cards.getCardsByType(2));
                                Temp.addAll(Cards.getCardsByType(2));
                                Temp.addAll(Cards.getCardsByType(1));
                                chosenCard = Temp.get(random.nextInt(1, length + 1));
                            }
                        }
                        else{
                            int length = Cards.getCardsByType(2).size() + Cards.getCardsByType(3).size();
                            ArrayList<Integer> Temp = new ArrayList<>(Cards.getCardsByType(2));
                            Temp.addAll(Cards.getCardsByType(2));
                            chosenCard = Temp.get(random.nextInt(1, length + 1));
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
        return chosenCard;
    }
    public static diceResult rollDice(int num,int sides){

            Random random = new Random();
            int sum = 0;
            ArrayList<Integer> Rolls = new ArrayList<>();

            for(int i = 0; i<num;i++){
                int role = random.nextInt(1,sides + 1);
                Rolls.add(role);
                sum += role;
            }

            return new diceResult(sum, Rolls);
    }

    
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Cards{
    public static Map<Integer, CardDetails> cardDictionary = new HashMap<>();
    public static void cards(){
        cardDictionary.put(1, new CardDetails(1,1,4,1,6,"1d4 a 1d6 a"));        
        cardDictionary.put(2, new CardDetails(1,1,6,2,4,"1d6 a 2d4 a")); 
        cardDictionary.put(3, new CardDetails(2,1,4,1,4,"1d4 a 1d4 d(1)"));        
        cardDictionary.put(4, new CardDetails(2,1,6,2,6,"1d6 a 2d6 d(2)")); 
        cardDictionary.put(5, new CardDetails(3,1,12,1,4,"1d12 d(2) 1d4 a"));        
        cardDictionary.put(6, new CardDetails(3,1,4,2,6,"hi")); 
        cardDictionary.put(7, new CardDetails(4,1,4,1,6,"hi"));        
        cardDictionary.put(8, new CardDetails(4,1,12,2,4,"hi")); 
        cardDictionary.put(9, new CardDetails(5,1,4,1,4,"hi"));        
        cardDictionary.put(10, new CardDetails(5,1,2,2,4,"hi")); 
        cardDictionary.put(11, new CardDetails(6,1,2,1,6,"hi"));        
        cardDictionary.put(12, new CardDetails(6,1,2,2,4,"hi")); 
    }
    public static List<Integer> getCardsByType(int targetType){
        ArrayList<Integer> matchingCardId = new ArrayList<>();

        for(Map.Entry<Integer, CardDetails> temp : cardDictionary.entrySet()) {
            if (temp.getValue().type == targetType){
                matchingCardId.add(temp.getKey());
            }
        }

        return matchingCardId;
    }
}

class CardDetails {
    int type; 
    /*different types have different actions
     a = action, d = defence, b = boost
    type 1 - aa
    type 2 - ad 
    type 3 - da
    type 4 - dd
    type 5 - ba
    type 6 - ab */

    int num;
    int dice;
    int num2; //for the second action
    int dice2;
    String display; //text that will be displayed to the user in the inventory / game

    public CardDetails(int Type, int Num, int Dice, int Num2, int Dice2, String Display){
        this.type = Type;
        this.num = Num;
        this.dice = Dice;
        this.num2 = Num2;
        this.dice2 = Dice2;
        this.display = Display;
        
    }
}
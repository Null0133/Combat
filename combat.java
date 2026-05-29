import java.util.Random;
import java.util.ArrayList;
import java.util.List;

record diceResult(int sum, List<Integer> rolls) {}

public class combat{
    public static void main(String[] args) {   //replace main with the combat start string thingy
        Cards.cards();
        System.out.println(Cards.getCardsByType(2));
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

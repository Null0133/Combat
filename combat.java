import java.util.Random;

public record diceResult(List<Integer> rolls, int sum) {}
public class Combat{
    public static void main(String[] args) {   //replace main with the combat start string thingy
        Cards.cards();
        System.out.println(Cards.getCardsByType(2));
    }

    public static int rollDice(int num,int sides){
            Random random = new Random();
            int sum = 0;
            List<Integer> Rolls = new ArrayList<>();
            for(int i = 0; i<num;i++){
                int role = random.nextInt(1,sides + 1);
                Rolls.add(role);
                sum += role;
            }
            return diceResult(Rolls, sum);
}

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

record diceResult(int sum, List<Integer> rolls) {}
public class combat{
    private static final Scanner scanner = new Scanner(System.in);

    character mainCharacter = new character();

    private String BattleID;

    private int numberOfWaves;
    /*private Coin[] rewardedCoins;*/
    private ArrayList<String> rewardedKeyItems;
    private ArrayList<String> rewardedPassives;
    private ArrayList<String> EnemiesList;
    private ArrayList<Integer> EnemiesListType;
    private ArrayList<Integer> EnemiesListDef;
    private ArrayList<Integer> EnemiesListCmv;
    private ArrayList<Integer> EnemiesListHp;//max hp  
    //passives etc, idk. u figure it out.

    //floor 1 room 1


    public void main(String[] args) {   //replace main with the combat start string thingy also my main is going to be different to the main in the project
        
        Cards.cards();
        System.out.println(Cards.getCardsByType(2).size());
        System.out.println("2. Move to a new location");
        System.out.println("3. Show inventory");
        System.out.println("4. View and edit Card Deck"); // change debug to 5 when mearging
        ArrayList<String> EmptyArray = new ArrayList<String>();
        ArrayList<Integer> EmptyArrayi = new ArrayList<Integer>();
        Battle("1", 1, EmptyArray, EmptyArray, EmptyArray, EmptyArrayi, EmptyArrayi, EmptyArrayi, EmptyArrayi);
        ArrayList<String> EmptyArrayf = new ArrayList<String>();
        EmptyArrayf.add("test");
        EmptyArrayf.add("test2");
        startBattle(mainCharacter.getDeck(), EmptyArrayf, EmptyArrayi, EmptyArrayi, EmptyArrayi, EmptyArrayi);
    }



    
    


    public void Battle(String BattleID, int numberOfWaves, /*Coin[] rewardedCoins,*/ ArrayList<String> rewardedPassives, ArrayList<String> rewardedKeyItems, ArrayList<String> EnemiesList, ArrayList<Integer> EnemiesListType, ArrayList<Integer> EnemiesListDef, ArrayList<Integer> EnemiesListCmv, ArrayList<Integer> EnemiesListHp){

        this.BattleID = BattleID;
        this.numberOfWaves = numberOfWaves;
        //this.rewardedCoins = rewardedCoins;
        this.rewardedKeyItems = rewardedKeyItems;
        this.rewardedPassives = rewardedPassives;
        this.EnemiesList = EnemiesList;
        this.EnemiesListType = EnemiesListType;  //basically moving setup of enemies to 
        this.EnemiesListDef = EnemiesListDef;
        this.EnemiesListCmv = EnemiesListCmv;
        this.EnemiesListHp = EnemiesListHp;
    }

    //// ADD INVENTORY WHEN MERGING (or ask kai if my thing is still tweaking)
    
    ///all values that are not specifically maincharacter XXX are enemy values 
    public boolean startBattle(List<Integer> activedeck, List<String> enemyList, List<Integer> type, List<Integer> Def, List<Integer> CMV, List<Integer> HP){
        System.out.println("Combat start");
        Random random = new Random();
        ArrayList<Integer> currentHand = new ArrayList<>();
        ArrayList<Integer> discarded = new ArrayList<>();
        ArrayList<Integer> drawpile = new ArrayList<>();

        drawpile.addAll(activedeck);
        Collections.shuffle(drawpile);
        List<Integer> Pop = drawpile.subList(drawpile.size() - 3, drawpile.size());
        currentHand.addAll(Pop);
        Pop.clear();
        System.out.println(currentHand);
        System.out.println(drawpile);

        ArrayList<String> combatOrder = new ArrayList<>();
        combatOrder.add("Player");
        combatOrder.addAll(enemyList);
        Collections.shuffle(combatOrder);
        System.out.println(combatOrder);

        ArrayList<Ai> aiList = new ArrayList<>();
        for (int i= 0; i <= enemyList.size(); i++){
            aiList.add(new Ai(type.get(i), enemyList.get(i), HP.get(i), Def.get(i), CMV.get(i)));
        }

        return false;
    }////////////////////////////////INTEGRATE THE COIN TOSS EVERY THIRD TURN (for now make it give a random amount of power)(maybe randomize the buffs later)
    public void playerTurn(ArrayList<Integer> currentHand, ArrayList<String> enemyList, ArrayList<Integer> enemyHp, ArrayList<String> combatOrder, int power){
        
        System.out.println("All Enemies In Combat Order"); //Displays the Combat order
        for (int i = 0; i<= enemyList.size() - 1; i++){
            
            if (combatOrder.get(i) != "Player"){
                int ehp = 20;
                System.out.println("Order No " + i + " : " + combatOrder.get(i));
                for (String enemy : combatOrder) {
                    if (enemy == enemyList.get(i)){
                        ehp = enemyHp.get(i);
                    }
                }
                System.out.print("Hp: " + ehp);
            }
            else{
                System.out.println("Order No " + i + " : Player");
                System.out.println("Hp: " + mainCharacter.getHp());
            }
        }

        System.out.println("Dealt Cards"); //Displays the cards you have been given
        for (int i = 0; i<=3; i++){
            System.out.println("Card ID: " + currentHand.get(i));
            System.out.print("Cost of card " + Cards.cardDictionary.get(currentHand.get(i)).cost);
            System.out.print(Cards.cardDictionary.get(currentHand.get(i)).display);
        }
        
        System.out.println("You have " + mainCharacter.getPwr() + "power to use:");
        ArrayList<Integer> playedCards = new ArrayList<>();
        ArrayList<Integer> discardedCards = new ArrayList<>();
        int input = 0;
        while (input!=3){
            System.out.println("Please select an action: \n 1. Select Cards to discard \n 2. Select Cards to play \n 3. Veiw Cards Again \n 4.Submit Actions");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    for (int i = 0; i <= 3; i++){
                        System.out.println("Card ID: " + currentHand.get(i));
                        System.out.print("Cost of card " + Cards.cardDictionary.get(currentHand.get(i)).cost);
                        System.out.print(Cards.cardDictionary.get(currentHand.get(i)).display);
                        System.out.println("would you like to discard this card? \n 1. Yes \n 2. No");
                        int del = scanner.nextInt();
                        if (del == 1){
                            int check = 0;
                            for (int card : playedCards) {
                                check++;
                                if (currentHand.get(i) == card){
                                    System.out.print("You cannot discard a played card");
                                    
                                    break;
                                }
                            }
                            if (check == 3){
                                System.out.print("The Card has been added to the discard pile");
                                discardedCards.add(currentHand.get(i));
                            }
                        }
                        else{
                            
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error please make sure you enter 1 2 or 3");
                   break;
            }
        }
        
    }
    
    public static diceResult rollDice(int num,int sides){

            Random random = new Random();
            int sum = 0;
            ArrayList<Integer> Rolls = new ArrayList<>();

            for(int i = 0; i<num;i++){
                int roll = random.nextInt(1,sides + 1);
                Rolls.add(roll);
                sum += roll;
            }

            return new diceResult(sum, Rolls);
    }
    public static int rollCMV(int CMV){
        int roll = 1;
        int cm10 = CMV / 10;
        Random random = new Random();
        roll = random.nextInt(1, 20 + 1 + cm10);
        if (roll>20){
            roll = 20;
        }
        return roll;
    }    
}

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

record diceResult(int sum, List<Integer> rolls) {}
public class combat{
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
    
    //all values that are not specifically maincharacter.XXX are enemy values 
    public boolean startBattle(List<Integer> activedeck, List<String> enemyList, List<Integer> type, List<Integer> Def, List<Integer> CMV, List<Integer> HP){
        System.out.println("Combat start");
        Random random = new Random();
        ArrayList<Integer> currentHand = new ArrayList<>();
        ArrayList<Integer> discarded = new ArrayList<>();
        ArrayList<Integer> drawpile = new ArrayList<>();

        drawpile.addAll(activedeck);
        Collections.shuffle(drawpile);
        List<Integer> Pop = drawpile.subList(drawpile.size() - 4, drawpile.size());
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

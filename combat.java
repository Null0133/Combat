import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

record diceResult(int sum, List<Integer> rolls) {}
public class combat{
    character mainCharacter = new character();
    public void main(String[] args) {   //replace main with the combat start string thingy also my main is going to be different to the main in the project
        
        Cards.cards();
        System.out.println(Cards.getCardsByType(2).size());
        System.out.println("2. Move to a new location");
        System.out.println("3. Show inventory");
        System.out.println("4. View and edit Card Deck"); // change debug to 5 when mearging

    }
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



    public void Battle(String BattleID, int numberOfWaves, /*Coin[] rewardedCoins,*/ ArrayList<String> rewardedPassives, ArrayList<String> rewardedKeyItems, ArrayList<String> EnemiesList, List<Integer> EnemiesListType, List<Integer> EnemiesListDef, List<Integer> EnemiesListCmv, List<Integer> EnemiesListHp){

        this.BattleID = BattleID;
        this.numberOfWaves = numberOfWaves;
        //this.rewardedCoins = rewardedCoins;
        this.rewardedKeyItems = rewardedKeyItems;
        this.rewardedPassives = rewardedPassives;
        this.EnemiesList = EnemiesList;
        this.EnemiesListType = EnemiesListType;
        this.EnemiesListDef = EnemiesListDef;
        this.EnemiesListCmv = EnemiesListCmv;
        this.EnemiesListHp = EnemiesListHp;

        ArrayList<Integer> activedeck = mainCharacter.getDeck();
        combatInt1(activedeck, EnemiesList.size(), EnemiesList, EnemiesListType, EnemiesListDef, EnemiesListCmv, EnemiesListHp);
    }

    //// ADD INVENTORY WHEN MERGING (or ask kai if my thing is still tweaking)
    public static DUNNO combatInt1(List<Integer> activedeck, int noEnemies, List<String> enemyList, List<Integer> type, List<Integer> Def, List<Integer> CMV, List<Integer> HP){
        Random random = new Random();
        ArrayList<Integer> currentHand = new ArrayList<>();
        ArrayList<Integer> discarded = new ArrayList<>();
        ArrayList<Integer> drawpile = new ArrayList<>();

        ArrayList<Ai> aiList = new ArrayList<>();
        for (int i= 0; i <= noEnemies; i++){
            aiList.add(new Ai(type.get(i), enemyList.get(i), HP.get(i), Def.get(i), CMV.get(i)));
        }

        ArrayList<String> combatOrderTxt = new ArrayList<>();
        combatOrderTxt.add("Player");
        combatOrderTxt.addAll(enemyList);
        Collections.shuffle(combatOrderTxt);

        
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
        }///// ADD A CHANCE TO MAKE IT A RANDOM TYPE 1 2 3 CARD 
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
    public static diceResult rollCMV(int num, int sides, int CMV){

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

import java.util.ArrayList;

public class character {
    //attributes
    private int hp = 20; //health points
    private int def = 12; //defence
    private int power;// to be added 
    private int spd; //speed

    private ArrayList<Integer> cardList; // populate default list with 2 t1, t2, t3  1 t4

    public int getHp(){
        return hp;
    }
    public int getDef(){
        return def;
    }
    public int getSpd(){
        return spd;
    }
    public void takeDmg(int dmgTaken){ //for healing just do negative dmg
        hp -= dmgTaken;
    }

}

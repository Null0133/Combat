import java.util.ArrayList;

public class character { ///// Will use a ":green" coin as the only coin for now will implement coins when merging (remind me if i forget)
    //attributes
    private int hp = 20; //health points
    private int def = 12; //defence
    private int power;// to be added 
    private int spd; //speed
    private int cmv = 0; //coin mood value (-100 to 100) 0 is default :|

    private ArrayList<Integer> cardList; // populate default list with 2 t1, t2, t3  1 t4

    public int getHp(){
        return hp;
    }
    public int getDef(){
        return def;
    }
    public int getPwr(){
        return power;
    }
    public int getSpd(){
        return spd;
    }
    public int getCmv(){
        return cmv;
    }
    public void takeDmg(int dmgTaken){ //for healing just do negative dmg
        hp -= dmgTaken;
    }
    public void setSpd(int spd2){ //for healing just do negative dmg
        spd = spd2;
    }

}

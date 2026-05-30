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
}

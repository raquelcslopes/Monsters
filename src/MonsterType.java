public enum MonsterType {
    VAMPIRE ( "Vampire",15),
    WEREWOLF ( "Werewolf", 15),
    MUMMY ( "Mummy",30);


    private String name;
    private int damage;

    private MonsterType(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
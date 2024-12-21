public class Werewolf extends Monster {

    public Werewolf ( MonsterType type) {
        super(type);
        this.damage = MonsterType.WEREWOLF.getDamage();
        this.name = MonsterType.WEREWOLF.getName();
    }

    @Override
    public void damageGiven(Supernatural defender) {
        if (!isDead()) {
            defender.setLife(defender.getLife() - damage);
            System.out.println("Damage " + this.damage);
            System.out.println(defender.name  + " " + defender.noLife());

        } else {
            System.out.println("Is dead");
        }
    }


    public boolean isDead() {
        return this.getLife() <= 0;
    }
}
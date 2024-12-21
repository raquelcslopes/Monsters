public class Mummy extends Monster {
    int consecutiveRoundCounter;

    public Mummy( MonsterType type) {
        super(type);
        this.damage = MonsterType.MUMMY.getDamage();
        this.name = MonsterType.MUMMY.getName();
    }


    public void damageGiven(Supernatural defender) {
        if (!isDead()) {
            defender.setLife(defender.getLife() - damage);
            autoInjure();
            consecutiveRoundCounter++;
            System.out.println("Damage " + this.damage);
            System.out.println(defender.name  + " " + defender.noLife());

        } else {
            System.out.println("Is dead");
        }
    }


    public boolean isDead() {
        return this.getLife() <= 0;
    }

    public void autoInjure() {
        if (consecutiveRoundCounter == 3) {
            this.setLife((int) Math.floor(this.getLife() - (this.getLife() * 0.15)));
            consecutiveRoundCounter = 0;
        }
    }
}
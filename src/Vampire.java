public class Vampire extends Monster {

    public Vampire( MonsterType type) {
        super(type);
        this.damage = MonsterType.VAMPIRE.getDamage();
        this.name =   MonsterType.VAMPIRE.getName();
    }


    public void damageGiven(Supernatural defender) {
        if (!isDead()) {
            defender.setLife(defender.getLife() - damage);
            bite();
            System.out.println("Damage " + this.damage);
            System.out.println(defender.name  + " " + defender.noLife());

        } else {
            System.out.println("Is dead");
        }
    }


    public boolean isDead() {
        return this.getLife() <= 0;
    }

    public void bite() {
        int probability = (int) (Math.random() * (100 - 0 + 1) + 0);

        if (probability <= 30) {
            System.out.println("You healed " + this.getLife() * 0.25);
            this.setLife((int) (getLife() * 0.25));

        } else {
            System.out.println("You failed to heal");
        }
    }
}
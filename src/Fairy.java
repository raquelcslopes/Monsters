public class Fairy extends Supernatural {

    public Fairy() {
        this.damage = 20;
    }


    public void fairyDamage (Supernatural defender) {
            defender.setLife(defender.getLife() - damage);
        System.out.println("Fairy attacked " + " you received " + damage +  " damage");
        System.out.println(defender.name  + " " + defender.noLife());
    }
}
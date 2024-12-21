public abstract class Supernatural {
    protected int life = 100; //private
    protected String name;
    protected int damage;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String noLife(){
        if(getLife() <= 0){
            setLife(0);
            return "You died";
        }
        return "You have " + getLife();
    }
}
public class Player {
    private String name;
    private Monster[] deck = new Monster[0];


    public Player(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }


    public Monster[] getDeck() {
        return deck;
    }


    public int rollTheDice () {
        int min = 1;
        int max = 6;

        return (int) (Math.random() * (max - min + 1) + min);
    }


    public int chooseNumberOfCards(){
        int min = 1;
        int max = 6;

        return (int) (Math.random() * (max - min + 1) + min);
    }


    public void addToDeck (Monster monster) {
        Monster[] newArray = new Monster[deck.length + 1];

        if (deck.length == 0) {
            newArray[0] = monster;
        } else {
            for (int i = 0; i <= deck.length-1; i++) {
                newArray[i] = deck[i];
            }
            newArray[newArray.length - 1] = monster;
        }
        deck = newArray;
    }


    public boolean hasAliveMonsters() {
        for (int i = 0; i < deck.length; i++) {
            if (getDeck()[i].isDead()) {
                return false;
            }
        }
        return true;

    }
}
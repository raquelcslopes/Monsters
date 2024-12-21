public class Game {
    private Player player1;
    private Player player2;
    private int deckSize;
    Supernatural fairy = new Fairy();
    Supernatural witch = new Witch();


    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    // decide who starts
    public void start() {
        rollingTheDice();

        generateNumberOfCards();
        generateDeck(player1);
        generateDeck(player2);
        playGame();
        winner();
    }


    // decide number of cards to start
    public int generateNumberOfCards() {
        int player1Cards = this.player1.chooseNumberOfCards();
        int player2Cards = this.player2.chooseNumberOfCards();

        //System.out.println(this.player1.getName() + " decide to play with " + player1Cards+ " cards!");
        //System.out.println(this.player2.getName() + " decide to play with " + player2Cards+ " cards!");

        if (player1Cards == player2Cards) {
            System.out.println("We choose to play with " + player1Cards + " cards\n ");

            this.deckSize = player1Cards;

            return deckSize;
        }

        return this.generateNumberOfCards();
    }


    private void rollingTheDice() {
        int player1Move = this.player1.rollTheDice();
        int player2Move = this.player2.rollTheDice();

        System.out.println("Let's begin:");
        System.out.println(this.player1.getName() + " roll " + player1Move + " and " + this.player2.getName() + " roll " + player2Move);

        if (player1Move == player2Move) {
            start();

        }
        if (player1Move > player2Move) {
            System.out.println(this.player1.getName() + " starts\n");
        } else {
            System.out.println(this.player2.getName() + " starts\n");
            swapPlayer();
        }
    }


    public int randomAttack(){
        int max = deckSize -1;
        int randomMonsterIndex = (int) ((Math.random() * (max + 1)));
        return randomMonsterIndex;
    }


    //create deck
    public void generateDeck(Player playerToChooseCards) {
        int maxCards = deckSize;
        int maxNumberMonster = 2;
        int minNumberMonster = 0;

        while (playerToChooseCards.getDeck().length < maxCards) {

            int index = (int) ((Math.random() * (maxNumberMonster - minNumberMonster + 1)) + minNumberMonster);
            Monster monsterCard = GenerateMonster.getMonster(index);

            playerToChooseCards.addToDeck(monsterCard);

        }
    }


    public void attackRound(Player playerAttack, Player playerDefend) {
        int probabilityMax = 100;
        int probabilityMin = 0;
        int probabilityofCaos = (int) (Math.random() * (probabilityMax - probabilityMin + 1)) + probabilityMin;

        if (probabilityofCaos <= 23) {
            fairyAttack(playerAttack,playerDefend);

        }else if (probabilityofCaos > 23 && probabilityofCaos <= 45) {
            witchAttack(playerAttack, playerDefend);

        } else
            gameWithoutObstacles(playerAttack, playerDefend);
    }

    private void gameWithoutObstacles(Player playerAttack, Player playerDefend) {


        Monster monsterToAttack = playerAttack.getDeck()[randomAttack()];
        Monster monsterToDefend = playerDefend.getDeck()[randomAttack()];

        if (monsterToDefend.isDead() && monsterToAttack.isDead()) { //se dead //monstertodefend.isDead
            attackRound(playerAttack, playerDefend);


        } else if (playerDefend.hasAliveMonsters()) { //if alive
            System.out.println("\nNext round:");
            System.out.println(playerAttack.getName() + " " + " attacks " + playerDefend.getName());

            monsterToAttack.damageGiven(monsterToDefend); //ataca
        }
    }


    public void fairyAttack (Player playerAttack, Player playerDefend) {

        Monster monsterToAttack = playerAttack.getDeck()[randomAttack()];
        Monster monsterToDefend = playerDefend.getDeck()[randomAttack()];

        if (monsterToDefend.isDead() && monsterToAttack.isDead()) {
            attackRound(playerAttack, playerDefend);

        } else {
            System.out.println("\nNext round:");
            System.out.println(monsterToAttack.name + " and " + monsterToDefend.name +  " was selected");

            ((Fairy) fairy).fairyDamage(monsterToAttack);
            ((Fairy) fairy).fairyDamage(monsterToDefend);
        }
    }

    public void witchAttack(Player playerAttack, Player playerDefend) {


        Monster monsterToAttack = playerAttack.getDeck()[randomAttack()];
        Monster monsterToDefend = playerDefend.getDeck()[randomAttack()];

        int maxRoundAttack = 1;
        int randomWitchAttack = (int) ((Math.random() * (maxRoundAttack + 1)));


        if (monsterToDefend.isDead() && monsterToAttack.isDead() && ((Witch) witch).isDead()) {
            attackRound(playerAttack, playerDefend);

        }else if (randomWitchAttack == 0) {
            System.out.println("\nNext round:");
            System.out.println(monsterToAttack.name + " and " + monsterToDefend.name +  " was selected");

                ((Witch) witch).damageGiven(monsterToAttack);
                ((Witch) witch).damageGiven(monsterToDefend);

            } else {
                monsterToAttack.setDamage(((Witch) witch).getDamage()/2);

                monsterToDefend.setDamage(((Witch) witch).getDamage()/2);

            }
        }



        public void playGame() {

        while (player1.hasAliveMonsters() && player2.hasAliveMonsters()) {
            attackRound(this.player1, this.player2);

            if (player1.hasAliveMonsters() && player2.hasAliveMonsters()) {
                attackRound(this.player2, this.player1);
            }
        }
    }


    public void winner(){
        if (!player1.hasAliveMonsters() ) {
            System.out.println(player1.getName() + " wins");
        } else {
            System.out.println(player2.getName() + " wins");
        }
    }


    public void swapPlayer(){
        Player swap = this.player1;
        this.player1 = this.player2;
        this.player2 = swap;
    }
}
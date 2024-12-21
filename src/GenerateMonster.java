public class GenerateMonster {

    public static Monster getMonster(int index) {
        if(index == 0) {
            return new Vampire( MonsterType.VAMPIRE);
        }

        if (index == 1) {
            return new Werewolf(MonsterType.WEREWOLF);
        }
        return new Mummy( MonsterType.MUMMY);

    }
}
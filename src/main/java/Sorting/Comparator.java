package Sorting;

public class Comparator {
    public static void main(String[] args) {
        Player a = new Player("b",200);
        Player b = new Player("a",200);

        System.out.println(compare(a, b));
    }

    public static class Player{
        String name;
        int score;

        public Player(String name, int score){
            this.name = name;
            this.score = score;
        }
    }

    /**
     * This method return integer according to comparison of Player a and b, so a.compareTo(b) returns :
     *      negative value if a < b (a appear first),
     *      zero if a = b,
     *      positive value if a > b (a appear second),
     * if scores are equal ascending by name.
     * @param a Player a
     * @param b Player b
     * @return (-) integer value a come before b, (+) integer value if b come before a
     *
     * First, check if scores are equal,
     *       if scores are equal then return according to name value
     *       if scores aren't equal then return according to score value
     */

    public static int compare(Player a, Player b) {
        if(a.score == b.score){
            return a.name.compareTo(b.name);
        }
        return b.score-a.score;
    }
}

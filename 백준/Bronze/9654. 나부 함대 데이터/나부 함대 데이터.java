public class Main {

    public static void main(String[] args) {
        String[][] str = {{"SHIP NAME", "CLASS", "DEPLOYMENT", "IN SERVICE"}
                , {"N2 Bomber", "Heavy Fighter", "Limited", "21"}
                , {"J-Type 327", "Light Combat", "Unlimited", "1"}
                , {"NX Cruiser", "Medium Fighter", "Limited", "18"}
                , {"N1 Starfighter", "Medium Fighter", "Unlimited", "25"}
                , {"Royal Cruiser", "Light Combat", "Limited", "4"}};

        for (String[] strings : str) {
            System.out.printf("%-15s%-15s%-11s%-10s\n", strings[0], strings[1], strings[2], strings[3]);
        }
    }
}
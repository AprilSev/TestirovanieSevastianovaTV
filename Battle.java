package dz7;

public class Battle {

    private static int round = 1;

    public static void main(String[] args) {

        LightSolder lightSolder = new LightSolder("LightSolder", 15f, 25f, 150f);
        DarkSolder darkSolder = new DarkSolder("DarkSolder", 17f,22f, 150f);
        Bishop bishop = new Bishop("Bishop", 25f);
        SwordSinger swordSinger = new SwordSinger("SwordSinger", 3f);


        while (!lightSolder.isDeadSolder() || !darkSolder.isDeadSolder()){
            System.out.println(" Round: " + round);
            System.out.println(lightSolder.getMeInfo());
            System.out.println(darkSolder.getMeInfo());

            swordSinger.baf(lightSolder);

            lightSolder.criticalDamage(darkSolder);

            lightSolder.attack(darkSolder);
            if (darkSolder.isDeadSolder()) {
                System.out.println(lightSolder.name + " is win ");
                break;
            }

            bishop.heal(darkSolder);

            swordSinger.baf(darkSolder);

            darkSolder.criticalDamage(lightSolder);

            darkSolder.attack(lightSolder);
            if (lightSolder.isDeadSolder()) {
                System.out.println(darkSolder.name + " is win ");
                break;
            }

            bishop.heal(lightSolder);

            round++;
        }

    }
}

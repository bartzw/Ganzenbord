package nl.qien.weekopdrachtenGanzenbord;
import java.util.ArrayList;
import java.util.Scanner;
public class Spelers {
    public static int winnerGans = 0;
    public static int putPlayer;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Welkom bij Ganzenbord!\n");
        System.out.print("Met hoeveel personen wil je spelen?: ");
        int numberPeople = Integer.parseInt(reader.nextLine());
        ArrayList<SpelerToevoegen> SpelersSpel = new ArrayList<SpelerToevoegen>();

        for (int i = 0; i < numberPeople; i++) {
            String SpelerNaam;
            int b = i + 1;
            System.out.println("Hallo speler " + b + ", wat is jouw naam?:");
            SpelerNaam = reader.nextLine();
            SpelersSpel.add(new SpelerToevoegen(b, SpelerNaam, 0, false, false, false, 0));
        }
        SpelersSpel.forEach(SpelerToevoegen -> {
            System.out.println("Speler" + SpelerToevoegen.getNummer() + ": " + SpelerToevoegen.getNaam()
                    + ", Positie : " + SpelerToevoegen.getPositie());
        });

        while (winnerGans == 0) {
            SpelersSpel.forEach(SpelerToevoegen -> {
                if (!SpelerToevoegen.getGevangenis()) {
                    if (!SpelerToevoegen.getPut()) {
                        SpelerToevoegen.exitPut();
                        if (!SpelerToevoegen.getOverslaan()) {
                            if (SpelerToevoegen.getPositie() < 63) {
                                System.out.print(SpelerToevoegen.getNaam() + " is aan de beurt, je staat op vakje "
                                        + SpelerToevoegen.getPositie() + " druk op g om te gooien.");
                                reader.nextLine();
                                SpelerToevoegen.updatePositie();
                                if (SpelerToevoegen.getPositie() == 31) {
                                    putPlayer = SpelerToevoegen.getNummer();
                                }
                                if (SpelerToevoegen.getPositie() == 63) {
                                    winnerGans++;
                                    System.out.println(
                                            "FEEEEEEEST! " + SpelerToevoegen.getNaam() + ", je hebt gewonnen :)");
                                }
                            }
                        } else {
                            SpelerToevoegen.exitOverslaan();
                        }
                    } else if ((SpelerToevoegen.getPut()) && (putPlayer != SpelerToevoegen.getNummer())) {
                        System.out.println(SpelerToevoegen.getNaam() + ", je bent uit de put GOOS!! :):):) ");
                        SpelerToevoegen.exitPut();
                    } else {
                        System.out.println(SpelerToevoegen.getNaam() + ", je zit nog steeds in de put:( ");
                    }
                } else if (SpelerToevoegen.getGevangenisNummer() > 0) {
                    SpelerToevoegen.minGevangenisNummer();
                    int spelerGevangenisNummer = SpelerToevoegen.getGevangenisNummer() + 1;
                    System.out.println(SpelerToevoegen.getNaam() + ", je moet nog " + spelerGevangenisNummer
                            + " beurten in de bak zitten :( ");
                } else {
                    SpelerToevoegen.exitGevangenis();
                    System.out.println(SpelerToevoegen.getNaam() + ", je bent eindelijk uit de bak!");
                }
            });
        }
        reader.close();
    }
}

// exit

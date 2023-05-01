package pckg;

import java.util.Scanner;

public class ConsoleInputCheck {

  public static int readNumberInputFromConsole(Scanner sc) {
    int cislo = 0;
    try {
      cislo = sc.nextInt();
    } catch (Exception e) {
      System.out.println("Zly vstup, zadajte prosim cele cislo ");
      sc.nextLine();
      cislo = readNumberInputFromConsole(sc);
    }
    return cislo;
  }

}

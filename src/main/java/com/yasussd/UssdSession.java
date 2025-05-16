package com.yasussd;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class UssdSession {
    private final Scanner scanner = new Scanner(System.in);
    private Timer timer;

    public void start() {
        System.out.println("exemple Acoount :  solde : 10000, code secret 1234");
        System.out.println("#111#");
        showMainMenu();
    }

    private void showMainMenu() {
        boolean running = true;

        while (running) {
            resetTimer();

            System.out.println("\n------ YAS et MOI ------");
            System.out.println("1- MVOLA");
            System.out.println("2- Rappelle moi");
            System.out.println("3- SOS crédit");
            System.out.println("4- Service YAS");
            System.out.println("5- Promotion");
            System.out.println("6- Produits et Divertissement");
            System.out.println("7- Banques et Micro-finances");
            System.out.println("-----------------------------");
            System.out.print("Annuler.                                                Envoyer\n> ");

            String input = scanner.nextLine().trim();
            cancelTimer();

            if (input.equalsIgnoreCase("Annuler")) {
                System.out.println("Session annulée. Merci !");
                running = false;
            } else {
                MenuHandler.handleMainMenu(input);
                System.out.println("\n(Tapez '1' pour quitter ou appuyez sur Entrée pour revenir au menu principal)");
                String next = scanner.nextLine().trim();
                if (next.equalsIgnoreCase("1")) {
                    running = false;
                }
            }
        }

        System.out.println("Fin de session.");
    }

    private void resetTimer() {
        cancelTimer();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\nSession expirée après 20 secondes d'inactivité.");
                System.exit(0);
            }
        }, 20000);
    }

    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }
}

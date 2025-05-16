package com.yasussd;

import java.util.Scanner;

public class MenuHandler {

    private static final Scanner scanner = new Scanner(System.in);
    private static final AccountUser user = new AccountUser(10000, "1234");

    public static void handleMainMenu(String input) {
        switch (input) {
            case "1" -> showMvolaMenu();
            case "2" -> showRappelMenu();
            case "3" -> showSosMenu();
            case "4" -> showServiceYas();
            case "5" -> showPromotionMenu();
            case "6", "7" -> System.out.println("Fonctionnalité pas encore disponible.");
            default -> System.out.println("Choix invalide.");
        }

        System.out.println("\n--- Retour au menu principal ---");
    }

    private static void showMvolaMenu() {
        System.out.println("\n--- Menu Mvola ---");
        System.out.println("1- Acheter Crédit ou Offre YAS");
        System.out.println("2- Transfer argent (Vers Toute destination)");
        System.out.println("3- Mvola crédit ou Epargne");
        System.out.println("4- Retrait d'argent");

        System.out.print("\n> ");
        String input = scanner.nextLine().trim();

        switch (input) {
            case "1" -> showCreditOfferMenu();
            case "2", "3", "4" -> System.out.println("Fonctionnalité en cours de développement.");
            default -> System.out.println("Choix invalide.");
        }
    }

    private static void showCreditOfferMenu() {
        while (true) {
            System.out.println("\n--- Acheter crédit ou Offre YAS ---");
            System.out.println("1- Crédit pour mon numéro");
            System.out.println("2- Crédit pour autre numéro");
            System.out.println("3- Offre pour mon numéro");
            System.out.println("4- Offre pour autre numéro");
            System.out.println("0- Retour");

            System.out.print("\n> ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> acheterCreditPourMoi();
                case "2" -> acheterCreditPourAutreNumero();
                case "3" -> System.out.println("Offres pour votre numéro : Fonctionnalité en développement.");
                case "4" -> {
                    System.out.print("Entrez le numéro du destinataire : ");
                    String numero = scanner.nextLine().trim();
                    System.out.println("Fonctionnalité pour le numéro " + numero + " en développement.");
                }
                case "0" -> {
                    return; // Retour au menu précédent
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    private static void acheterCreditPourMoi() {
        try {
            System.out.print("Entrez le montant du crédit à acheter (en Ariary) : ");
            int montant = Integer.parseInt(scanner.nextLine().trim());

            if (montant <= 0) {
                System.out.println("Le montant doit être supérieur à zéro.");
                return;
            }

            System.out.print("Entrez votre code secret : ");
            String code = scanner.nextLine().trim();

            if (!user.verifierCode(code)) {
                System.out.println("Code secret incorrect !");
                return;
            }

            if (user.debiter(montant)) {
                System.out.println("Crédit acheté avec succès !");
                System.out.println("Nouveau solde : " + user.getSolde() + " Ar");
            } else {
                System.out.println("Solde insuffisant !");
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");
        }
    }

    private static void acheterCreditPourAutreNumero() {
        System.out.print("Entrez le numéro du destinataire : ");
        String numero = scanner.nextLine().trim();

        try {
            System.out.print("Entrez le montant du crédit à envoyer (en Ariary) : ");
            int montant = Integer.parseInt(scanner.nextLine().trim());

            if (montant <= 0) {
                System.out.println("Le montant doit être supérieur à zéro.");
                return;
            }

            System.out.print("Entrez votre code secret : ");
            String code = scanner.nextLine().trim();

            if (!user.verifierCode(code)) {
                System.out.println("Code secret incorrect !");
                return;
            }

            if (user.debiter(montant)) {
                System.out.println("Crédit de " + montant + " Ar envoyé avec succès à " + numero + " !");
                System.out.println("Nouveau solde : " + user.getSolde() + " Ar");
            } else {
                System.out.println("Solde insuffisant !");
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");
        }
    }

    private static void showRappelMenu() {
        System.out.println("\n--- Menu Rappel ---");
        System.out.println("1- Envoyer un rappelle moi");
        System.out.println("2- Aide");
    }

    private static void showSosMenu() {
        System.out.println("\n--- Menu SOS ---");
        System.out.println("1- sos crédit à un ami");
        System.out.println("2- sos crédit à YAS");
        System.out.println("3- sos offre à Yas");
        System.out.println("4- Rembourser sos");
        System.out.println("5- Aide");
    }

    private static void showServiceYas() {
        System.out.println("\n--- Services Yas ---");
        System.out.println("1- Info Crédit");
        System.out.println("2- Recharge");
        System.out.println("3- Gérer Friends and Family");
        System.out.println("4- Envoyer Crédit/offre/Méga");
        System.out.println("5- Ajouter des jours de validité");
        System.out.println("6- Acheter une offre");
    }

    private static void showPromotionMenu() {
        System.out.println("\n--- Menu Promotion ---");
        System.out.println("1- Mvola");
        System.out.println("2- Mora (Voix-SMS-Internet)");
        System.out.println("3- First (Voix-SMS-Internet)");
        System.out.println("4- Yelow (SMS-Internet)");
        System.out.println("5- Yas Net (Internet)");
        System.out.println("6- ROAMING (Data-SMS)");
    }
}

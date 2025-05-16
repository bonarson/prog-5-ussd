package com.yasussd;

public class AccountUser {
    private int solde;
    private final String codeSecret;

    public AccountUser(int soldeInitial, String codeSecret) {
        this.solde = soldeInitial;
        this.codeSecret = codeSecret;
    }

    public int getSolde() {
        return solde;
    }

    public boolean verifierCode(String code) {
        return this.codeSecret.equals(code);
    }

    public boolean debiter(int montant) {
        if (montant <= solde) {
            solde -= montant;
            return true;
        } else {
            return false;
        }
    }
}

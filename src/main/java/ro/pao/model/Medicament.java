package ro.pao.model;

public record Medicament(String nume, String producator, double pret, int stoc) {
    public static Medicament builder() {
        return null;
    }
}

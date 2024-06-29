class Land {
    private String naam;
    private boolean veilig;

    public Land(String naam, boolean veilig) {
        this.naam = naam;
        this.veilig = veilig;
    }

    public String getNaam() {
        return naam;
    }

    public boolean isVeilig() {
        return veilig;
    }
}
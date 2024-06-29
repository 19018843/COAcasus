public class Dossier {

    private boolean asielaanvraagAfgerond;
    private String uitspraakIND;
    private boolean plaatsingEigenWoning;
    private boolean teruggekeerdNaarLandVanHerkomst;

    public Dossier(boolean asielaanvraagAfgerond, String uitspraakIND, boolean plaatsingEigenWoning, boolean teruggekeerdNaarLandVanHerkomst) {
        this.asielaanvraagAfgerond = asielaanvraagAfgerond;
        setUitspraakIND(uitspraakIND);
        this.plaatsingEigenWoning = plaatsingEigenWoning;
        this.teruggekeerdNaarLandVanHerkomst = teruggekeerdNaarLandVanHerkomst;
    }

    public boolean isAsielaanvraagAfgerond() {
        return asielaanvraagAfgerond;
    }
    public boolean isInEigenWoning() {
        return plaatsingEigenWoning;
    }

    public boolean isTeruggekeerdNaarHerkomstland() {
        return teruggekeerdNaarLandVanHerkomst;
    }

    public void setTeruggekeerdNaarHerkomstland(boolean teruggekeerd) {
        this.teruggekeerdNaarLandVanHerkomst = teruggekeerd;
    }
    public String getUitspraakIND() {
        return uitspraakIND;
    }

    public void setUitspraakIND(String uitspraakIND) {
        if (uitspraakIND == null || uitspraakIND.isEmpty()) {
            System.out.println("Ongeldige uitspraakIND: mag niet null of leeg zijn.");
        } else if (uitspraakIND.equals("geen")) {
            this.uitspraakIND = uitspraakIND;
        } else if (uitspraakIND.equals("verblijfsvergunning")) {
            this.uitspraakIND = uitspraakIND;
        } else if (uitspraakIND.equals("aanvraag afgewezen")) {
            this.uitspraakIND = uitspraakIND;
        } else {
            System.out.println("Ongeldige uitspraakIND: " + uitspraakIND);
        }
    }

    public static String getDossierStatus(boolean asielaanvraagAfgerond, String uitspraakIND, boolean plaatsingEigenWoning, boolean terugkeerLandHerkomst) {
        if (asielaanvraagAfgerond) {
            if (uitspraakIND.equals("geen")) {
                if (plaatsingEigenWoning && terugkeerLandHerkomst) {
                    return "geplaatst";
                }
            } else if (uitspraakIND.equals("verblijfsvergunning")) {
                if (plaatsingEigenWoning && terugkeerLandHerkomst) {
                    return "geplaatst";
                }
            } else if (uitspraakIND.equals("gestart")) {
                if (plaatsingEigenWoning && terugkeerLandHerkomst) {
                    return "in procedure";
                }
            }
        } else {
            if (uitspraakIND.equals("geen") || uitspraakIND.equals("gestart")) {
                if (!plaatsingEigenWoning && !terugkeerLandHerkomst) {
                    return "geen asiel";
                }
            } else if (uitspraakIND.equals("verblijfsvergunning")) {
                if (!plaatsingEigenWoning && !terugkeerLandHerkomst) {
                    return "verblijfsvergunning";
                }
            }
        }
        return "onbekend";
    }

}


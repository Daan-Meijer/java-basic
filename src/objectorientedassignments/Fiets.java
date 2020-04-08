package objectorientedassignments;

public class Fiets extends Voertuig {
    private String merk;
    private String kleur;

    public Fiets(String merk, String kleur) {
        super(merk, kleur);
    }

    public String getMerk() {
        return merk;
    }

    public String getKleur() {
        return kleur;
    }

    @Override
    public void bewegen() {
        snelheid += 1;
    }

    @Override
    public void remmen() {
        snelheid -= 1;
    }
}

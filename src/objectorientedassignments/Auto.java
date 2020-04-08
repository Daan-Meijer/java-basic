package objectorientedassignments;

public class Auto extends Voertuig{


    public Auto(String merk, String kleur) {
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
        snelheid += 10;
    }

    @Override
    public void remmen() {
        snelheid -= 10;
    }
}

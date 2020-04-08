package objectorientedassignments;

public class Boot extends Voertuig {
    public Boot(String merk, String kleur) {
        super(merk, kleur);
    }

    @Override
    public void bewegen() {
        snelheid += 3;
    }

    @Override
    public void remmen() {
        snelheid -= 3;
    }
}

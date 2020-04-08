package objectorientedassignments;

public class VrachtAuto extends Auto {

    int laadVermogen;

    public int getLaadVermogen() {
        return laadVermogen;
    }

    public void setLaadVermogen(int laadVermogen) {
        this.laadVermogen = laadVermogen;
    }

    public VrachtAuto(String merk, String kleur) {
        super(merk, kleur);
    }

    @Override
    public void bewegen() {
        snelheid += 5;
    }

    @Override
    public void remmen() {
        snelheid -= 5;
    }
}

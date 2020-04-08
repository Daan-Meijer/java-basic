package objectorientedassignments;

abstract class Voertuig implements Aandrijving {
    protected String merk;
    protected String kleur;
    protected int snelheid;

    public Voertuig(String merk, String kleur) {
        this.merk = merk;
        this.kleur = kleur;
    }

    @Override
    public String toString() {
        return "Voertuig{" +
                "snelheid=" + snelheid +
                '}';
    }
}

package objectorientedassignments;

public class Main {
    public static void main (String[] args){
        Auto auto = new Auto("Tesla", "rood");

        Auto zijnauto = new Auto("Suzuki", "grijs");

        VrachtAuto truck1 = new VrachtAuto("Volvo", "blauw");
        truck1.setLaadVermogen(1000);

        RaceAuto mijnTweedeAuto = new RaceAuto("Ferrari", "rood");
        mijnTweedeAuto.setTopSnelheid(300);

        Fiets mijnFiets = new Fiets("VanMook", "grijs");

        Boot imOnABoat = new Boot("Oceanfast", "wit");

        mijnFiets.bewegen();
        imOnABoat.bewegen();
        auto.bewegen();
        auto.remmen();

        for (int i=0; i<3; i++){
            zijnauto.bewegen();
        }

        System.out.println(auto.toString());
        System.out.println(zijnauto.toString());
        System.out.println(mijnFiets.toString());
        System.out.println(imOnABoat.toString());
        System.out.println(truck1.getLaadVermogen());
    }
}

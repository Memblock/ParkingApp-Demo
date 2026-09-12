import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int menuSelection = 0;
    public static ArrayList<Vehicle> parkedVehicles = new ArrayList<Vehicle>();

    public static void main(String[] args) {
        System.out.println("PARKING SYSTEM");
        System.out.println();
        while(menuSelection != 5) {

            Menu();
            menuSelection = InputReader.readInt("Ange menyval:");
            System.out.println(menuSelection);

            switch(menuSelection)
            {
                case 1:
                    ParkVehicle();
                    break;
                case 2:
                    ShowParkedVehicles();
                    break;
                case 3:
                    //SearchVehicle();
                    break;
                case 4:
                    //RemoveVehicle();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void Menu() {
        System.out.println("1. Parkera ett fordon");
        System.out.println("2. Visa parkerade fordon");
        System.out.println("3. Sök efter ett fordon");
        System.out.println("4. Ta bort ett fordon");
        System.out.println("5. Avsluta");
    }

    public static void ParkVehicle() {
        Vehicle vehicle = new Vehicle();
        while(vehicle.type == Vehicle.vehicleType.UNDEFINED) {
            menuSelection = 0;
            menuSelection = InputReader.readInt("Fordonstyp? (1. BIL 2. MOTORCYKEL)");
            if(menuSelection == 1)
            {
                vehicle.type = Vehicle.vehicleType.CAR;
            }
            if(menuSelection == 2)
            {
                vehicle.type = Vehicle.vehicleType.MOTORCYCLE;
            }
        }
        vehicle.licensePlate = InputReader.readString("Regnummer?");

        while(!vehicle.setParkingHours(InputReader.readInt("Parkeringstid? (Ange hela timmar)")))
        {

        }
        int fee = vehicle.DetermineParkingFee();
        int total = vehicle.getParkingHours() * fee;
        int temp = InputReader.readInt("Parkeringen kostar " + total + ". Ange belopp att betala:");

        if(temp >= total)
        {
            vehicle.feePaid = temp;
            vehicle.isParkingFeePaid = true;
            parkedVehicles.add(vehicle);
            System.out.println("Fordonet registrerat som parkerat!");
            //Check if the customer is due any change.
            if(vehicle.feePaid > total)
            {
                int returnMoney = vehicle.feePaid - total;
                System.out.println("Du får tillbaka " + returnMoney + " kr");
            }
        } else {
            System.out.println("Fordonet kunde inte parkeras pga inte tillräcklig p-avgift. Du har inte debiterats.");
        }

    }

    public static void ShowParkedVehicles()
    {
        for(Vehicle vehicle : parkedVehicles)
        {
            System.out.printf("%s - %s - %d timmar - %b - %d kr\n",vehicle.licensePlate, vehicle.type, vehicle.getParkingHours(), vehicle.isParkingFeePaid, vehicle.feePaid);
        }
    }
}

class Vehicle {
    public enum vehicleType {
        CAR, MOTORCYCLE, UNDEFINED
    }

    public String licensePlate;
    public vehicleType type;
    public int parkingHours;
    public int feePaid;
    boolean isParkingFeePaid;

    Vehicle() {
        licensePlate = "AAA123";
        type = vehicleType.UNDEFINED;
        parkingHours = 0;
        feePaid = 0;
        isParkingFeePaid = false;
    }

    boolean setParkingHours(int time) {
        if (time > 0 && time < 25) {
            parkingHours = time;
            return true;
        } else {
            System.out.println("Ogiltig parkeringstid");
            return false;
        }
    }
    int getParkingHours() {
        return parkingHours;
    }

    int DetermineParkingFee() {
        if(type == vehicleType.CAR)
        {
            return 20;
        }
        if(type == vehicleType.MOTORCYCLE)
        {
            return 10;
        } else {
            return 0;
        }

    }


}


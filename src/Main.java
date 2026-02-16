public class Main {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();

        machine.selectItem("Soda");
        machine.insertCoin(1.0);
        machine.insertCoin(1.0);

        System.out.println();

        machine.selectItem("Chips");
        machine.insertCoin(2.0);

        System.out.println();

        machine.setOutOfOrder();
        machine.selectItem("Candy");
    }
}
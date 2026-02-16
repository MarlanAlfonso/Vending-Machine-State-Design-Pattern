public class ItemSelectedState implements VendingMachineState {

    private static final double ITEM_PRICE = 2.0;

    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Item already selected.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {

        machine.addBalance(amount);
        System.out.println("Inserted: $" + amount);

        if (machine.getBalance() >= ITEM_PRICE) {
            machine.setState(new DispensingState());
            machine.dispenseItem();
        }
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Insert enough money first.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
        System.out.println("Machine is now out of order.");
    }
}
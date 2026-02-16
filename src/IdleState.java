public class IdleState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {

        if (!machine.getInventory().containsKey(item) ||
            machine.getInventory().get(item) == 0) {

            System.out.println("Item unavailable.");
            return;
        }

        machine.setSelectedItem(item);
        machine.setState(new ItemSelectedState());

        System.out.println("Item selected: " + item);
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("No item selected.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
        System.out.println("Machine is now out of order.");
    }
}
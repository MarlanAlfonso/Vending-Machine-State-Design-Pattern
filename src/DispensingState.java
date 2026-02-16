public class DispensingState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Dispensing in progress...");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Dispensing in progress...");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {

        String item = machine.getSelectedItem();
        int count = machine.getInventory().get(item);

        machine.getInventory().put(item, count - 1);

        System.out.println("Dispensed: " + item);

        machine.resetBalance();
        machine.setSelectedItem(null);

        machine.setState(new IdleState());
        System.out.println("Machine returned to Idle state.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
        System.out.println("Machine is now out of order.");
    }
}
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private VendingMachineState currentState;
    private Map<String, Integer> inventory;
    private double balance;
    private String selectedItem;

    public VendingMachine() {
        inventory = new HashMap<>();
        inventory.put("Soda", 5);
        inventory.put("Chips", 5);
        inventory.put("Candy", 5);

        balance = 0;
        currentState = new IdleState();
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getState() {
        return currentState;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void resetBalance() {
        balance = 0;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String item) {
        selectedItem = item;
    }

    // Delegated actions

    public void selectItem(String item) {
        currentState.selectItem(this, item);
    }

    public void insertCoin(double amount) {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder(this);
    }
}
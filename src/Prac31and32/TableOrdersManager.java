package Prac31and32;

public class TableOrdersManager implements OrdersManager {
    private MyLinkedList<Order> orders = new MyLinkedList<Order>(new TableOrderListStart());
    private int tablesCount = 10;
    private  boolean[] occupiedTable = new boolean[tablesCount];

    public void add(Order order, int tableNumber) {
        if(tableNumber < 1 || tableNumber > tablesCount) {
            throw new IllegalArgumentException("Table number is out of range");
        }
        if(occupiedTable[tableNumber - 1]) {
            throw new IllegalArgumentException("Table number " + tableNumber + " is already in use");
        }
        if (order instanceof TableOrder) {
            ((TableOrder) order).setTableNumber(tableNumber);
            orders.add(order);
            occupiedTable[tableNumber - 1] = true;
        } else {
            throw new IllegalArgumentException("Order is not a table order");
        }
    }

    public void addItem(Item item, int tableNumber) {
        if(tableNumber < 1 || tableNumber > tablesCount) {
            throw new IllegalArgumentException("Table number is out of range");
        }
        if(!occupiedTable[tableNumber - 1]) {
            throw new IllegalArgumentException("Table number " + tableNumber + " is not in use");
        }
        MyLinkedList<Order> temp = orders.getNext();
        while (temp != orders) {
            if (temp.getData() instanceof TableOrder) {
                if (((TableOrder) temp.getData()).getTableNumber() == tableNumber) {
                    temp.getData().add(item);
                    return;
                }
            }
            temp = temp.getNext();
        }
    }

    public int freeTableNumber() {
        for (int i = 0; i < tablesCount; i++) {
            if (!occupiedTable[i]) {
                return i;
            }
        }
        return -1;
    }

    public int[] freeTableNumbers() {
        int[] freeTables = new int[tablesCount];
        int count = 0;
        for (int i = 0; i < tablesCount; i++) {
            if (!occupiedTable[i]) {
                freeTables[count] = i;
                count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = freeTables[i];
        }
        return result;
    }

    public int itemsQuantity(String name) {
        int quantity = 0;
        MyLinkedList<Order> temp = orders;
        while (temp.getNext() != orders) {
            temp = temp.getNext();
            quantity += temp.getData().itemsQuantity(name);
        }
        return quantity;
    }

    public int itemsQuantity(Item item) {
        int quantity = 0;
        MyLinkedList<Order> temp = orders;
        while (temp.getNext() != orders) {
            temp = temp.getNext();
            quantity += temp.getData().itemsQuantity(item);
        }
        return quantity;
    }

    public Order[] getOrders() {
        Order[] ordersArray = new Order[ordersQuantity()];
        MyLinkedList<Order> temp = orders;
        for (int i = 0; i < ordersQuantity(); i++) {
            temp = temp.getNext();
            ordersArray[i] = temp.getData();
        }
        return ordersArray;
    }

    public int ordersCostSummary() {
        int cost = 0;
        MyLinkedList<Order> temp = orders;
        while (temp.getNext() != orders) {
            temp = temp.getNext();
            cost += temp.getData().costTotal();
        }
        return cost;
    }

    public int ordersQuantity() {
        int quantity = 0;
        MyLinkedList<Order> temp = orders;
        while (temp.getNext() != orders) {
            temp = temp.getNext();
            quantity++;
        }
        return quantity;
    }

    public Order getOrder(int tableNumber) {
        if(tableNumber < 1 || tableNumber > tablesCount) {
            throw new IllegalArgumentException("Table number is out of range");
        }
        if(!occupiedTable[tableNumber - 1]) {
            throw new IllegalArgumentException("Table number " + tableNumber + " is not in use");
        }
        MyLinkedList<Order> temp = orders.getNext();
        while (temp != orders) {
            if (temp.getData() instanceof TableOrder) {
                if (((TableOrder) temp.getData()).getTableNumber() == tableNumber) {
                    return temp.getData();
                }
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void remove(int tableNumber) {
        if(tableNumber < 1 || tableNumber > tablesCount) {
            throw new IllegalArgumentException("Table number is out of range");
        }
        if(!occupiedTable[tableNumber - 1]) {
            throw new IllegalArgumentException("Table number " + tableNumber + " is not in use");
        }
        MyLinkedList<Order> temp = orders.getNext();
        while (temp != orders) {
            if (temp.getData() instanceof TableOrder) {
                if (((TableOrder) temp.getData()).getTableNumber() == tableNumber) {
                    temp.remove();
                    occupiedTable[tableNumber - 1] = false;
                    return;
                }
            }
            temp = temp.getNext();
        }
    }

    public void remove(Order order) {
        MyLinkedList<Order> temp = orders.getNext();
        while (temp != orders) {
            if (temp.getData() == order) {
                temp.remove();
                occupiedTable[((TableOrder) order).getTableNumber() - 1] = false;
                return;
            }
            temp = temp.getNext();
        }
    }

    public int removeAll(Order order){
        int count = 0;
        MyLinkedList<Order> temp = orders.getNext();
        while (temp != orders) {
            if (temp.getData() == order) {
                temp.remove();
                occupiedTable[((TableOrder) order).getTableNumber() - 1] = false;
                count++;
            }
            temp = temp.getNext();
        }
        return count;
    }
}

package Prac31and32;

public interface OrderManager {
    int itemsQuantity(String name);
    int itemsQuantity(Item item);
    Order[] getOrders();
    int ordersCostSummary();
    int ordersQuantity();
}

package Prac31and32;

public interface OrdersManager {
    int itemsQuantity(String name);
    int itemsQuantity(Item item);
    Order[] getOrders();
    int ordersCostSummary();
    int ordersQuantity();
}

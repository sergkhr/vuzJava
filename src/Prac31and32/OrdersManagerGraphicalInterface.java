package Prac31and32;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrdersManagerGraphicalInterface extends JFrame {
	private InternetOrderManager internetOrderManager = new InternetOrderManager();
	private TableOrderManager tableOrderManager = new TableOrderManager();
	private Address address = new Address();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private int currentCustomerIndex;

	private JPanel internetOrderManagerPanel = new JPanel();
	private JPanel tableOrderManagerPanel = new JPanel();
	private JPanel customerPanel = new JPanel();

	private JMenuBar menuBar = new JMenuBar();
	private JMenu orderMenu = new JMenu("Order");
	private JMenuItem orderItem = new JMenuItem("Internet Order");
	private JMenuItem orderItem2 = new JMenuItem("Table Order");
	private JMenuItem customerItem = new JMenuItem("Customer Info");
	private JMenuItem changeTableItem = new JMenuItem("Change My Table Pleeeeaaase!!!!!");

	private JLabel orderTypeLabel = new JLabel("Internet Order");
	private JButton createOrderButton = new JButton("Create Order");
	private JLabel totalOrdersLabel = new JLabel("Total Orders: ");
	private JTextArea orderListArea = new JTextArea(10, 20);
	private JScrollPane orderListPane = new JScrollPane(orderListArea);
	private JTextArea orderDetailsArea = new JTextArea(10, 20);
	private JScrollPane orderDetailsPane = new JScrollPane(orderDetailsArea);

	private JLabel customerNameLabel = new JLabel("Customer First Name");
	private JTextField customerNameField = new JTextField(20);
	private JLabel customerLastNameLabel = new JLabel("Customer Last Name");
	private JTextField customerLastNameField = new JTextField(20);
	private JLabel customerAgeLabel = new JLabel("Customer Age");
	private JTextField customerAgeField = new JTextField(20);
	private JLabel customerCityNameLabel = new JLabel("Customer City Name");
	private JTextField customerCityNameField = new JTextField(20);
	private JLabel customerZipCodeLabel = new JLabel("Customer Zip Code");
	private JTextField customerZipCodeField = new JTextField(20);
	private JLabel customerStreetNameLabel = new JLabel("Customer Street Name");
	private JTextField customerStreetNameField = new JTextField(20);
	private JLabel customerBuildingNumberLabel = new JLabel("Customer Building Number");
	private JTextField customerBuildingNumberField = new JTextField(20);
	private JLabel customerBuildingLetterLabel = new JLabel("Customer Building Letter");
	private JTextField customerBuildingLetterField = new JTextField(20);
	private JLabel customerApartmentNumberLabel = new JLabel("Customer Apartment Number");
	private JTextField customerApartmentNumberField = new JTextField(20);
	private JButton confirmCustomerInfoButton = new JButton("Confirm Customer Info");

	private JPanel topInternetOrderPanel = new JPanel();
	private JPanel topTableOrderPanel = new JPanel();
	private JPanel customerInfoPanel = new JPanel();
	private JLabel greetingLabel = new JLabel();
	private String orderType = "Internet Order";
	private Item selectedItem = null;
	private int currentTable = -1;

	private JPanel itemsPanel = new JPanel();
	private JLabel itemsLabel = new JLabel("Items");
	private JPanel buttonsWrapperPanel = new JPanel();
	private JButton addItemButton = new JButton("Add Item");
	private JButton removeItemButton = new JButton("Remove Item");
	private JButton makeOrderButton = new JButton("Make Order");
	private final int menuPositions = 5;
	private Item[] items = new Item[menuPositions];
	JLabel[] itemsLabels = new JLabel[menuPositions];
	JLabel selectedItemLabel = new JLabel("No item selected");


	private void updateInternetOrderManagerInfo(){
		totalOrdersLabel.setText("Total Orders: " + internetOrderManager.ordersQuantity());
		String orderList = "";
		Order[] orders = internetOrderManager.getOrders();
		for (int i = 0; i < internetOrderManager.ordersQuantity(); i++){
			orderList += orders[i].getCustomer().getFirstName() + " " + orders[i].getCustomer().getSecondName() + " from " + orders[i].getCustomer().getAddress().getCityName() + " " + orders[i].costTotal() + "\n";
		}
		orderListArea.setText(orderList);
	}

	private void updateTableOrderManagerInfo(){
		totalOrdersLabel.setText("Total Orders: " + tableOrderManager.ordersQuantity());
		String orderList = "";
		Order[] orders = tableOrderManager.getOrders();
		for (int i = 0; i < tableOrderManager.ordersQuantity(); i++){
			orderList += "Table: " + ((TableOrder)orders[i]).getTableNumber() + " " + orders[i].costTotal() + "\n";
		}
		orderListArea.setText(orderList);
	}

	private void updateInternetOrderInfo(){
		Order currentOrder = internetOrderManager.getOrder(customers.get(currentCustomerIndex));
		String orderDetails = "";
		if(currentOrder == null){
			orderDetailsArea.setText(orderDetails);
			return;
		}
		Item[] items = currentOrder.sortedItemsByCostDesc();
		for (int i = 0; i < items.length; i++){
			orderDetails += items[i].getName() + " " + items[i].getCost() + "\n";
		}
		orderDetailsArea.setText(orderDetails);
	}

	private void updateTableOrderInfo(){
		Order currentOrder = null;
		if(currentTable != -1){
			while(true){
				try{
					currentOrder = tableOrderManager.getOrder(currentTable);
					break;
				}catch (Exception exception){
					JOptionPane.showMessageDialog(this, exception.getMessage());
					currentTable = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter table number to see order on (-1 for none)"));
					if(currentTable == -1) break;
				}
			}
		}
		String orderDetails = "";
		if(currentOrder == null){
			orderDetailsArea.setText(orderDetails);
			return;
		}
		Item[] items = currentOrder.sortedItemsByCostDesc();
		for (int i = 0; i < items.length; i++){
			orderDetails += items[i].getName() + " " + items[i].getCost() + "\n";
		}
		orderDetailsArea.setText(orderDetails);
	}

	private void updateSelectedItem(){
		if (selectedItem != null){
			selectedItemLabel.setText("Selected item: " + selectedItem.toString());
		}
		else{
			selectedItemLabel.setText("No item selected");
		}
	}

	public OrdersManagerGraphicalInterface() {
		setSize(1216, 864);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(menuBar);
		menuBar.add(orderMenu);
		orderMenu.add(orderItem);
		orderMenu.add(orderItem2);
		orderMenu.add(customerItem);
		menuBar.add(changeTableItem);
		setCustomerInfoPage();

		add(customerPanel);

		//creating menu
		items[0] = new Drink("Coca-Cola", 100, "cola", 0, DrinkTypeEnum.SODA);
		items[1] = new Dish("Pizza", 500, "pizza Margarita");
		items[2] = new Dish("Burger", 300, "burger with cheese");
		items[3] = new Dish("Salad", 200, "salad with chicken");
		items[4] = new Drink("Beer", 200, "beer", 5, DrinkTypeEnum.BEER);
		itemsPanel.setLayout(new GridLayout(menuPositions+3, 1));
		itemsPanel.add(itemsLabel);
		for (int i = 0; i < menuPositions; i++) {
			itemsLabels[i] = new JLabel(items[i].getName() + " " + items[i].getCost());
			itemsLabels[i].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					for (int i = 0; i < menuPositions; i++) {
						if (evt.getSource() == itemsLabels[i]) {
							selectedItem = items[i];
							updateSelectedItem();
						}
					}
				}
			});
			itemsPanel.add(itemsLabels[i]);
		}
		itemsPanel.add(selectedItemLabel);
		buttonsWrapperPanel.setLayout(new GridLayout(1, 3));
		buttonsWrapperPanel.add(addItemButton);
		buttonsWrapperPanel.add(removeItemButton);
		buttonsWrapperPanel.add(makeOrderButton);
		itemsPanel.add(buttonsWrapperPanel);

		//creating customers
		customers.add(new Customer("PlaceHolder", "PlaceHolder", -1, address));
		currentCustomerIndex = 0;

		//internet order page
		orderItem.addActionListener(e -> {
			if(customers.get(currentCustomerIndex).getAge() == -1){
				JOptionPane.showMessageDialog(this, "Please create a customer first");
				return;
			}
			orderTypeLabel.setText("Internet Order");
			orderType = "Internet Order";
			setInternetOrderManagerPanel();
			add(internetOrderManagerPanel);
			remove(customerPanel);
			remove(tableOrderManagerPanel);

			updateInternetOrderManagerInfo();
			updateInternetOrderInfo();

			validate();
			repaint();
		});

		//table order page
		orderItem2.addActionListener(e -> {
			if(customers.get(currentCustomerIndex).getAge() == -1){
				JOptionPane.showMessageDialog(this, "Please create a customer first");
				return;
			}
			orderTypeLabel.setText("Table Order");
			orderType = "Table Order";
			setTableOrderManagerPanel();
			add(tableOrderManagerPanel);
			remove(customerPanel);
			remove(internetOrderManagerPanel);

			int tableNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter table number to see order on (-1 for none)"));
			currentTable = tableNumber;

			updateTableOrderManagerInfo();
			updateTableOrderInfo();

			validate();
			repaint();
		});

		//customer info
		customerItem.addActionListener(e -> {
			add(customerPanel);
			remove(internetOrderManagerPanel);
			remove(tableOrderManagerPanel);

			validate();
			repaint();
		});

		//customer info confirm
		confirmCustomerInfoButton.addActionListener(e -> {
			try{
				Customer tempCustomer = new Customer(customerNameField.getText(), customerLastNameField.getText(), Integer.parseInt(customerAgeField.getText()), new Address(customerCityNameField.getText(), Integer.parseInt(customerZipCodeField.getText()), customerStreetNameField.getText(), Integer.parseInt(customerBuildingNumberField.getText()), customerBuildingLetterField.getText().charAt(0), Integer.parseInt(customerApartmentNumberField.getText())));
				if(tempCustomer.getAge() < 0){
					JOptionPane.showMessageDialog(this, "Please enter a valid age");
					return;
				}
				for (int i = 0; i < customers.size(); i++){
					if (customers.get(i).equals(tempCustomer)){
						currentCustomerIndex = i;
						greetingLabel.setText("Hello, " + customers.get(currentCustomerIndex).getFirstName() + " " + customers.get(currentCustomerIndex).getSecondName() + "!");
						validate();
						repaint();
						return;
					}
				}
				customers.add(tempCustomer);
				currentCustomerIndex = customers.size()-1;
			} catch (Exception exception){
				JOptionPane.showMessageDialog(this, exception.getMessage());
			}

			greetingLabel.setText("Hello, " + customers.get(currentCustomerIndex).getFirstName() + " " + customers.get(currentCustomerIndex).getSecondName() + "!");
			validate();
			repaint();
		});

		//create order
		createOrderButton.addActionListener(e -> {
			if(orderType.equals("Internet Order")){
				try{
					internetOrderManager.add(customers.get(currentCustomerIndex), new InternetOrder(customers.get(currentCustomerIndex)));
				} catch (Exception exception){
					JOptionPane.showMessageDialog(this, exception.getMessage());
				}
				updateInternetOrderManagerInfo();
				updateInternetOrderInfo();
			}
			else if(orderType.equals("Table Order")){
				try{
					int[] freeTables = tableOrderManager.freeTableNumbers();
					String freeTablesString = "";
					for (int i = 0; i < freeTables.length; i++){
						freeTablesString += freeTables[i] + " ";
					}
					if(freeTablesString.equals("")){
						JOptionPane.showMessageDialog(this, "There are no free tables");
						return;
					}
					int tableNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter table number (free tables: " + freeTablesString + ")"));
					tableOrderManager.add(new TableOrder(20, tableNumber), tableNumber);
					currentTable = tableNumber;
				} catch (Exception exception){
					JOptionPane.showMessageDialog(this, exception.getMessage());
				}
				updateTableOrderManagerInfo();
				updateTableOrderInfo();
			}
		});

		//add item to order
		addItemButton.addActionListener(e -> {
			if(orderType.equals("Internet Order")){
				try{
					internetOrderManager.add(customers.get(currentCustomerIndex), selectedItem);
				} catch (Exception exception){
					JOptionPane.showMessageDialog(this, exception.getMessage());
				}
				updateInternetOrderInfo();
				updateInternetOrderManagerInfo();
			}
			else if(orderType.equals("Table Order")){
				try{
					tableOrderManager.add(selectedItem, currentTable);
				} catch (Exception exception){
					JOptionPane.showMessageDialog(this, exception.getMessage());
				}
				updateTableOrderInfo();
				updateTableOrderManagerInfo();
			}
		});

		//remove item from order
		removeItemButton.addActionListener(e -> {
			if(orderType.equals("Internet Order")){
				try{
					if(!internetOrderManager.getOrder(customers.get(currentCustomerIndex)).remove(selectedItem.getName())){
						JOptionPane.showMessageDialog(this, "Item not found");
					}
				} catch (Exception exception){
					JOptionPane.showMessageDialog(this, exception.getMessage());
				}
				updateInternetOrderInfo();
				updateInternetOrderManagerInfo();
			}
			else if(orderType.equals("Table Order")){
				try{
					if(!tableOrderManager.getOrder(currentTable).remove(selectedItem.getName())){
						JOptionPane.showMessageDialog(this, "Item not found");
					}
				} catch (Exception exception){
					JOptionPane.showMessageDialog(this, exception.getMessage());
				}
				updateTableOrderInfo();
				updateTableOrderManagerInfo();
			}
		});

		//make order
		makeOrderButton.addActionListener(e -> {
			if(orderType.equals("Internet Order")){
				int result = JOptionPane.showConfirmDialog(this, "Do you agree to your data processing?", "Data processing", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.NO_OPTION) return;
				boolean isAlcoholInOrder = false;
				Order currentOrder = internetOrderManager.getOrder(customers.get(currentCustomerIndex));
				Item[] items = currentOrder.getItems();
				for (int i = 0; i < items.length; i++){
					//check if item is a drink
					if(items[i] instanceof Drink){
						//check if drink is alcoholic
						if(((Drink) items[i]).isAlcoholicDrink()){
							isAlcoholInOrder = true;
							break;
						}
					}
				}
				if(isAlcoholInOrder){
					if(!customers.get(currentCustomerIndex).isMature()) {
						JOptionPane.showMessageDialog(this, "You are not mature enough to buy alcohol");
						return;
					}
				}
				if(currentOrder.isEmpty()){
					JOptionPane.showMessageDialog(this, "Order is empty");
					return;
				}
				//this is where what ever is the placing order means will be
				JOptionPane.showMessageDialog(this, "Order is placed, congrats!");
			}
			else if(orderType.equals("Table Order")){
				boolean isAlcoholInOrder = false;
				Order currentOrder = tableOrderManager.getOrder(currentTable);
				Item[] items = currentOrder.getItems();
				for (int i = 0; i < items.length; i++){
					//check if item is a drink
					if(items[i] instanceof Drink){
						//check if drink is alcoholic
						if(((Drink) items[i]).isAlcoholicDrink()){
							isAlcoholInOrder = true;
							break;
						}
					}
				}
				if(isAlcoholInOrder){
					if(!customers.get(currentCustomerIndex).isMature()) {
						JOptionPane.showMessageDialog(this, "You are not mature enough to buy alcohol");
						return;
					}
				}
				if(currentOrder.isEmpty()){
					JOptionPane.showMessageDialog(this, "Order is empty");
					return;
				}
				//this is where what ever is the placing order means will be
				JOptionPane.showMessageDialog(this, "Order is placed, congrats!");
			}
		});

		//change table
		changeTableItem.addActionListener(e -> {
			if(orderType.equals("Table Order")){
				try{ //try catch for nothing s* it
					int newTableNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter new table number (-1 for none)"));
					currentTable = newTableNumber;
				} catch (Exception exception){
					JOptionPane.showMessageDialog(this, exception.getMessage());
				}
				updateTableOrderInfo();
				updateTableOrderManagerInfo();
			}
		});
	}

	private void setCustomerInfoPage(){
		customerPanel.setLayout(new BorderLayout());
		greetingLabel.setText("Welcome to the Order Manager, pick an order type from the menu bar, but first, set up customer details");
		customerPanel.add(greetingLabel, BorderLayout.NORTH);
		customerInfoPanel.setLayout(new GridLayout(9, 2));
		customerInfoPanel.add(customerNameLabel);
		customerInfoPanel.add(customerNameField);
		customerInfoPanel.add(customerLastNameLabel);
		customerInfoPanel.add(customerLastNameField);
		customerInfoPanel.add(customerAgeLabel);
		customerInfoPanel.add(customerAgeField);
		customerInfoPanel.add(customerCityNameLabel);
		customerInfoPanel.add(customerCityNameField);
		customerInfoPanel.add(customerZipCodeLabel);
		customerInfoPanel.add(customerZipCodeField);
		customerInfoPanel.add(customerStreetNameLabel);
		customerInfoPanel.add(customerStreetNameField);
		customerInfoPanel.add(customerBuildingNumberLabel);
		customerInfoPanel.add(customerBuildingNumberField);
		customerInfoPanel.add(customerBuildingLetterLabel);
		customerInfoPanel.add(customerBuildingLetterField);
		customerInfoPanel.add(customerApartmentNumberLabel);
		customerInfoPanel.add(customerApartmentNumberField);
		customerPanel.add(customerInfoPanel, BorderLayout.CENTER);
		customerPanel.add(confirmCustomerInfoButton, BorderLayout.SOUTH);
	}

	private void setInternetOrderManagerPanel(){
		unsetTableOrderManagerPanel();
		internetOrderManagerPanel.setLayout(new BorderLayout());
		topInternetOrderPanel.setLayout(new GridLayout(1, 3));
		topInternetOrderPanel.add(orderTypeLabel);
		topInternetOrderPanel.add(createOrderButton);
		topInternetOrderPanel.add(totalOrdersLabel);
		internetOrderManagerPanel.add(topInternetOrderPanel, BorderLayout.NORTH);
		internetOrderManagerPanel.add(orderListPane, BorderLayout.WEST);
		internetOrderManagerPanel.add(orderDetailsPane, BorderLayout.EAST);
		internetOrderManagerPanel.add(itemsPanel, BorderLayout.CENTER);
	}
	private void unsetInternetOrderManagerPanel(){
		internetOrderManagerPanel.removeAll();
		topInternetOrderPanel.removeAll();
	}

	private void setTableOrderManagerPanel(){
		unsetInternetOrderManagerPanel();
		tableOrderManagerPanel.setLayout(new BorderLayout());
		topTableOrderPanel.setLayout(new GridLayout(1, 3));
		topTableOrderPanel.add(orderTypeLabel);
		topTableOrderPanel.add(createOrderButton);
		topTableOrderPanel.add(totalOrdersLabel);
		tableOrderManagerPanel.add(topTableOrderPanel, BorderLayout.NORTH);
		tableOrderManagerPanel.add(orderListPane, BorderLayout.WEST);
		tableOrderManagerPanel.add(orderDetailsPane, BorderLayout.EAST);
		tableOrderManagerPanel.add(itemsPanel, BorderLayout.CENTER);
	}
	private void unsetTableOrderManagerPanel(){
		tableOrderManagerPanel.removeAll();
		topTableOrderPanel.removeAll();
	}

	public static void main(String[] args) {
		OrdersManagerGraphicalInterface gui = new OrdersManagerGraphicalInterface();
		gui.setVisible(true);
	}
}

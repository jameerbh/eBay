package dataObjects;

public class Cart {
public int numberOfItems;

public int getNumberOfItems() {
	return numberOfItems;
}

public void setNumberOfItems(int numberOfItems) {
	this.numberOfItems = numberOfItems;
}

public Cart(int numberOfItems) {
	super();
	this.numberOfItems = numberOfItems;
}
}

package entities;

/**
 * Created by bernie on 3/19/2015.
 */
public class Product {
    private long ProductID;
    private String ProductName;

    public Product(String productName) {
        ProductID = 0;
        ProductName = productName;
    }

    public Product(Product old) {
        ProductID = old.ProductID;
        ProductName = old.ProductName;
    }

    public long getProductID() {
        return ProductID;
    }

    public void setProductID(long productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    @Override
    public String toString()
    {
        return ProductName;
    }
}

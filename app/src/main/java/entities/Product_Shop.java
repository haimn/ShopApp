package entities;

public class Product_Shop {
    private int ProductCostInShop;
    private long ShopID;
    private int ProductID;

    public Product_Shop(int productCostInShop, long shopID, int productID) {
        ProductCostInShop = productCostInShop;
        ShopID = shopID;
        ProductID = productID;

    }

    public Product_Shop(Product_Shop old) {
        ProductCostInShop = old.ProductCostInShop;
        ShopID = old.ProductCostInShop;
        ProductID = old.ProductCostInShop;
    }

    public int getProductCostInShop() {
        return ProductCostInShop;
    }

    public void setProductCostInShop(int productCostInShop) {
        ProductCostInShop = productCostInShop;
    }

    public long getShopID() {
        return ShopID;
    }

    public void setShopID(long shopID) {
        ShopID = shopID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }
}

package model.backend;
import java.util.ArrayList;
import entities.Opinion;
import entities.Product;
import entities.Product_Shop;
import entities.Shop;
public interface Backend {
    public void addShop (Shop shop) throws Exception;
    public void addProduct (Product product) throws Exception;
    public void addProductToShop (Product_Shop product_shop) throws Exception;
    public void addOpinion (Opinion opinion) throws Exception;
    public void deleteShop (long shopID) throws Exception;
    public void deleteProduct (long productID) throws Exception;
    public void deleteOpinion (long opinionID) throws Exception;
    public void updateShop (Shop shop) throws Exception;
    public void updateProductInShop (Product_Shop product_shop) throws Exception;
    public void updateOpinion (Opinion opinion) throws Exception;
    public void updateProduct (Product product) throws Exception;
    public ArrayList<Product> getProductList () throws Exception;
    public ArrayList<Shop> getShopByProductID (long productID) throws Exception;
    public ArrayList<Opinion> getOpinionByProductID (long productID) throws Exception;
    public Product_Shop getConectorByShopAndProductID(long productID , long shopID)
    throws Exception;
}
package model.datasource;

import android.content.Context;

import com.example.bernie.shopapp.R;

import java.util.ArrayList;
import entities.Opinion;
import entities.Product;
import entities.Product_Shop;
import entities.Shop;
import model.backend.Backend;

public class DatabaseList implements Backend {
//test
    private Context context;

    public DatabaseList(Context current){
        this.context = current;
        //*************************************************************
        try {
            addProduct(new Product("Apple"));
            addProduct(new Product("Orange"));
            addProduct(new Product("AAAAA"));
            addProduct(new Product("DDDDD"));
            addProduct(new Product("FFFFF"));
            addProduct(new Product("VVVVVV"));
            addProduct(new Product("EEEEEE"));
            addProduct(new Product("HHHHH"));
            addProduct(new Product("RRRRRR"));
            addProduct(new Product("VVVVVV"));
            addProduct(new Product("QQQQQQ"));
            addProduct(new Product("WWWWWW"));
            addProduct(new Product("NNNNNN"));
            addProduct(new Product("BBBBBB"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        //**************************************************************
    }

    ArrayList<Shop>shops = new ArrayList<Shop>();
    ArrayList<Product>products = new ArrayList<Product>();
    ArrayList<Product_Shop>conectors = new ArrayList<Product_Shop>();
    ArrayList<Opinion>opinions = new ArrayList<Opinion>();

    int ProductCounter = 0;
    int ShopCounter = 0;
    int OpinionCounter = 0;

    @Override
    public void addShop(Shop shop1) throws Exception {
        Shop shop = new Shop(shop1);
        for (Shop shopItem : shops)
            if (shopItem.equals(shop))
                throw new Exception(context.getString(R.string.shop_exist));

        shop.setShopID(ShopCounter++);
        shops.add(shop);
    }
    @Override
    public void addProduct(Product product1) throws Exception {
        Product product = new Product(product1);
        for (Product productItem : products)
            if (productItem.equals(product))
                throw new Exception(context.getString(R.string.product_exist_in_database));

        product.setProductID(ProductCounter++);
        products.add(product);
    }

    @Override
    public void addProductToShop(Product_Shop product_shop1) throws Exception {
        Product_Shop product_shop = new Product_Shop(product_shop1);
        for (Product_Shop product_shopItem : conectors)
            if (product_shopItem.equals(product_shop))
                throw new Exception(context.getString(R.string.product_exist_in_shop));
        conectors.add(product_shop);
    }

    @Override
    public void addOpinion(Opinion opinion1) throws Exception {
        Opinion opinion = new Opinion (opinion1);
        for (Opinion opinionItem : opinions)
            if (opinionItem.equals(opinion))
                throw new Exception("חוות דעת זו קיימת כבר במאגר הנתונים!");

        opinion.setOpinionID(OpinionCounter++);
        opinions.add(opinion);
    }
    @Override
    public void deleteShop(long shopID) throws Exception {

        deleteConectorByShop(shopID);

        for (Shop shopItem : shops)
            if (shopItem.getShopID() == shopID) {
                shops.remove(shopItem);
                return;
            }
        throw new Exception("חנות למחיקה , לא נמצאה.");
    }
    @Override
    public void updateProductInShop(Product_Shop product_shop) throws Exception {
        for (Product_Shop product_shopItem : conectors) {
            if (product_shopItem.getShopID() == product_shop.getShopID()
                    && product_shopItem.getProductID() == product_shop.getProductID()) {
                product_shopItem.setProductCostInShop(product_shop.getProductCostInShop());
                return;
            }
        }
        throw new Exception(".לא ניתן לעדכן את מחירה מוצר בחנות , ככל הנראה אין חנות בעלת מוצר כזה או שאין חנות כזו");
    }

    @Override
    public void updateOpinion(Opinion opinion) throws Exception {
        for (Opinion opinionItem : opinions) {
            if (opinionItem.getOpinionID() == opinion.getOpinionID()) {
                opinionItem.setProductOpinion(opinion.getProductOpinion());
                return;
            }
        }
        throw new Exception(".לא ניתן לעדכן את חוות הדעת הרצויה , ככל הנראה אין חוות דעת בעלת מזהה זה");
    }
    @Override
    public ArrayList<Product> getProductList() throws Exception {
        if (products.size() != 0)
            return products;
        else
            throw new Exception("רשימת המוצרים ריקה!");
    }

    @Override
    public ArrayList<Shop> getShopByProductID(long productID) throws Exception {
        ArrayList<Shop> ShopsByProductID = new ArrayList<Shop>();
        for (Product_Shop product_shopItem : conectors) {
            if (product_shopItem.getProductID() == productID) {
                for (Shop shopItem : shops) {
                    if (shopItem.getShopID() == product_shopItem.getShopID())
                        ShopsByProductID.add(shopItem);
                }
            }
        }
        if (ShopsByProductID.size() != 0)
            return ShopsByProductID;
        else
            throw new Exception("אין חנות המכילה מוצר כזה!");
    }

    @Override
    public ArrayList<Opinion> getOpinionByProductID(long productID)throws Exception {
        ArrayList<Opinion> OpinionByProductID = new ArrayList<Opinion>();
        for (Opinion opinionItem : opinions) {
            if (opinionItem.getProductID() == productID) {
                OpinionByProductID.add(opinionItem);
            }
        }
        if (OpinionByProductID.size() != 0)
            return OpinionByProductID;
        else
            throw new Exception("אין חוות דעת למוצר כזה!");
    }

    @Override
    public Product_Shop getConectorByShopAndProductID(long productID,long shopID) throws Exception {
        for (Product_Shop product_ShopItem : conectors) {
            if (product_ShopItem.getProductID() == productID
                    && product_ShopItem.getShopID() == shopID) {
                return product_ShopItem;
            }
        }
        throw new Exception("אין קשר בין חנות זו ומוצר זה!");
    }
    @Override
    public void deleteProduct(long productID) throws Exception {

        deleteConectorByProduct(productID);

        for (Product productItem : products)
            if (productItem.getProductID() == productID) {
                shops.remove(productItem);
                return;
            }
        throw new Exception("מוצר למחיקה , לא נמצא.");
    }

    public void deleteConectorByProduct(long ID) throws Exception {
        for (Product_Shop ProductConecto : conectors) {
            if (ProductConecto.getProductID() == ID) {
                conectors.remove(ProductConecto);
                return;
            }
        }
        throw new Exception("מקשר חנות למוצר למחיקה , לא נמצא.");
    }

    public void deleteConectorByShop(long ID) throws Exception {
        for (Product_Shop ShopConector : conectors) {
            if (ShopConector.getShopID() == ID) {
                conectors.remove(ShopConector);
                return;
            }
        }
        throw new Exception("מקשר חנות למוצר למחיקה , לא נמצא.");
    }

    @Override
    public void deleteOpinion(long opinionID) throws Exception {
        for (Opinion opinionItem : opinions)
            if (opinionItem.getOpinionID() == opinionID) {
                opinions.remove(opinionItem);
                return;
            }
        throw new Exception("חוות דעת זו לא קיימת במאגר הנתונים!");
    }
    @Override
    public void updateShop(Shop shop) throws Exception {
        for (Shop shopItem : shops) {
            if (shopItem.getShopID() == shop.getShopID()
                    && shopItem.getShopName().equals(shop.getShopID())) {
                shopItem.setShopAddress(shop.getShopAddress());
                shopItem.setTelephoneNumber(shop.getTelephoneNumber());
                shopItem.setEmail(shop.getEmail());
                return;
            }
        }
        throw new Exception(".לא ניתן לעדכן את פרטי החנות או מפני שאינה קיימת , או מפני ששונה שמה");
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        for (Product productItem : products) {
            if (productItem.getProductID() == product.getProductID()) {
                productItem.setProductName(product.getProductName());
                return;
            }
        }
        throw new Exception(".לא ניתן לעדכן את פרטי המוצר או מפני שאינו קיים ");
    }

    public void setLists() {

        try {
            this.addProduct(new Product("iPhon 5s"));
            this.addProduct(new Product("Galaxy s"));
            this.addProduct(new Product("smartphon LG"));

            this.addShop(new Shop("iDigital", "קניון מלחה ירושלים", "02-53564912", "iDigital@netvision.co.il"));
            this.addShop(new Shop("מחסני חשמל", "גנרל פיירקניג 20 ירושלים","073-2540112", "mahsanH@windowslive.com"));
            this.addShop(new Shop("א.ל.מ. רשת חנויות חשמל", "סוקולוב 49 רמת השרון", "03-5479875", "almEH@gmail.com"));
            this.addShop(new Shop("טרקלין חשמל", "דיזנגוף 155 תל-אביב", "1700-50-50-20", "traklin@gmail.com"));

            this.addProductToShop(new Product_Shop(3500, 0, 0));
            this.addProductToShop(new Product_Shop(2500, 0, 1));
            this.addProductToShop(new Product_Shop(3500, 1, 2));
            this.addProductToShop(new Product_Shop(3500, 1, 0));
            this.addProductToShop(new Product_Shop(3500, 2, 1));
            this.addProductToShop(new Product_Shop(3500, 2, 2));

            this.addOpinion(new Opinion("דוד שוסטר", 0, "מוצר מצויין!", 4));
            this.addOpinion(new Opinion("אליהו פולק", 1, "מוצר דפוק!", 1));
            this.addOpinion(new Opinion("מוטקה אלתר", 2, "מוצר בינוני ומטה!", 3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

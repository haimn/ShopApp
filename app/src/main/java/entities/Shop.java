package entities;

public class Shop {
    private long ShopID;
    private String ShopName;
    private String ShopAddress;
    private String TelephoneNumber;
    private String Email;
    private static int ShopIDCounter = 0;

    public Shop(String shopName, String shopAddress, String telephoneNumber, String email) {
        ShopID = ShopIDCounter++;
        ShopName = shopName;
        ShopAddress = shopAddress;
        TelephoneNumber = telephoneNumber;
        Email = email;
    }

    public Shop(Shop old) {
        ShopID = old.ShopID;
        ShopName = old.ShopName;
        ShopAddress = old.ShopAddress;
        TelephoneNumber = old.TelephoneNumber;
        Email = old.Email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Shop shop = (Shop) obj;
        return (ShopID == shop.ShopID &&
                ShopName == shop.ShopName &&
                ShopAddress == shop.ShopAddress &&
                TelephoneNumber == shop.TelephoneNumber &&
                Email == shop.Email);
    }

    public long getShopID() {
        return ShopID;
    }

    public void setShopID(long shopID) {
        ShopID = shopID;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getShopAddress() {
        return ShopAddress;
    }

    public void setShopAddress(String shopAddress) {
        ShopAddress = shopAddress;
    }

    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

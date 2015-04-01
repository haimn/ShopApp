package entities;

public class Opinion {
    private long OpinionID;
    private long ProductID;
    private String ProductOpinion;
    private String Name;
    private long opinionIDCount = 0;////////////////////////
    private long Rate;

    public Opinion(String name, long productID, String productOpinion, long rate) {
        OpinionID = opinionIDCount++;
        ProductID = productID;
        ProductOpinion = productOpinion;
        Name = name;
        Rate = rate;
    }

    public Opinion(Opinion old) {
        OpinionID = old.OpinionID;
        ProductID = old.ProductID;
        ProductOpinion = old.ProductOpinion;
        Name = old.Name;
        Rate = old.Rate;
    }

    public long getOpinionID() {
        return OpinionID;
    }

    public void setOpinionID(long opinionID) {
        OpinionID = opinionID;
    }

    public long getProductID() {
        return ProductID;
    }

    public void setProductID(long productID) {
        ProductID = productID;
    }

    public String getProductOpinion() {
        return ProductOpinion;
    }

    public void setProductOpinion(String productOpinion) {
        ProductOpinion = productOpinion;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getRate() {
        return Rate;
    }

    public void setRate(long rate) {
        Rate = rate;
    }
}

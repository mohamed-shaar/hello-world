public class Voucher {
    protected int points = 0;

    Voucher(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean checkIfPointsAreEnough(Product product) {
        return points >= product.getPrice();
    }

    public boolean purchase(Product product) {
        if (checkIfPointsAreEnough(product)) {
            points -= product.getPrice();
            return true;
        }
        return false;
    }
}

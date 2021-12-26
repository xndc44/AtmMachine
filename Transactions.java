import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;
public class Transactions {
    private static Double currentAmount = 10001.23;
    private static List<Date>obj1 = new LinkedList<>();
    private static List<String>obj2 = new LinkedList<>();
    private static List<Double>obj3 = new LinkedList<>();
    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount += currentAmount;
    }
    public void setObj(Date obj1, String obj2, Double obj3) {
        this.obj1.add(obj1);
        this.obj2.add(obj2);
        this.obj3.add(obj3);
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }
    public void printTransactions() {
        for (int i = 0; i < obj1.size(); i++) {
            if (obj2.get(i).equals("deposit")){
                System.out.println("On " + obj1.get(i) + " you " + obj2.get(i) + "ed " + obj3.get(i) + " into your account.");
            }
            else {
                System.out.println("On " + obj1.get(i) + " you " + "withdrew" + obj3.get(i) + " from your account.");
            }
        }
    }
}

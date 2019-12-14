import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main {

    public static void main(String[] args) {

        Bill electricBill = new Bill();

        electricBill.amountDueProperty().addListener((observable_value, old_value, new_value) -> {
            System.out.println("The bill was changed from value: " + old_value.toString() +
                    " to value: " + new_value.toString() + ".");
        });

        electricBill.setAmountDue(100.0);
        electricBill.setAmountDue(10.0);
        electricBill.setAmountDue(1100.0);

        IntegerProperty num1 = new SimpleIntegerProperty(1);
        IntegerProperty num2 = new SimpleIntegerProperty(10);
        IntegerProperty num3 = new SimpleIntegerProperty(15);

        NumberBinding sum = num1.add(num2);
        NumberBinding total = Bindings.add(num1, num2.multiply(num3));

        System.out.println("sum = " + sum.getValue() + "; total = " + total.getValue());
        num1.set(1000);
        System.out.println("after changes sum = " + sum.getValue());
        System.out.println("after changes total = " + total.getValue());

        Bill bill1 = new Bill();
        Bill bill2 = new Bill();
        Bill bill3 = new Bill();

        NumberBinding totalBill = Bindings.add(bill1.amountDueProperty(),
                bill2.amountDueProperty().add(bill3.amountDueProperty()));

        totalBill.addListener((observable) -> {
            System.out.println("Invalid value.");
        });

        bill1.setAmountDue(299.0);
        bill2.setAmountDue(10.0);
        bill3.setAmountDue(2.0);

        System.out.println("totalBill = " + totalBill.getValue());


        //========================================================

        Bill bill4 = new Bill();
        Bill bill5 = new Bill();
        Bill bill6 = new Bill();

        NumberBinding totalBill2 = Bindings.add(bill4.amountDueProperty(),
                bill5.amountDueProperty().add(bill6.amountDueProperty()));

        totalBill2.addListener((observable_value,
                                old_value,
                                new_value) -> {
            System.out.println("Changed value.");
        });

        bill4.setAmountDue(299.0);
        bill5.setAmountDue(10.0);
        bill6.setAmountDue(2.0);

        System.out.println("totalBill = " + totalBill2.getValue());
    }



}
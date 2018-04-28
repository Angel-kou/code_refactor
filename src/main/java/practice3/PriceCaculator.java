package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax ;
    private BigDecimal subTotal = new BigDecimal(0);



    public PriceCaculator(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts, BigDecimal tax) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = tax;
    }

    public BigDecimal calculate() {
        caculatorSubTotal();
        caculatorSubTotalAfterDiscount();
        getTax();
        return getGrandTotal();
    }

    private BigDecimal getGrandTotal() {
        // calculate GrandTotal
        return subTotal.add(tax);
    }

    private void getTax() {
        // calculate tax
        tax = subTotal.multiply(this.tax);
    }


    private void caculatorSubTotalAfterDiscount() {
        // Subtract discounts
        for (BigDecimal discount : discounts) {
            subTotal = subTotal.subtract(discount);
        }
    }

    private void caculatorSubTotal() {
        // Total up line items
        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }
    }
}

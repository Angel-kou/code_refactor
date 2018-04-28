package practice2;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    public Receipt() {
        tax = new BigDecimal(0.1);
        tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal tax;


    public double CalculateGrandTotal(List<Product> products, List<OrderItem> items) {
        BigDecimal grandTotal = getGrandTotal(products, items);
        return getDoubleValueOfGrandTotal(grandTotal);
    }

    private double getDoubleValueOfGrandTotal(BigDecimal grandTotal) {
        return grandTotal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private BigDecimal getGrandTotal(List<Product> products, List<OrderItem> items) {
        BigDecimal subTotal = calculateSubtotal(products, items);
        subTotal = getSubTotalAfterReduced(products, items, subTotal);
        BigDecimal taxTotal = getTaxTotal(subTotal);
        return subTotal.add(taxTotal);
    }

    private BigDecimal getTaxTotal(BigDecimal subTotal) {
        return subTotal.multiply(tax);
    }

    private BigDecimal getSubTotalAfterReduced(List<Product> products, List<OrderItem> items, BigDecimal subTotal) {
        for (Product product : products) {
            BigDecimal reducedPrice = product.getPrice()
                    .multiply(product.getDiscountRate())
                    .multiply(new BigDecimal(product.findOrderItem(items).getCount()));

            subTotal = subTotal.subtract(reducedPrice);
        }
        return subTotal;
    }


    private BigDecimal calculateSubtotal(List<Product> products, List<OrderItem> items) {
        BigDecimal subTotal = new BigDecimal(0);
        for (Product product : products) {
            subTotal = subTotal.add(getItemTotal(items, product));
        }
        return subTotal;
    }

    private BigDecimal getItemTotal(List<OrderItem> items, Product product) {
        OrderItem item = product.findOrderItem(items);
        return product.getPrice().multiply(new BigDecimal(item.getCount()));
    }
}

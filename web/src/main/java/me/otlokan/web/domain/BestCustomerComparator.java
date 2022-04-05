package me.otlokan.web.domain;

import java.util.Comparator;

public class BestCustomerComparator  implements Comparator<BestCustomer> {

    @Override
    public int compare(BestCustomer o1, BestCustomer o2) {
        return (int) (o1.getSpend() - o2.getSpend());
    }
}

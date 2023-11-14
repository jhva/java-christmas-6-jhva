package christmas.model;

import christmas.constant.ChristmasBenefits;
import java.util.List;

public class ChristmasBenefitsDetails {

    private final List<ChristmasBenefits> benefits;


    public ChristmasBenefitsDetails(List<ChristmasBenefits> benefits) {
        this.benefits = benefits;
    }

    public void test() {
        for (ChristmasBenefits christmasBenefits : benefits) {
            System.out.println(christmasBenefits.getPrice());
            System.out.println(christmasBenefits.getMessage());
            System.out.println(christmasBenefits.getCounter());
        }
    }

    public int calculateTotalBenefits() {
        return benefits.stream()
                .mapToInt(ChristmasBenefits::getPrice)
                .sum();
    }
}

package christmas.model;

import christmas.constant.ChristmasBenefits;
import java.util.Collections;
import java.util.List;

public record ChristmasBenefitsDetails(List<ChristmasBenefits> benefits) {

    public int calculateTotalBenefits() {
        return benefits.stream()
                .mapToInt(ChristmasBenefits::getPrice)
                .sum();
    }

    public List<ChristmasBenefits> getBenefits() {
        return Collections.unmodifiableList(benefits);
    }
}

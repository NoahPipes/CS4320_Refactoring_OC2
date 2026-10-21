package theatricalplays;

public class TragedyCalculator extends PerformanceCalculator {
    
    public TragedyCalculator(Performance perf) {
        super(perf);
    }

    @Override
    public int amount() {
        int amount = 40000;
        if (performance.audience > 30) {
            amount += 1000 * (performance.audience - 30);
        }

        return amount;
    }

}

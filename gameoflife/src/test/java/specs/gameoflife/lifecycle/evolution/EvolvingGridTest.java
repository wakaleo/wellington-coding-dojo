package specs.gameoflife.lifecycle.evolution;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import com.wakaleo.gameoflife.domain.*;

@RunWith(ConcordionRunner.class)
public class EvolvingGridTest {

    private static final int ROW_COUNT = 3;
    private static final int COLUMN_COUNT = 3;

    Universe universe;

	public String inTheBeginning() {
        universe = new Universe(ROW_COUNT,COLUMN_COUNT);
		return universe.toString();
	}

	public String nextGenerationFrom(String initialState) {
        universe = new Universe(ROW_COUNT,COLUMN_COUNT);
        universe.seedWith(initialState);
        universe.nextGeneration();
        return universe.toString();
    }
}
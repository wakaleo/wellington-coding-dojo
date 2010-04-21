package specs.gameoflife.lifecycle.cells;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class CreatingNewCellsTest {

    public String getGreeting() {
        return "Hello World!";
    }

    public String greetingFor(String firstName) {
        return String.format("Hello %s!", firstName);
    }
}
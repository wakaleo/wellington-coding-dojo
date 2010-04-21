package specs.gameoflife.lifecycle.cells;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import com.wakaleo.gameoflife.domain.*;

@RunWith(ConcordionRunner.class)
public class DisplayingCellsTest {

    Cell livingCell = new LivingCell();
    Cell deadCell = new DeadCell();

    public String getLivingCell() {
        return livingCell.toString();
    }

    public String getDeadCell() {
        return "-";
    }
}
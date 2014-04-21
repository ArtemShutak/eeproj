package parser;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.*;
import static parser.TxtParser.ParsingProcessor;

/**
 * Created by shootgun on 4/21/14.
 */
public class TxtParserTest {
    private TxtParser parser;
    private ParsingProcessor processor;

    @Before
    public void setUp() throws Exception {
        parser = new TxtParser();
        processor = mock(ParsingProcessor.class);
        when(processor.getYear()).thenReturn(2014);
    }

    @Test
    public void parseNextDayTest() throws Exception {
        parser.parse("18 апр", processor);

        LocalDate date = LocalDate.of(2014, Month.APRIL, 18);
        verify(processor).startProcessDay(date);
    }

    @Test
    public void parseNegativeOperation() throws Exception {
        parser.parse("- 333 ужин гризли", processor);

        verify(processor).processOperation(-333, "ужин гризли");

    }

    @Test
    public void parsePositiveOperation() throws Exception {
        parser.parse("+ 1000 отдал Женя", processor);

        verify(processor).processOperation(1000, "отдал Женя");
    }

}

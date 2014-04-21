package parser;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;
import static java.time.LocalDate.of;
import static java.time.Month.APRIL;

/**
 * Created by shootgun on 4/21/14.
 */
public class TxtParser {

    public void parse(String input, ParsingProcessor processor) {
        String[] tokens = input.split(" ");
        switch (tokens[0]){
            case "-":
                processor.processOperation(- parseInt(tokens[1]), input.substring(input.indexOf(tokens[2])));
                break;
            case "+":
                processor.processOperation(parseInt(tokens[1]), input.substring(input.indexOf(tokens[2])));
                break;
            default:
                LocalDate date = of(processor.getYear(), APRIL, parseInt(tokens[0]));
                processor.startProcessDay(date);
                break;
        }
    }

    public interface ParsingProcessor {

        int getYear();

        void startProcessDay(LocalDate date);

        void processOperation(int amount, String comment);
    }
}

package software.ulpgc.kata6.control;


import java.time.LocalDate;

public class HolidayBetweenCommand implements Command{

    private final Input input;
    private final Output output;

    public HolidayBetweenCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        output.result(input.start());
    }

    public interface Input{
        LocalDate[] start();
    }

    public interface Output{
        void result(LocalDate[] dates);
    }


}

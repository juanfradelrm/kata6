package software.ulpgc.kata6;

import software.ulpgc.kata6.control.CommandFactory;
import software.ulpgc.kata6.control.HolidayBetweenCommand;
import software.ulpgc.kata6.model.Calendar;
import software.ulpgc.kata6.view.HolidaysBetweenService;
import software.ulpgc.kata6.view.adapters.HolidayBetweenAdapter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class Main {
    public static void main(String[] args) {
        CommandFactory factory = new CommandFactory().register("holidays-between", holidaysBetween());
        new HolidaysBetweenService(factory, 7070).start();
    }

    private static CommandFactory.Builder holidaysBetween() {
        return (req, res) -> {
            HolidayBetweenAdapter adapter = new HolidayBetweenAdapter(calendar2024());
            HolidayBetweenCommand.Input input = adapter.inputFor(req);
            HolidayBetweenCommand.Output output = adapter.outputFor(res);
            return new HolidayBetweenCommand(input, output);
        };
    }



    private static Calendar calendar2024(){
        return new Calendar(2024, holidays2024());
    }

    private static Calendar calendar2025(){
        return new Calendar(2025, holidays2025());
    }

    private static Map<LocalDate, String> holidays2024() {
        Map<LocalDate, String> holidays = new HashMap<>();
        holidays.put(LocalDate.of(2024, 1, 1), "Año Nuevo");
        holidays.put(LocalDate.of(2024, 1, 6), "Epifanía del Señor");
        holidays.put(LocalDate.of(2024, 3, 29), "Viernes Santo");
        holidays.put(LocalDate.of(2024, 5, 1), "Día del Trabajador");
        holidays.put(LocalDate.of(2024, 8, 15), "Asunción de la Virgen");
        holidays.put(LocalDate.of(2024, 10, 12), "Fiesta Nacional de España");
        holidays.put(LocalDate.of(2024, 11, 1), "Todos los Santos");
        holidays.put(LocalDate.of(2024, 12, 6), "Día de la Constitución Española");
        holidays.put(LocalDate.of(2024, 12, 8), "Inmaculada Concepción");
        holidays.put(LocalDate.of(2024, 12, 25), "Navidad");
        return holidays;
    }

    private static Map<LocalDate, String> holidays2025() {
        Map<LocalDate, String> holidays = new HashMap<>();
        holidays.put(LocalDate.of(2025, 1, 1), "Año Nuevo");
        holidays.put(LocalDate.of(2025, 1, 6), "Epifanía del Señor");
        holidays.put(LocalDate.of(2025, 4, 18), "Viernes Santo");
        holidays.put(LocalDate.of(2025, 5, 1), "Día del Trabajador");
        holidays.put(LocalDate.of(2025, 8, 15), "Asunción de la Virgen");
        holidays.put(LocalDate.of(2025, 11, 1), "Todos los Santos");
        holidays.put(LocalDate.of(2025, 12, 6), "Día de la Constitución Española");
        holidays.put(LocalDate.of(2025, 12, 8), "Inmaculada Concepción");
        holidays.put(LocalDate.of(2025, 12, 25), "Navidad");
        return holidays;
    }


}

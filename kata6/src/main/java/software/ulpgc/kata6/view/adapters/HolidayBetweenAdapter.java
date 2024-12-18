package software.ulpgc.kata6.view.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.kata6.control.HolidayBetweenCommand;
import software.ulpgc.kata6.model.Calendar;

import java.io.IOException;
import java.time.LocalDate;

public class HolidayBetweenAdapter {

    Calendar calendar;

    public HolidayBetweenAdapter(Calendar calendar) {
        this.calendar = calendar;
    }

    public HolidayBetweenCommand.Input inputFor(HttpServletRequest req){
        return new HolidayBetweenCommand.Input() {
            @Override
            public LocalDate[] start() {
                LocalDate start = LocalDate.parse(req.getParameter("start"));
                LocalDate end = LocalDate.parse(req.getParameter("end"));
                return new LocalDate[]{start, end};
            }
        };
    }

    public HolidayBetweenCommand.Output outputFor(HttpServletResponse res){
        return new HolidayBetweenCommand.Output() {
            @Override
            public void result(LocalDate[] dates) {
                try {
                    res.getWriter().write(calendar.getHolidaysBetween(dates[0], dates[1]).toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

}

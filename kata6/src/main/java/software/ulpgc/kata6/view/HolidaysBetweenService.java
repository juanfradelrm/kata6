package software.ulpgc.kata6.view;

import io.javalin.Javalin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.kata6.control.CommandFactory;


public class HolidaysBetweenService implements Service{

    private final CommandFactory commandFactory;
    private final int port;
    private Javalin app;

    public HolidaysBetweenService(CommandFactory commandFactory, int port) {
        this.commandFactory = commandFactory;
        this.port = port;
    }

    @Override
    public void start() {
        app = Javalin.create()
                .get("/holidays-between", ctx ->  execute("holidays-between", ctx.req(), ctx.res()))
                .start(port);
    }

    @Override
    public void stop() {
        app.stop();
}

    private void execute(String commandName, HttpServletRequest req, HttpServletResponse res){
        commandFactory.with(req,res).build(commandName).execute();
    }
}

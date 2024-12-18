package software.ulpgc.kata6.control;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String,Builder> builders ;

    public CommandFactory() {
        this.builders = new HashMap<>();
    }

    public CommandFactory register(String builderName, Builder builder){
        builders.put(builderName, builder);
        return this;
    }

    public Executor with(HttpServletRequest req, HttpServletResponse res){
        return name -> builders.get(name).build(req, res);
    }


    public interface Executor {
        Command build(String name);
    }

    public interface Builder {
        Command build(HttpServletRequest req, HttpServletResponse res);
    }
}

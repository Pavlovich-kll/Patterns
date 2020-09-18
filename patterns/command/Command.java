package patterns.command;

public class Command {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(new StartCommand(computer), new StopCommand(computer), new ResetCommand(computer));

        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}

interface CommandInterface {
    void execute();
}

class Computer {
    public void start() {
        System.out.println("Start");
    }

    public void stop() {
        System.out.println("Stop");
    }

    public void reset() {
        System.out.println("Reset");
    }
}

abstract class CommandAbstract implements CommandInterface {
    protected Computer computer;

    public CommandAbstract(Computer computer) {
        this.computer = computer;
    }
}

class StartCommand extends CommandAbstract {

    public StartCommand(Computer computer) {
        super(computer);
    }

    @Override
    public void execute() {
        computer.start();
    }
}

class StopCommand extends CommandAbstract {

    public StopCommand(Computer computer) {
        super(computer);
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

class ResetCommand extends CommandAbstract {
    public ResetCommand(Computer computer) {
        super(computer);
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

class User {
    private CommandInterface start;
    private CommandInterface stop;
    private CommandInterface reset;

    public User(CommandInterface start, CommandInterface stop, CommandInterface reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    public void startComputer(){
        start.execute();
    }
    public void stopComputer(){
        stop.execute();
    }
    public void resetComputer (){
        reset.execute();
    }
}
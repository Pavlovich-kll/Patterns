package patterns.chain_of_responsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Logger sms = new SMSLog(Level.ERROR);
        Logger emailLog = new EmailLog(Level.DEBUG);
        Logger fileLog = new FileLog(Level.INFO);

        sms.setNext(emailLog);
        emailLog.setNext(fileLog);
        sms.writeMessage("Все ок", Level.INFO);
        sms.writeMessage("Идет дебаг", Level.DEBUG);
        sms.writeMessage("Ошибка!", Level.ERROR);

    }
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger {
    protected int priority;
    protected Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    protected void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    protected abstract void write(String message);
}

class SMSLog extends Logger {

    public SMSLog(int priority) {
        super(priority);
    }

    @Override
    protected void write(String message) {
        System.out.println("CMC: " + message);
    }
}

class EmailLog extends Logger {

    public EmailLog(int priority) {
        super(priority);
    }

    @Override
    protected void write(String message) {
        System.out.println("Емайл: " + message);
    }
}

class FileLog extends Logger {

    public FileLog(int priority) {
        super(priority);
    }

    @Override
    protected void write(String message) {
        System.out.println("Файл: " + message);
    }
}
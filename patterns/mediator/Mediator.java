package patterns.mediator;

import java.util.HashSet;

public class Mediator {
    public static void main(String[] args) {
        TextChat textChat = new TextChat();
        User admin = new Admin(textChat);
        User user1 = new SimpleUser(textChat, "Вова");
        User user2 = new SimpleUser(textChat, "Миша");
        User user3 = new SimpleUser(textChat, "Болик");
        textChat.addUser(user3);
        textChat.setAdmin(admin);
        textChat.addUser(user1);
        textChat.addUser(user2);
        user1.sendMessage("hi");
        user3.sendMessage("hi dude))");

    }
}

abstract class User {
    protected Chat chat;
    protected String name;

    public User(Chat chat) {
        this.chat = chat;
    }

    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    protected void sendMessage(String message) {
        pingImitation();
        System.out.println(this + " отправил сообщение в чат: '" + message + "'");
        chat.sendMessage(message, this);

    }

    public void getMessage(String message) {
        pingImitation();
        System.out.println(this + " получил сообщение '" + message + "'");
    }

    protected void pingImitation() {
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

abstract class Chat {
    private HashSet<User> usersInChat = new HashSet<>();
    private User admin;

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser(User user) {
        usersInChat.add(user);
        System.out.println(user + " добавлен в чат");
    }

    protected void sendMessage(String message, User user) {
        for (User u : usersInChat) {
            if (!u.equals(user)) {
                u.getMessage(message);
            }
        }
        admin.getMessage(message);
    }
}

class Admin extends User {

    public Admin(Chat chat) {
        super(chat);
    }

    @Override
    public void getMessage(String message) {
        pingImitation();
        System.out.println("Администратор получил сообщение '" + message + "'");
    }
}

class SimpleUser extends User {
    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }
}

class TextChat extends Chat {

}
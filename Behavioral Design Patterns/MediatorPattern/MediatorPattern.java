// Mediator Pattern

import java.util.*;

// Mediator interface defining communication between participants
interface ChatMediator {
    void sendMessage(User user, String message);
}

// Concrete Mediator class managing communication between participants
class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    // Method to add a user to the chat room
    public void addUser(User user) {
        users.add(user);
    }

    // Method to send a message to all users in the chat room
    @Override
    public void sendMessage(User user, String message) {
        for (User u : users) {
            // Exclude the sender
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }
}

// Participant interface defining basic behavior for participants
interface User {
    void sendMessage(String message);

    void receiveMessage(String message);
}

// Concrete User class implementing the User interface
class ChatUser implements User {
    private String name;
    private ChatMediator chatMediator;

    public ChatUser(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    // Method to send a message using the chat mediator
    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends: " + message);
        chatMediator.sendMessage(this, message);
    }

    // Method to receive a message from the chat mediator
    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " receives: " + message);
    }
}

// Demo class to test the Mediator Pattern
public class MediatorPattern {
    public static void main(String[] args) {
        // Creating a chat room (mediator)
        ChatMediator chatRoom = new ChatRoom();

        // Creating users and adding them to the chat room
        User user1 = new ChatUser("User1", chatRoom);
        User user2 = new ChatUser("User2", chatRoom);
        User user3 = new ChatUser("User3", chatRoom);

        ((ChatRoom) chatRoom).addUser(user1);
        ((ChatRoom) chatRoom).addUser(user2);
        ((ChatRoom) chatRoom).addUser(user3);

        // Sending messages between users through the chat room
        user1.sendMessage("Hello, everyone!");
        user2.sendMessage("Hi there!");
        user3.sendMessage("Hey!");
    }
}

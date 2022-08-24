import manager.EventManager;
import manager.UserManager;
import model.Event;
import model.EventType;
import model.User;

import java.util.List;
import java.util.Scanner;

public class EventUserTest implements Commands {
    private final static Scanner scanner = new Scanner(System.in);
    private final static UserManager userManager = new UserManager();
    private final static EventManager eventManager = new EventManager();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.command();
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_EVENT:
                    addEvent();
                    break;
                case SHOW_EVENTS:
                    showEvents();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case SHOW_USERS:
                    showUser();
                    break;
                default:
                    isRun = false;
                    System.out.println("Invalid command");
            }
        }
    }

    private static void showUser() {
        List<User> userList = userManager.showUsers();
        if (userList.isEmpty()) {
            System.out.println("Users list is empty");
        } else {
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    private static void addUser() {
        System.out.println("Please input name");
        String name = scanner.nextLine();
        System.out.println("Please input surname");
        String surname = scanner.nextLine();
        System.out.println("Please input email");
        String email = scanner.nextLine();
        System.out.println("Please input event id");
        int eventId = Integer.parseInt(scanner.nextLine());
        User user = new User(name, surname, email, eventId);

        userManager.addUser(user);
        System.out.println("User was added ");
    }

    private static void showEvents() {
        List<Event> eventList = eventManager.showEvents();
        if (eventList.isEmpty()) {
            System.out.println("Events list is empty");
        } else {
            for (Event event : eventList) {
                System.out.println(event);
            }
        }
    }


    private static void addEvent() {
        System.out.println("Please input event name");
        String name = scanner.nextLine();
        System.out.println("Please input event places");
        String places = scanner.nextLine();
        System.out.println("Please input event is online");
        boolean isOnline = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Please input event price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input event type");
        String eventType = scanner.nextLine();
        EventType type = EventType.valueOf(eventType.toUpperCase());
        Event event = new Event(name, places, isOnline, price, type);

        eventManager.addEvent(event);
        System.out.println("Event was added ");
    }
}

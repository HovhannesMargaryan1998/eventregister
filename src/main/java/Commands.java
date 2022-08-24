public interface Commands {
    int EXIT = 0;
    int ADD_EVENT = 1;
    int SHOW_EVENTS = 2;
    int ADD_USER = 3;
    int SHOW_USERS = 4;

    static void command() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + ADD_EVENT + " for add event");
        System.out.println("Please input " + SHOW_EVENTS + " for show events");
        System.out.println("Please input " + ADD_USER + " for add user");
        System.out.println("Please input " + SHOW_USERS + " for show users");
    }
}

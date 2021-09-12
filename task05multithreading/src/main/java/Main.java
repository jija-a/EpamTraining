import view.impl.ApplicationMenuImpl;

public class Main {

    public static void main(String[] args) {

        while (true) {
            ApplicationMenuImpl.APPLICATION_MENU.print();
            ApplicationMenuImpl.APPLICATION_MENU.handleInput();
        }

    }

}

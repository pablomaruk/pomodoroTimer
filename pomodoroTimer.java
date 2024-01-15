import java.util.Scanner;

class PomodoroTimer {
    private static final int WORK_DURATION = 25; // in minutes
    private static final int BREAK_DURATION = 5;  // in minutes
    private boolean isWorking;

    public PomodoroTimer() {
        this.isWorking = false;
    }

    public void startPomodoro() {
        System.out.println("Pomodoro Timer started!");

        while (true) {
            displayTimer();

            if (isWorking) {
                sleep(WORK_DURATION * 60); // Convert minutes to seconds
                System.out.println("Work session complete. Take a break!");
            } else {
                sleep(BREAK_DURATION * 60); // Convert minutes to seconds
                System.out.println("Break session complete. Back to work!");
            }

            toggleWorkingState();
        }
    }

    private void displayTimer() {
        String sessionType = isWorking ? "Work" : "Break";
        int duration = isWorking ? WORK_DURATION : BREAK_DURATION;

        System.out.println("\n----- " + sessionType + " Session -----");
        System.out.println("Time remaining: " + duration + " minutes");
    }

    private void toggleWorkingState() {
        isWorking = !isWorking;
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PomodoroTimer pomodoroTimer = new PomodoroTimer();

        System.out.println("Welcome to the Pomodoro Timer!");
        System.out.println("Press Enter to start a new Pomodoro session or type 'exit' to quit.");

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Pomodoro Timer. Goodbye!");
                System.exit(0);
            }

            pomodoroTimer.startPomodoro();
        }
    }
}

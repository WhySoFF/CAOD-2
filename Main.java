import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static HashMap hashMap;

    public static void main(String[] args) throws IOException {
        createHashMap();
        chooseInput();
    }

    private static void createHashMap() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\mrsti\\IdeaProjects\\CAOD 2\\src\\file.txt"));
        hashMap = new HashMap(checkLines(bf));
        bf.close();
        bf = new BufferedReader(new FileReader("C:\\Users\\mrsti\\IdeaProjects\\CAOD 2\\src\\file.txt"));
        String str = "";
        String[] line;
        while((str = bf.readLine()) != null) {
            line = str.split("\\s+");
            hashMap.push(Integer.parseInt(line[0]), line[1]);
        }
        bf.close();
    }

    private static int checkLines(BufferedReader bf) throws IOException {
        int count = 0;
        while(bf.readLine() != null) {
            count++;
        }
        return count;
    }

    private static void chooseInput() {

        int command;
        writeQuestions();
        while((command = checkInput(scan())) != 0) {
            switch (command) {
                case 1 :
                    System.out.println("Enter key: ");
                    int key = Integer.parseInt(scan());
                    System.out.println("Enter data: ");
                    String data = scan();
                    hashMap.push(key, data);
                    break;
                case 2 :
                    System.out.println("Enter key you want to delete: ");
                    hashMap.delete(Integer.parseInt(scan()));
                    break;
                case 3 :
                    System.out.println("Enter key you want to see: ");
                    System.out.println(hashMap.show(Integer.parseInt(scan())));
                    break;
            }
            writeQuestions();
        }
    }

    private static void writeQuestions() {
        System.out.println("Enter 1, if you want to add element.");
        System.out.println("Enter 2, if you want to delete element.");
        System.out.println("Enter 3, if you want to see data in the element.");
        System.out.println("Enter 0, if you want out.");
    }

    private static int checkInput(String input) {
        int number = Integer.parseInt(input);
        if(number < 0 || number > 3) {
            System.out.println("Invalid command, try again.");
            return checkInput(scan());
        }
        return number;
    }

    private static String scan() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
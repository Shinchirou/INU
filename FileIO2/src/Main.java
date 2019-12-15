import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int id;
        String firstName;
        String lastName;
        Scanner sc = null;
        PrintWriter out = null;
        List<Person> people = new ArrayList<>();
        try {
            out = new PrintWriter("/home/users/bostasze/Documents/namesOut.txt");
            sc = new Scanner(Paths.get("/home/users/bostasze/Documents/names.txt"));
            while (sc.hasNext()) {
                id = sc.nextInt();
                firstName = sc.next();
                lastName = sc.next();
                System.out.printf("Wczytano id = %3d, imie = %12s, nazwisko = %12s\n", id, firstName, lastName);
                people.add(new Person(id, firstName, lastName));
            }

            for (Person person : people) {
                out.printf("%s:%s:%d\n", person.getFirstName(), person.getLastName(), person.getId());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (sc != null) {
            sc.close();
        }
        if (out != null) {
            out.close();
        }
    }
}
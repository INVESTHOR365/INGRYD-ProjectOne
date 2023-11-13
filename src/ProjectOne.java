import java.sql.*;
import java.util.Scanner;

// CLASS DECLARATION
public class ProjectOne
{
    // DATABASE CONNECTION INFORMATION
    private static String url = "jdbc:mysql://127.0.0.1/project_one";
    private static String username = "INVESTHOR365";
    private static String password = "PolymathisT2111$";

    // CREATETABLE METHOD (FIRST METHOD)
    static void createTable()
    {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement())
        {
            statement.execute("CREATE TABLE IF NOT EXISTS createTable (name TEXT, email TEXT, age INTEGER, location TEXT, designation TEXT)");
        }

        catch (SQLException az)
        {
            System.out.println(az.getMessage());
        }
    }
    // POPULATETABLE METHOD (SECOND METHOD)
    public static int populateTable()
    {
        int count = 0;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO createTable(name, email, age, location, designation) VALUES(?,?,?,?,?)");
             Scanner scanner = new Scanner(System.in))
        {
            // LOOP TO ITERATE OUR OUTPUT TEN TIMES
            for (int i = 0; i < 10; i++)
              {
                System.out.println("Please enter your name: ");
                String name = scanner.nextLine();
                System.out.println("Please enter your email: ");
                String email = scanner.nextLine();
                System.out.println("Please enter your age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter your location: ");
                String location = scanner.nextLine();
                System.out.println("Please enter your designation: ");
                String designation = scanner.nextLine();


                insertStatement.setString(1, name);
                insertStatement.setString(2, email);
                insertStatement.setInt(3, age);
                insertStatement.setString(4, location);
                insertStatement.setString(5, designation);

                insertStatement.execute();
                count++;
              }
                System.out.println(count + " Details inserted successful. ");

                /*    TO UPDATE STATEMENT
                PreparedStatement updateStatement = connection.prepareStatement("UPDATE createtable SET name='Mr. Davidson' WHERE designation=? ");
                System.out.println("Please enter the designation to update the name column: ");
                String name = scanner.nextLine();
                updateStatement.setString(1, name);
                updateStatement.execute();

                       TO DELETE STATEMENT
                PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM createtable WHERE age=?");
                System.out.println("Please enter the age to delete record: ");
                int age1 = scanner.nextInt();
                scanner.nextLine();
                deleteStatement.setInt(1, age1);
                deleteStatement.execute();
                */
        }
        catch (Exception az)
        {
            System.out.println(az.getMessage());
        }
        return count;
    }
        // MAIN METHOD
        public static void main(String[] args)
        {
            ProjectOne.createTable();
            ProjectOne.populateTable();
        }
}
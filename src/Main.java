import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static int code = 0;
    public static void main(String[] args){
        User dummy;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter company name: ");
        String companyName = sc.nextLine();

        System.out.print("Enter max Capacity for number of Emails (enter 0 if you want capacity that is equal to number of users): ");
        int capacity = sc.nextInt(); sc.nextLine();

        User.setCompany(companyName);

        System.out.print("Enter path of file data that contains usernames: ");
        String path = sc.nextLine();
        System.out.print("Where do you want the ouput file? {insert path after the arrow} -> ");
        String ouputPath = sc.nextLine();

        if(GenerateEmails(path, ouputPath, capacity)) System.out.println("Emails Generated successfully");
    }


    static boolean GenerateEmails(String path, String outputPath, int capacity){
        File data = new File(path);

        try(Scanner file = new Scanner(data); BufferedWriter f_writer = new BufferedWriter(new FileWriter(outputPath, true))){
            int nLines = countNumOfLinesIn(data);
            capacity = capacity == 0 ?  nLines : capacity;
            file.useDelimiter("[\n]");
            User.setMaxMailCapacity(capacity);
            System.out.println("Capacity = "+capacity+" "+", Data Length = "+nLines);
            ArrayList<User> usrs = new ArrayList<>();
            code = outputPath.length();
            while(file.hasNext()){
                code++;
                String[] line = file.nextLine().split("[,\\s]+");
                String firstName = line[0].trim();
                String lastName = line[1].trim();
                lastName+=Integer.toString(code);
                if(line.length == 3 && firstName != null && lastName != null){
                    String department = line[2].trim();
                    usrs.add(new User(firstName, lastName, department));
                }
                else{
                    usrs.add(new User(firstName, lastName));
                }
            }

            System.out.println("---------------------------------------------------------------");
            f_writer.write("---------------------------------------------------------------\n");
            for(int i = 0; i < usrs.size(); i++){
                usrs.get(i).generatePass();
                f_writer.write("Email: "+usrs.get(i).generateEmail()+" - Password: "+usrs.get(i).getPassword()+"\n");
            }
            return true;
        } catch (IOException e){
            System.out.println(e.getStackTrace());
            return false;
        }
    }

    static int countNumOfLinesIn(File file) throws IOException , FileNotFoundException{
        int lines = 0;
        BufferedReader bfReader = new BufferedReader(new FileReader(file));
        while(bfReader.readLine() != null){
            lines++;
        }
        return lines;
    }
}

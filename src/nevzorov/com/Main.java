package nevzorov.com;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Open file JSON
        File inputFile = new File("c:\\IdeaProjects\\PhonebookHashmap\\phonedata.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Fill HashMap, HashSet
        Scanner scaner = new Scanner(fis);
        Map<String, Card> hashmap = new HashMap<>();
        Set<Card> hashMapSet = new HashSet<>();
        fillbookMap(scaner, hashmap, hashMapSet);

        //Dialog for search method
        System.out.println("Choose method of search: N - name, T - number:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = null;
        try {
            n = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (n.equals("T") || n.equals("t"))
            searchByNumber(reader);
        if (n.equals("N") || n.equals("n"))
            searchByKey(hashmap, reader);

    }


    private static void searchByNumber(BufferedReader reader) {
        String name = null;
        int tel = 0;

            try {
                name = reader.readLine();
                tel = Integer.parseInt(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private static void searchByKey(Map<String, Card> hashmap, BufferedReader reader) {
        String name = null;
            try {
                name = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if ((hashmap.containsKey(name))) {
                System.out.println(name);
                System.out.println(hashmap.get(name).getMnumb());
                System.out.println(hashmap.get(name).getHnumb());
                System.out.println(hashmap.get(name).getEmail());
                System.out.println(hashmap.get(name).getSkype());
            }
    }

    private static void fillbookMap(Scanner scaner, Map<String, Card> hashmap, Set<Card> hashMapSet) {
        while (scaner.hasNextLine()) {
            int i = 0;
            String line = scaner.nextLine();
            if (!line.equals("") && line != null) {
                JSONObject jsonObject = (JSONObject) JSONValue.parse(line);
                String name = (String) jsonObject.get("name");
                Long mnum = (Long) jsonObject.get ("mnum");
                int mnumi = mnum.intValue();
                Long hnum = (Long) jsonObject.get ("hnum");
                int hnumi = hnum.intValue();
                String email = (String) jsonObject.get ("email");
                String skype = (String) jsonObject.get ("skype");
                Card card = new Card (mnumi, hnumi, email, skype);
                hashmap.put(name, card);
                hashMapSet.add(card);
                }
                i++;
            }
    }

}

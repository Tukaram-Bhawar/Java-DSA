import java.util.HashMap;

public class ticketroot {

    public static String getstr(HashMap<String, String> tic){
        HashMap<String, String> revtic=new HashMap<>();

        for(String key: tic.keySet()){
            revtic.put(tic.get(key), key);
        }
        for(String key: tic.keySet()){
            if(!revtic.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> ticket=new HashMap<>();
        ticket.put("chennai", "beng");
        ticket.put("mumbai", "delhi");
        ticket.put("goa", "chennai");
        ticket.put("delhi", "goa");

        String start=getstr(ticket);
        while (ticket.containsKey(start)) {
            System.out.println(start);
            start=ticket.get(start);
        }
        System.out.println(start);
    }
    
}

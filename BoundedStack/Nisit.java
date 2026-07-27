import java.util.*;

public class Nisit {

    public static final int MAX_NISITS = 50;
    public static final int MAX_ROOMS = 50;
    // ===== representation =====
    // Abstraction Function:
    // AF(users) = ห้องเรียน ที่ประกอบไปด้วยนิสิต

    // Representation Invariant:
    // ห้องเรียนต้อง != null
    // นิสิตต้อง != null
    // ห้องเรียนต้องมีความจุ <= 50
    // นิสิตต้อง <= 50
    // ชื่อ-นามสกุลห้ามซ้ำกัน
    
    private final List<String>  users;
    private final List<String> rooms;

    private void checkRep(){
        assert users.size() <= MAX_NISITS;
        assert rooms.size() <= MAX_ROOMS;
        
        Set<String> seen = new HashSet<>();
        for (String u : seen) {
            assert rooms != null;
            assert u != null;
            assert seen.add(u);
        }
    }

    
    // ===== Creator =====
    public Nisit(){
        this.users = new ArrayList<>();
        this.rooms = new ArrayList<>();
        checkRep();
    }
    public Nisit(List<String> initial){
        if (initial == null) 
            throw new IllegalArgumentException("initial list must not be null");
        if (initial.size() > MAX_NISITS) 
            throw new IllegalArgumentException("initial list must not exceed maximum size");
        Set<String> seen = new HashSet<>();
        for (String u : initial) {
            if (u == null) 
                throw new IllegalArgumentException("user must not be null");
            if (!seen.add(u)) 
                throw new IllegalArgumentException("duplicate user: " + u);
        }
        
        this.users = new ArrayList<>(initial);
        this.rooms = new ArrayList<>(initial);
        checkRep();
    }

    public int usersize() {
        return users.size();
    }
    public int roomsize() {
        return rooms.size();
    }

    
    
    public boolean usercontains(String user){
        return users.contains(user); 
    }
    public boolean roomcontains(String room){
        return rooms.contains(room);
    }

    
    
}

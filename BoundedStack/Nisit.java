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
    private final int rooms;

    private void checkRep() {
        assert users != null;
        assert rooms > 0;
        assert rooms <= MAX_ROOMS   ;// ตรวจสอบว่าความจุห้องไม่เกิน MAX_ROOMS
        assert users.size() <= rooms;// ตรวจสอบว่าจำนวนนิสิตไม่เกินความจุของห้อง

    Set<String> seen = new HashSet<>();
    for (String u : users) {
        assert u != null;
        assert seen.add(u);
        }
    }
    
    // ===== Creator =====
    public Nisit(){
        this.users = new ArrayList<>();
        this.rooms = MAX_NISITS;
        checkRep();
    }
    public Nisit(int rooms) {
    if (rooms <= 0 || rooms > MAX_NISITS) 
        throw new IllegalArgumentException("invalid room capacity");//ทำการตรวจสอบความถูกต้องของจำนวนห้องเรียน ถ้าไม่ถูกต้องจะ throw exception
    

    this.users = new ArrayList<>();
    this.rooms = rooms;
    checkRep();
    }
    public Nisit(List<String> initial, int rooms) {
    if (initial == null)
        throw new IllegalArgumentException("initial list must not be null");

    if (rooms <= 0 || rooms > MAX_ROOMS)
        throw new IllegalArgumentException("invalid room capacity");// ตรวจสอบว่าความจุห้องถูกต้อง (ต้องมากกว่า 0 และไม่เกิน MAX_ROOMS)

    if (initial.size() > rooms)
        throw new IllegalArgumentException("too many students");// ตรวจสอบว่าจำนวนนิสิตไม่เกินความจุของห้อง

    this.users = new ArrayList<>(initial);
    this.rooms = rooms;
    checkRep();
    }
    

    public int usersize() {
        return users.size();//คืนค่าจำนวนของนิสิต
    }
    public int getrooms() {
        return rooms;//คืนค่าความจุของห้อง
    }

    
    
    public boolean usercontains(String user){
        return users.contains(user); //คืนค่าความจริงว่ามีชื่อ-นามสกุลนิสิตที่ระบุอยู่ในห้องหรือไม่
    }
    public boolean Fullroom() {
    return users.size() >= rooms;//คืนว่าถ้าห้องเต็มแล้วจะ return true
    }

    
    
}

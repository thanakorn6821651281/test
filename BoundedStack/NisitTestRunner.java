import java.util.*;


/**
 * Test runner 
 */
public class NisitTestRunner {

    private static int passed = 0;
    private static int failed = 0;

    /** helper กลาง — พิมพ์ PASS/FAIL และนับผลให้เอง */
    private static void check(String name, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("[PASS] " + name);
        } else {
            failed++;
            System.out.println("[FAIL] " + name);
        }
    }

    public static void main(String[] args) {
        boolean assertsOn = false;
        assert assertsOn = true;
        if (!assertsOn) {
            System.out.println("WARNING: assertions disabled"
                    + " - re-run with: java -ea PlaylistTest\n");
        }

        System.out.println("=== Playlist Test Suite ===\n");

        testCreators();
        //testAdd();
        //testRemove();
        //testObservers();
        //testProducer();
        //testExposure();

        System.out.println("\n=== Summary ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Total : " + (passed + failed));
        System.out.println(failed == 0 ? "ALL TESTS PASSED" : "SOME TESTS FAILED");

        if (failed > 0) {
            System.exit(1);
        }
    }
    private static void testCreators() {
        System.out.println("-- Creators --");

        Nisit empty = new Nisit();
        check("new() -> empty users", empty.usersize() == 0);
        check("new() -> empty rooms", empty.roomsize() == 0);
        check("new() -> contains nothing users", !empty.usercontains("anything"));
        check("new() -> contains nothing rooms", !empty.roomcontains("anything"));

        Nisit n = new Nisit(Arrays.asList("a", "b", "c"));
        check("new(list) -> correct users size", n.usersize() == 3);
        check("new(list) -> contains b", n.usercontains("b"));
    }

}
import java.util.Vector;


public class MainData {
	private static final MainData INSTANCE = new MainData();
	 
    private MainData() {}
 
    public static MainData getInstance() {
        return INSTANCE;
    }
    public Vector chatVector = new Vector();
}

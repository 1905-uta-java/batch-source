import java.sql.Connection;
import java.sql.SQLException;

import com.revature.pZero.util.ConnectionUtil;

public class TesterClass {
	private int i;
	
	public TesterClass() {
		
	}
	
	public int approveRequest() {
		try (Connection con = ConnectionUtil.getHardCodedConnection()){
			System.out.println("hello");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 1;
	}
	
		
}

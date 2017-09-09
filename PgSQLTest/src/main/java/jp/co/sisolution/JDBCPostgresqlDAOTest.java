package jp.co.sisolution;

public class JDBCPostgresqlDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDAO dao = new UserDAO();
		
		User user = new User();
		user.setUser_id(100);
		user.setUsername("YUN");
		
		int result = dao.insert(user);
		if(result > 0) {
			System.out.println("Insert User Successed.");
		}
	}

}

import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new Controller(new Fenetre(), new DAOCity(Singleton.getInstance().cnx));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

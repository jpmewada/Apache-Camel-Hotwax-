package Came_Gradle;

public class HCRecommendationJob {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Making sure driver class can be loaded ...");

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Err, couldn't load MySQL Driver, exiting ...");
			System.exit(0);
		}
		System.out.println("------success-------");

	}

}

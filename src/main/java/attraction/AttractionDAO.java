package attraction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




public class AttractionDAO {
	private Connection conn;
	private ResultSet rs;
	
	public AttractionDAO() {
		try {
			String dbURL = "jdbc:mysql://teamproject.cor0tt1ne1ys.ap-northeast-2.rds.amazonaws.com:3306/teamproject";
			String dbID = "admin";
			String dbPassword = "123456789";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//모든 여행지 정보 가져오기
		public ArrayList<Attraction_> getList()
		{
			String SQL = "SELECT * FROM attraction";
			
			ArrayList<Attraction_> list = new ArrayList<Attraction_>();
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {

					Attraction_ attraction = new Attraction_();
					attraction.setID(rs.getString(1));
					attraction.setScore(rs.getFloat(2));
					attraction.setTitle(rs.getString(3));
					attraction.setAddr(rs.getString(4));
					attraction.setX(rs.getString(5));
					attraction.setY(rs.getString(6));
					attraction.setFirstImg(rs.getString(7));
					attraction.setFirstImg2(rs.getString(8));
					attraction.setOverview(rs.getString(9));
					attraction.setThemas1(rs.getFloat(10));
					attraction.setThemas2(rs.getFloat(11));
					attraction.setThemas3(rs.getFloat(12));
					attraction.setThemas4(rs.getFloat(13));
					attraction.setThemas5(rs.getFloat(14));
					attraction.setThemas6(rs.getFloat(15));
					attraction.setThemas7(rs.getFloat(16));
					list.add(attraction);

				}
							
			} catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		//여행지 정보 받아오기
		public Attraction_ getAttractionInfo(int attractionID) {
			
			String SQL = "SELECT * FROM attraction WHERE attractionID = ?";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1,  attractionID);
				rs= pstmt.executeQuery();
				if(rs.next())
				{
					Attraction_ attraction = new Attraction_();
					attraction.setID(rs.getString(1));
					attraction.setScore(rs.getFloat(2));
					attraction.setTitle(rs.getString(3));
					attraction.setAddr(rs.getString(4));
					attraction.setX(rs.getString(5));
					attraction.setY(rs.getString(6));
					attraction.setFirstImg(rs.getString(7));
					attraction.setFirstImg2(rs.getString(8));
					attraction.setOverview(rs.getString(9));
					attraction.setThemas1(rs.getFloat(10));
					attraction.setThemas2(rs.getFloat(11));
					attraction.setThemas3(rs.getFloat(12));
					attraction.setThemas4(rs.getFloat(13));
					attraction.setThemas5(rs.getFloat(14));
					attraction.setThemas6(rs.getFloat(15));
					attraction.setThemas7(rs.getFloat(16));
					return attraction;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null; 
			
			
		}
		
}

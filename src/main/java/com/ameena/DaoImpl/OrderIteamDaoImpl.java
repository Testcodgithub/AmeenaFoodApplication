package com.ameena.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ameena.DButills.DButills;
import com.ameena.Dao.OrderIteamDao;
import com.ameena.model.OrderIteam;

public class OrderIteamDaoImpl implements OrderIteamDao {
	Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;

    ArrayList<OrderIteam> orderIteamList = new ArrayList<OrderIteam>();
    OrderIteam orderIteam;

    private static final String ADD_ORDERITEAM = "INSERT INTO `orderiteam`(`orderId`, `menuId`, `quantity`, `subTotal`) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM `orderiteam`";
    private static final String SELECT_ON_ORDER_ID = "SELECT * FROM `orderiteam` WHERE `orderId`=?";
    
    public OrderIteamDaoImpl() {
        try {
            con = DButills.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
	public int addOderIteam(OrderIteam ot) {
		int status = 0;
        try {
            pstmt = con.prepareStatement(ADD_ORDERITEAM);
            pstmt.setInt(1, ot.getOrderId());
            pstmt.setInt(2, ot.getMenuId());
            pstmt.setInt(3, ot.getQuantity());
            pstmt.setFloat(4, ot.getSubTotal());
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
	}

	@Override
	public ArrayList<OrderIteam> getAllOderIteams() {
		 try {
	            stmt = con.createStatement();
	            resultSet = stmt.executeQuery(SELECT_ALL);
	            orderIteamList = extractOrderIteamFromResultSet(resultSet);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return orderIteamList;
	}

	@Override
	public OrderIteam getSpecificOrderIteam(int orderId) {
		try {
            pstmt = con.prepareStatement(SELECT_ON_ORDER_ID);
            pstmt.setInt(1, orderId);
            resultSet = pstmt.executeQuery();
            ArrayList<OrderIteam> resultList = extractOrderIteamFromResultSet(resultSet);
            if (!resultList.isEmpty()) {
                orderIteam = resultList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderIteam;
	}
	
	private ArrayList<OrderIteam> extractOrderIteamFromResultSet(ResultSet resultSet) {
        ArrayList<OrderIteam> list = new ArrayList<OrderIteam>();
        try {
            while (resultSet.next()) {
                list.add(new OrderIteam(
                    resultSet.getInt("oderIteamId"),
                    resultSet.getInt("orderId"),
                    resultSet.getInt("menuId"),
                    resultSet.getInt("quantity"),
                    resultSet.getFloat("subTotal")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

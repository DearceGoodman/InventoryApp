package dev.revature.DAO.Implementation;

import dev.revature.DAO.Abstract.ItemsDAO;
import dev.revature.Entities.Items;
import dev.revature.Utility.DatabaseConnection;

import java.sql.*;

public class ItemsDAOImp implements ItemsDAO {
    @Override
    public Items createItems(Items items) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into item_db values (default, ?,?,?,?,?,?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, items.getItemName());
            preparedStatement.setInt(2,items.getExpirationDate());
            preparedStatement.setInt(3, items.getProductSize());
            preparedStatement.setString(4, items.getItemLocation());
            preparedStatement.setString(5, items.getItemType());
            preparedStatement.setInt(6, items.getStockAmount());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            items.setItemNumber(items.getItemNumber());
            return items;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean deleteItems(int itemNumber) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "delete from item_db where item_number = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, itemNumber);
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return true;
    }

    @Override
    public Items decrementItemCount(Items items) {
        try(Connection connection = DatabaseConnection.createConnection()) {
            String sql = "update item_db set stock_amount = ? where item_number = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, items.getStockAmount());
            preparedStatement.executeUpdate();
            return items;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Items incrementItemCount(Items items) {
        try(Connection connection = DatabaseConnection.createConnection()) {
            String sql = "update item_db set stock_amount = ? where item_number = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, items.getStockAmount());
            preparedStatement.executeUpdate();
            return items;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }

}

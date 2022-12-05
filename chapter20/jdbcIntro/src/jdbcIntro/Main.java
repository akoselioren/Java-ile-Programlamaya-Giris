package jdbcIntro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException {
		deleteData();

	}

	public static void selectDemo() throws SQLException {
		Connection connection = null;
		DbHelper helper = new DbHelper();
		Statement statement = null;
		ResultSet resultSet;
		try {
			connection = helper.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select Code,Name,Continent,Region from country");
			ArrayList<Country> contiries = new ArrayList<Country>();
			int i = 1;
			while (resultSet.next()) {
				contiries.add(new Country(resultSet.getString("Code"), resultSet.getString("Name"),
						resultSet.getString("Continent"), resultSet.getString("Region")));
				System.out.println(i + ". Country : " + resultSet.getString("Name"));
				i++;
			}
			System.out.println("Total Country size: " + contiries.size());
		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			connection.close();
		}

	}

	public static void insertData() throws SQLException {
		Connection connection = null;
		DbHelper helper = new DbHelper();
		PreparedStatement statement = null;
		ResultSet resultSet;
		try {
			connection = helper.getConnection();
			String sql = "insert into city (Name,CountryCode,District,Population) values(?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "Düzce");
			statement.setString(2, "TUR");
			statement.setString(3, "Turkey");
			statement.setInt(4, 70000);
			int result = statement.executeUpdate();
			System.out.println("Kayıt eklendi :" + result);
		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}

	public static void updateData() throws SQLException {
		Connection connection = null;
		DbHelper helper = new DbHelper();
		PreparedStatement statement = null;
		try {
			connection = helper.getConnection();
			String sql = "update city set population=440905 where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 7);
			int result = statement.executeUpdate();
			System.out.println("Kayıt eklendi :" + result);
		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}
	public static void deleteData() throws SQLException {
		Connection connection = null;
		DbHelper helper = new DbHelper();
		PreparedStatement statement = null;
		try {
			connection = helper.getConnection();
			String sql = "delete from city where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 7);
			int result = statement.executeUpdate();
			System.out.println("Kayıt silindi :" + result);
		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}
}

package app.start;

import udel.cisc637.steven.db.MysqlConnector;

public class TestConnection {

	public static void main(String[] args){
		MysqlConnector.getInstance();
	}
}

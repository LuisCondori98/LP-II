package app;

import java.sql.SQLException;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo01 {

	public static void main(String[] args) throws SQLException {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("");
		
		
	}
}

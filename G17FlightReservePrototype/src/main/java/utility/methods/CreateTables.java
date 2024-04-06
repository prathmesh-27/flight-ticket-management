package utility.methods;

import java.sql.Connection;

import form.controller.DBConnection;

public class CreateTables {
	public static void createBookingData() {
		try (Connection con = DBConnection.getDBConnection(); java.sql.Statement stmt = con.createStatement();) {

			String createBookingdata = "CREATE TABLE `database_1`.`booking_data` (\r\n"
					+ "  `_id` INT NOT NULL AUTO_INCREMENT,\r\n" + "  `username` VARCHAR(45) NOT NULL,\r\n"
					+ "  `uid` VARCHAR(45) NOT NULL,\r\n" + "  `fid` VARCHAR(45) NOT NULL,\r\n"
					+ "  `number_of_passengers` DOUBLE NOT NULL,\r\n" + "  `total_cost` VARCHAR(45) NOT NULL,\r\n"
					+ "  PRIMARY KEY (`_id`),\r\n" + "  UNIQUE INDEX `_id_UNIQUE` (`_id` ASC) VISIBLE);";

			if (stmt.executeUpdate(createBookingdata) == 0) {
				System.out.println("Table created");
			} else {
				System.out.println("not created table");
			}

		} catch (Exception e) {
			System.out.println("Error is" + e.getMessage());

		}

	}

	public static void createPaymentData() {
		try (Connection con = DBConnection.getDBConnection(); java.sql.Statement stmt = con.createStatement();) {

			String createPaymentdata = "CREATE TABLE `database_1`.`payment_data` (\r\n"
					+ "  `transaction_id` VARCHAR(19) NOT NULL,\r\n" + "  `user_id` VARCHAR(45) NOT NULL,\r\n"
					+ "  `flight_id` VARCHAR(45) NOT NULL,\r\n" + "  `book_id` INT NOT NULL,\r\n"
					+ "  `fullname` VARCHAR(45) NOT NULL,\r\n" + "  `card_number` VARCHAR(45) NOT NULL,\r\n"
					+ "  `cvv` INT NOT NULL,\r\n" + "  `expiry_date` VARCHAR(45) NOT NULL,\r\n"
					+ "  `Date_of_payment` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,\r\n"
					+ "  `amount_paid` DOUBLE NOT NULL,\r\n" + "  PRIMARY KEY (`transaction_id`),\r\n"
					+ "  UNIQUE INDEX `transaction_id_UNIQUE` (`transaction_id` ASC) VISIBLE);";

			if (stmt.executeUpdate(createPaymentdata) == 0) {
				System.out.println("Table created");
			} else {
				System.out.println("not created table");
			}

		} catch (Exception e) {
			System.out.println("Error is" + e.getMessage());

		}
	}
}

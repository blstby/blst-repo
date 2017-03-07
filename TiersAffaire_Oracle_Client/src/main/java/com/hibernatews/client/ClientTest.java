package com.hibernatews.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hibernatews.service.Affaires;
import com.hibernatews.service.Exception_Exception;
import com.hibernatews.service.ServicesImplService;

public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServicesImplService service = new ServicesImplService();
		Affaires stub = service.getServicesImplPort();
		BufferedReader br = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				System.out.print("Enter something : ");
				String input = br.readLine();
				if ("q".equals(input)) {
					System.out.println("Exit!");
					System.exit(0);
				}
				System.out.print("Enter something : ");
				String input2 = br.readLine();
				stub.newTiers(input, input2);

				System.out.println("input : " + input);
				System.out.println("-----------\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}

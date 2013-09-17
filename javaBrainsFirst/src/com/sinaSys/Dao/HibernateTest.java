package com.sinaSys.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sinaSys.model.UserDetails;
import com.sinaSys.model.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {
		UserDetails details = new UserDetails();
		details.setUserName("first sina");
		details.setDate(new Date());

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("motorCycle");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");

		details.getVehicles().add(vehicle);
		details.getVehicles().add(vehicle1);

		vehicle.getUsers().add(details);
		vehicle1.getUsers().add(details);

		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();

		SessionFactory factory = configuration.buildSessionFactory(registry);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(vehicle1);
		session.save(vehicle);
		session.save(details);

		transaction.commit();
		session.close();

		// session = factory.openSession();
		// List<Vehicle> list = new ArrayList<>();
		// list = (List<Vehicle>) ((UserDetails) session.get(UserDetails.class,
		// 3))
		// .getVehicles();
		// for (Vehicle vehicle2 : list) {
		// System.out.println(vehicle2.getVehicleName());
		// }

	}
}

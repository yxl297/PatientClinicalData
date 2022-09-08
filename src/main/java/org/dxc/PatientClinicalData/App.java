package org.dxc.PatientClinicalData;

import java.util.ArrayList;
import java.util.List;

import org.dxc.Entity.ClinicalData;
import org.dxc.Entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Failed to create Session");
			throw new ExceptionInInitializerError(e);
		}
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Patient p1 = new Patient();
		p1.setFirstname("YX");
		p1.setLastname("Lim");
		p1.setAge(28);

		Patient p2 = new Patient();
		p2.setFirstname("JH");
		p2.setLastname("Lee");
		p2.setAge(28);

		ClinicalData clinicalHeight1 = new ClinicalData();
		clinicalHeight1.setComponentName("Height");
		clinicalHeight1.setComponentValue(170);
		clinicalHeight1.setMeasuredDateTime(java.sql.Date.valueOf(java.time.LocalDate.now()));

		ClinicalData clinicalWeight1 = new ClinicalData();
		clinicalWeight1.setComponentName("Weight");
		clinicalWeight1.setComponentValue(70);
		clinicalWeight1.setMeasuredDateTime(java.sql.Date.valueOf(java.time.LocalDate.now()));
		
		ClinicalData clinicalHeight2 = new ClinicalData();
		clinicalHeight2.setComponentName("Height");
		clinicalHeight2.setComponentValue(170);
		clinicalHeight2.setMeasuredDateTime(java.sql.Date.valueOf(java.time.LocalDate.now()));

		ClinicalData clinicalWeight2 = new ClinicalData();
		clinicalWeight2.setComponentName("Weight");
		clinicalWeight2.setComponentValue(70);
		clinicalWeight2.setMeasuredDateTime(java.sql.Date.valueOf(java.time.LocalDate.now()));
		
		List<ClinicalData> data1 = new ArrayList<ClinicalData>();
		List<ClinicalData> data2 = new ArrayList<ClinicalData>();
		
		data1.add(clinicalHeight1);
		data1.add(clinicalWeight1);
		
		data2.add(clinicalHeight2);
		data2.add(clinicalWeight2);
		
		p1.setClinicalData(data1);
		p2.setClinicalData(data2);

		session.persist(p1);
		session.persist(p2);

		tx.commit();

		session.close();
		System.out.println("success");
	}
}

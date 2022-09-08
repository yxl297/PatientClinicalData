package org.dxc.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ClinicalData")
public class ClinicalData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String componentName;
	private int componentValue;
	private Date measuredDateTime;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}


	public Date getMeasuredDateTime() {
		return measuredDateTime;
	}

	public void setMeasuredDateTime(Date measuredDateTime) {
		this.measuredDateTime = measuredDateTime;
	}

	public int getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(int componentValue) {
		this.componentValue = componentValue;
	}

}

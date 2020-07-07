package version_without_rules;

public class Student extends Person {
    private String parentName;
    private String address;
    private String phoneNumber;
    private double gpa;
    private boolean overdue;

    public Student() {
    
    }

    public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public boolean isOverdue() {
		return overdue;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	@Override
	public String toString() {
		return "Student [Name: " + getName() + ", Age: " + getAge()+ ", Gpa: " + gpa + ", ParentName: " + parentName + ", address: " + address + ", phoneNumber: " + phoneNumber + "]";
	}

    
}

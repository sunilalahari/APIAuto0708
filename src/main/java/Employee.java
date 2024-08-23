
public class Employee{
		String name;
		String dept;
		int empNo;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public int getEmpNo() {
			return empNo;
		}
		public void setEmpNo(int empNo) {
			this.empNo = empNo;
		}
		@Override
		public String toString() {
			return "Employee [name=" + name + ", dept=" + dept + ", empNo=" + empNo + "]";
		}
		public Employee(String name, String dept, int empNo) {
			super();
			this.name = name;
			this.dept = dept;
			this.empNo = empNo;
		}
		
		
	}




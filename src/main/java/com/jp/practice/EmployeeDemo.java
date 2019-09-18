/**
 * 
 */
package com.jp.practice;

import java.util.List;

/**
 * @author jaiprakash
 *
 */
public class EmployeeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String json = "[{\"id\":\"155835\",\"employee_name\":\"test2\",\"employee_salary\":\"123\",\"employee_age\":\"23\",\"profile_image\":\"\"},{\"id\":\"155836\",\"employee_name\":\"test3\",\"employee_salary\":\"124\",\"employee_age\":\"24\",\"profile_image\":\"\"}]";
		List employees = Employee.toEmployeeList(json);
		for(int i=0; i<employees.size();i++) {
			Employee emp = (Employee)employees.get(i);
			System.out.print(emp.getId() + " ");
			System.out.print(emp.getEmployee_name()+ " ");
			System.out.print(emp.getEmployee_salary());
			System.out.println();
		}
	}

}

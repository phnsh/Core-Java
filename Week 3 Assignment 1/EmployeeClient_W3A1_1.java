import java.util.Arrays;

abstract class Employee {
    public int id;
    public String name;
    public int age;
    public String projectName;
    public boolean applyLeave = false;
    public String[] skills;

    Employee(int id, String name, int age, String projectName, String[] skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.projectName = projectName;
        this.skills = skills;
    }
    public abstract boolean canApplyLeave(int duration);
    public abstract void getEmployeeDetails();
}

class RegularEmployee extends Employee {
    private static int leaveBalance = 20; //days
    private static double fixedSalary;
    private static double bonus;

    RegularEmployee(int id, String name, int age, String projectName, String[] skills, double fixedSalary, double bonus) {
        super(id, name, age, projectName, skills);
        this.fixedSalary = fixedSalary;
        this.bonus = bonus;
    }

    @Override
    public boolean canApplyLeave(int duration) {
        if(leaveBalance > duration) {
            applyLeave = true;
            leaveBalance -= duration;
        }
        return applyLeave;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }
    
    public void getEmployeeDetails() {
        System.out.println(
            "Employee ID: " + id +
            "\nEmployee Name: " + name +
            "\nEmployee age: " + age +
            "\nProject name: " + projectName +
            "\nSkills: " + Arrays.toString(skills) +
			"\nBonus: " + bonus +
			"\nLeave Balance: " + leaveBalance
        );
    }
}

class ContractEmployee extends Employee {
    private static int contractDuration = 60; //days
    private static double payPerHour;

    ContractEmployee(int id, String name, int age, String projectName, String[] skills, double payPerHour) {
        super(id, name, age, projectName, skills);
        this.payPerHour = payPerHour;
    }

    @Override
    public boolean canApplyLeave(int duration) {
        if(contractDuration > duration) {
            applyLeave = true;
            contractDuration += duration;
        }
        return applyLeave;
    }

    public int getRemainingContractDuration() {
        return contractDuration;
    }
    
    @Override
    public void getEmployeeDetails() {
        System.out.println(
            "Employee ID: " + id +
            "\nEmployee Name: " + name +
            "\nEmployee age: " + age +
            "\nProject name: " + projectName +
            "\nSkills: " + Arrays.toString(skills) +
			"\nPay per hour: " + payPerHour +
			"\nRemaining contract period days: " + contractDuration + " days"
        );
    }
}

public class EmployeeClient_W3A1_1 {
    public static void main(String args[]) {
        String emp1Skills[] = {"Java", "Spring", "JS", "Shell scripting"};
        RegularEmployee regEmp1 = new RegularEmployee(12, "anon1", 34, "prism", emp1Skills, 340000, 20000);
        System.out.println(regEmp1.canApplyLeave(12));
        System.out.println(regEmp1.getLeaveBalance());
        regEmp1.getEmployeeDetails();
        if(regEmp1.canApplyLeave(5)) {
            System.out.println("New leave balance: " + regEmp1.getLeaveBalance());
        }
        
        System.out.println();

        String contractEmp1Skills[] = {"Pen testing", "Network Security", "Data analysis"};
        ContractEmployee contractEmp1 = new ContractEmployee(29, "anon2", 29, "ufo", contractEmp1Skills, 10);
        if(contractEmp1.canApplyLeave(13)) {
            System.out.println("Your new contract period: " + contractEmp1.getRemainingContractDuration() + " days");
		}
		contractEmp1.getEmployeeDetails();
    }
}
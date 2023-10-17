import java.util.ArrayList;
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    // @override
    public String toString(){
        return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}

class FulltimeEmployee extends Employee{
    private double monthlySalary;

    public FulltimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    // @override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployeee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployeee(String name,int id,int hoursWorked,double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    // @override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}

class Payroll{
    private ArrayList<Employee> empolyeeList;
    public Payroll(){
        empolyeeList= new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        empolyeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeToRemove = null;
        for(Employee employee:empolyeeList){
            if(employee.getId()==id){
                employeToRemove=employee;
                break;
            }
        }
            if(employeToRemove != null){
                empolyeeList.remove(employeToRemove);
            }
    }

    public void displayEmployee(){
        for(Employee employee: empolyeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Payroll Payrollobj=new Payroll();
        FulltimeEmployee emp1=new FulltimeEmployee("vikas",1,17000);
        PartTimeEmployeee emp2=new PartTimeEmployeee("sachi",2,20,250);
        Payrollobj.addEmployee(emp1);
        Payrollobj.addEmployee(emp2);
        System.out.println();
        System.out.println("********** <<< EMPLOYEE PAYROLL SYSTEM >>> **********");
        System.out.println("Intinal Employee Details : ");
        Payrollobj.displayEmployee();
        System.out.println();
        System.out.println("Removing Employee....");
         System.out.println();
        Payrollobj.removeEmployee(2);
        System.out.println("Remaning Employee Details : ");
        Payrollobj.displayEmployee();
        System.out.println();
        System.out.println("********** <<< EMPLOYEE PAYROLL SYSTEM >>> **********");
    }
    
}
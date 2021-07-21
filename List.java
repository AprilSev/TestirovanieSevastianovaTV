package dz5;

public class List {

    public static void main (String[] args) {

        Employee employee1 = new Employee("IvanovVV","accountant",89219999911L,10000,41);
        Employee employee2 = new Employee("PetrovVV", "manager", 89219990000L, 12000, 30);
        Employee employee3 = new Employee("SidorovVV", "developer", 89217778778L, 35000, 37);
        Employee employee4 = new Employee("VasilevaSS", "secretary", 89218882882L, 10000, 25);
        Employee employee5 = new Employee("LukovaSS", "cleaner", 89216662662L, 9000, 50);
        System.out.println(employee1.getFCS());
        System.out.println(employee1.getPost());
        System.out.println(employee1.getId() + " | " + employee2.getId() + " | " + employee3.getId() + " | " + employee4.getId() + " | " + employee5.getId());

        Employee[] emplArray = {employee1, employee2, employee3, employee4, employee5};

        older40(emplArray);
        salaryIncreas(emplArray); //повышение зарплаты
        System.out.println("******************");
        newSalary(emplArray); // вывод новой зарплаты

    }

    public static void older40 (Employee[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
          if (inArray[i].getAge() > 40)  {
              inArray[i].printInfo();
          }
        }
    }

    public static void salaryIncreas (Employee[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i].getAge() > 35) {
                inArray[i].increas();
            }
        }
    }

    public static void newSalary (Employee[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i].getAge() > 35) {
                inArray[i].printInfo();
            }
        }
    }
}

package dz5;

public class Employee {

   private String sNP;
   private String post;
   private long telephone;
   private int salary;
   private int age;
   private static int idSequence = 0;
   private int id;

   public Employee (String valueSNP, String valuePost, long valueTelephone, int valueSalary, int valueAge) {
       sNP = valueSNP;
       post = valuePost;
       telephone = valueTelephone;
       salary = valueSalary;
       age = valueAge;
       id = ++idSequence; // При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
   }

   public String getFCS() {
       return sNP;
   }
   public String getPost() {
       return post;
   }
   public long getTelephone() {
       return telephone;
   }
   public int getSalary() {
       return salary;
   }
   public int getAge() {
       return age;
   }
   public int getId() {
       return id;
   }

   public void printInfo() {
       System.out.println(" ID: " + id + " SNP: " + sNP + " Post: " + post + " Telephone: " + telephone + " Salary: " + salary + " Age: " + age );
   }

   public int increas() {
       return salary = salary + 10000;
   }
}

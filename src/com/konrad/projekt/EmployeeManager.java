package com.konrad.projekt;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Konrad on 02.02.2017.
 */
public class EmployeeManager implements Serializable {

    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployeeByLastName(String lastName) {
        Employee emp;
        Iterator<Employee> i = employees.iterator();
        while (i.hasNext()) {
            emp = i.next();
            if(emp.getLastName().toLowerCase().contentEquals(lastName.toLowerCase())) {
                return emp;
            }
        }
        return null;
    }

    public Employee getEmployeeByHrid(int hrid) {
        Employee emp;
        Iterator<Employee> i = employees.iterator();
        while( i.hasNext() ) {
            emp = i.next();
            if(emp.getHrid()==hrid) {
                return emp;
            }
        }
        return null;
    }

    public void getByOne() {

        Boolean running = true;
        int chooser = -1;
        Employee e;
        ListIterator<Employee> i = null;
        i=employees.listIterator();
        Scanner in = new Scanner(System.in);
        if(!(i.hasNext())) {
            System.out.println("Nie ma żadnego pracownika na liście");
        } else {
            e = i.next();
            while (running) {
                System.out.println(e.toString());
                System.out.println("\nWybierz 1 aby usunąć pracownika" +
                        "\nWybierz 2 aby przejsc do poprzedniego pracownika" +
                        "\nWybierz 3 aby przejsc do nastepnego pracownika" +
                        "\nWybierz 0 aby wrócić do głównego okna aplikacji");
                chooser = ProgramUtils.getInt();
                while (chooser == -1)
                    ProgramUtils.getInt();
                switch (chooser) {
                    case 1:
                        i.remove();
                        System.out.println("Pracownik został usunięty");
                        if (i.hasNext()) {
                            i.next();
                        } else {
                            System.out.println("Nie ma więcej pracowników!");
                            i.previous();
                        }
                        break;
                    case 2:
                        if (i.hasPrevious()) {
                            i.previous();
                        } else {
                            System.out.println("Przeglądasz już dane ostatniego pracownika!");
                            i.next();
                        }
                        break;
                    case 3:
                        if(i.hasNext()) {
                            i.next();
                        } else {
                            System.out.println("Przegladasz już dane ostatniego pracownika!");
                            i.previous();
                        }
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Wybierz prawidłową liczbę");
                }
            }
        }
    }

    public void sortDesc() {
        Collections.sort(employees, new MyHridComparatorDesc());
    }

    public void sortAsc() {
        Collections.sort(employees, new MyHridComparatorAsc());
    }

    @Override
    public String toString() {
        String all = "\n";
        Iterator<Employee> i = employees.iterator();
        while(i.hasNext()) {
            Employee emp = i.next();
            all = all + emp.toString();
        }
        return all;
    }
}

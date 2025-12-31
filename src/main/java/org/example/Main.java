package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Employee> employeeList= new LinkedList<>();
        employeeList.add(new Employee(1, "Dogancan", "Kinik"));
        employeeList.add(new Employee(1, "Dogancan", "Kinik"));
        employeeList.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employeeList.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employeeList.add(new Employee(3, "Anil", "Ensari"));
        employeeList.add(new Employee(3, "Anil", "Ensari"));
        employeeList.add(new Employee(4, "Burak", "Cevizli"));
        employeeList.add(null);

        System.out.println(findDuplicates(employeeList));
        System.out.println(findDuplicatesOptimized(employeeList));
        System.out.println(removeDuplicates(employeeList));
        System.out.println(removeDuplicatesOptimized(employeeList));

    }

    public static List<Employee> findDuplicates(List<Employee> list){

        List<Employee> donusList = new LinkedList<>();
        List<Employee> copyList = new LinkedList<>(list);

        copyList.removeIf(Objects::isNull);

        for(int i = 0 ; i<copyList.size();i++){


            Employee copyEmployee = copyList.get(i);

            int say = 0;
            for(Employee employee: copyList){
                if(copyEmployee.getId()==employee.getId()){
                    say++;
                }
            }
            if(say>1&&!donusList.contains(copyEmployee)){
                donusList.add(copyEmployee);
            }
        }
        return donusList;
    }

    public static List<Employee> findDuplicatesOptimized(List<Employee> list){

        List<Employee> donusList = new LinkedList<>();
         for(Employee employee: list){
             if (employee == null) continue;

             if(Collections.frequency(list,employee)>1&&!donusList.contains(employee)){
                 donusList.add(employee);
             }
         }

        return donusList;
    }

    public static Map<Integer,Employee> findUniques(List<Employee> list){
        List<Employee> copyList = new LinkedList<>(list);
        copyList.removeIf(Objects::isNull);
        Map<Integer, Employee> mapEmployee = new HashMap<>();
        copyList.forEach(e->mapEmployee.put(e.getId(),e));
        return mapEmployee;
    }

    public static List<Employee> removeDuplicates(List<Employee> list){


        List<Employee> donusList = new LinkedList<>(list);
        List<Employee> copyList = new LinkedList<>(list);
        copyList.removeIf(Objects::isNull);
        donusList.removeIf(Objects::isNull);

        for(int i = 0 ; i<copyList.size();i++){

            Employee copyEmployee = copyList.get(i);

            int say = 0;
            for(Employee employee: copyList){
                if(copyEmployee.getId()==employee.getId()){
                    say++;
                }
            }
            if(say>1){
                donusList.remove(copyEmployee);
            }
        }
        return donusList;
    }

    public static List<Employee> removeDuplicatesOptimized(List<Employee> list){


        List<Employee> donusList = new LinkedList<>();
        for(Employee employee: list){
            if (employee == null) continue;

            if(Collections.frequency(list,employee)==1 && !donusList.contains(employee)){
                donusList.add(employee);
            }
        }

        return donusList;
    }
}
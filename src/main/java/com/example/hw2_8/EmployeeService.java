package com.example.hw2_8;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final static Map<String, Employee> allEmployee=new HashMap<>();


    public  EmployeeService (){

        allEmployee.put ( "FrolovaKatya",new Employee("Frolova","Katya"));
        allEmployee.put("FisherKatya",new Employee("Fisher", "Katya"));
        allEmployee.put("FricKatya", new Employee("Fric","Katya"));
        allEmployee.put("FlowerKatya", new Employee("Flower","Katya"));
        allEmployee.put( "FeetKatya",new Employee("Feet","Katya"));
        allEmployee.put("IvanovIvan" ,new Employee("Ivanov", "Ivan"));

    }

    public static Map<String, Employee> findAll(){  //возврщает и ключ и значение
        return allEmployee;
    }

    public static Employee addEmployee(String lastName,String firstName) { // возвращает только значение
        Employee newEmployee = new Employee(lastName,firstName);
        String kayAdd=lastName+firstName;
        if (lastName == null || firstName == null) {
            System.out.println("отсутсвует первый или второй параметр");
            return null;
        } else if (allEmployee.containsKey(kayAdd)) {
            throw new EmployeeAlreadyAddedException("такой уже есть");
        } else {
            allEmployee.put(kayAdd,newEmployee);
        }
        return newEmployee;
    }


//    public static Employee findEmployee (String firstName,String lastName){
//        Employee findEmployee = new Employee(lastName,firstName);
//        if(firstName == null || lastName == null) {
//            System.out.println("отсутсвует первый и/или второй параметр");
//            return null;
//        }else if ( !allEmployee.containsKey(findEmployee)) {
//            throw new EmployeeNotFoundException("сотрудник не найден");
//        } else {
//            //System.out.println(findEmployee);
//            return  findEmployee;
//        }
//    }

    public static  Employee removeEmployee(String lastName,String firstName){
        Employee removeEmployee = new Employee(lastName,firstName);
        String kayAdd2=lastName+firstName;
        if(firstName == null || lastName == null) {
            System.out.println("отсутсвует первый или второй параметр");
            return null;
        }else if (!allEmployee.containsKey(kayAdd2)) {
            throw new EmployeeNotFoundException("сотрудник не найден");
        } else {
           allEmployee.remove(kayAdd2);
        }
        return  removeEmployee;
    }

}





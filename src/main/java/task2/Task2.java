package task2;

import com.github.javafaker.Faker;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args){


        //Was to lazy to come up with 15 fake employees
        List<Employee> listen = createFakes();

        //initial list
        System.out.println("initial employees: ");
        printEmps(listen);
        System.out.println();

        //if the amount is given as x use amountIncrease as a method to change the amount
        System.out.println("10 unit increase in their wage: ");
        lonnsOppgor(listen, amountIncrease(10));
        printEmps(listen);
        System.out.println();

        //percentage increase
        //percentIncrease in a method incase of a change in %
        System.out.println("10% increase in their wage: ");
        lonnsOppgor(listen, percentIncrease(10));
        printEmps(listen);
        System.out.println();

        //percent increase if low income with a specification of what poor means and x%
        System.out.println("give 10% to the employees that earn less than 500k: ");
        lonnsOppgor(listen, giveToThePoor(500_000,10));
        printEmps(listen);
        System.out.println();

        //percent increase if man
        System.out.println("give 10% increase if they are a man: ");
        lonnsOppgor(listen, manPower(10));
        printEmps(listen);
        System.out.println();

        //x nok increase if poor

        System.out.println("Give 100 unit rase if they earn less than 500k: ");
        lonnsOppgor(listen, giveToThePoor2(500_000, 100));
        printEmps(listen);
        System.out.println();


    }

    public static List<Employee> createFakes(){
        Faker faker = new Faker();
        List<Employee> fakes = new java.util.ArrayList<>(IntStream.range(0, 15)
                .mapToObj(i -> new Employee(faker.name().firstName(), faker.name().lastName(),
                        faker.options().option(Gender.class), faker.job().title(),
                        faker.number().numberBetween(20000, 100000))).toList());

        fakes.add(new Employee("Bossman", "Wayne", Gender.MALE, "Managing manager", 800_001));
        return fakes;
    }

    public static void lonnsOppgor(List<Employee> empoyees, Function<Employee, Integer> calc){
        empoyees.forEach(e -> e.setWage(calc.apply(e)));
    }

    public static Function<Employee, Integer> amountIncrease(int amount){
        return emp -> emp.getWage() + amount;
    }

    public static Function<Employee, Integer> percentIncrease(int percent){
        return emp -> (int) ((emp.getWage() * ((double) percent / 100 + 1)));
    }

    public static Function<Employee, Integer> giveToThePoor(int limit, int percent){
        return emp -> {
            if (emp.getWage() > limit){
                return emp.getWage();
            } else{
                return percentIncrease(percent).apply(emp);
            }
        };
    }

    public static Function<Employee, Integer> manPower(int percent){
        return emp -> {
            if (emp.getGender() == Gender.MALE){
                return percentIncrease(percent).apply(emp);
            }else {
                return emp.getWage();
            }
        };
    }

    public static Function<Employee, Integer> giveToThePoor2(int poor, int amount){
        return emp -> {
            if (emp.getWage() < poor){
                return amountIncrease(10).apply(emp);
            } else {
                return emp.getWage();
            }
        };
    }

    public static void printEmps(List<Employee> emps){

        emps.forEach(System.out::println);

    }


}

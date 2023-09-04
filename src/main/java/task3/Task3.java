package task3;

import task2.Employee;
import task2.Gender;
import task2.Task2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Task3 {
    public static void main(String[] args){
        List<Employee> listen = Task2.createFakes();

        //task 3a
        List<String> justLastNames = listen.stream().map(Employee::getSurname).toList();
        System.out.println("etternavn til ansatte: " + justLastNames + "\n");

        //task 3b
        Predicate<Employee> getWomen = e -> e.getGender().equals(Gender.FEMALE);
        long numberOfWomen = listen.stream().filter(getWomen).count();
        System.out.println("number of women employed: " + numberOfWomen + "\n");

        //task 3c
        double wageOfWomen = listen.stream().filter(getWomen).mapToInt(Employee::getWage).average().orElse(-1);
        System.out.println("avg wage of women: " + wageOfWomen + ", if no women -1 \n");

        //task 3d
        Predicate<Employee> getManagers = e -> e.getJobTitle().toLowerCase().contains("manager");
        listen.stream().filter(getManagers).forEach(System.out::println);
        listen.stream().filter(getManagers)
                        .forEach(e -> {
                        e.setWage((int) (Math.round(e.getWage() * 1.07)));
                });
        listen.stream().filter(getManagers).forEach(System.out::println);

        boolean richExsists = listen.stream().anyMatch(e -> e.getWage() > 800_000);
        System.out.println("there are people that earn more than 800_000: " + richExsists + "\n");

        //task 3f
        listen.forEach(System.out::println);


        //task 3g
        int lowestWage = listen.stream().mapToInt(Employee::getWage).min().orElse(-1);

        List<Employee> poorestReal = lowestWage != -1 ? listen.stream().filter(e -> e.getWage() == lowestWage).toList() : null;

        System.out.println("the poorest person/people are: ");
        assert poorestReal != null;
        poorestReal.forEach(System.out::println);


        //task 3h
        int bigNum = IntStream.range(0,1000).filter(a -> a % 3 == 0 || a % 5 == 0).sum();
        System.out.println("The sum is: " + bigNum);

    }
}

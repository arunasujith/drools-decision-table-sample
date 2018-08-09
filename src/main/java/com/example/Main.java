package com.example;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {

    public static void main(String[] args) {

        Customer customer1 = new Customer();
        customer1.setName("Aruna");
        customer1.setAge(28);
        customer1.setWorkType(WorkType.GOVERNEMNT);

        Customer customer2 = new Customer();
        customer2.setName("Eroshan");
        customer2.setAge(61);
        customer2.setWorkType(WorkType.GOVERNEMNT);

        Customer customer3 = new Customer();
        customer3.setName("Gayan");
        customer3.setAge(35);
        customer3.setWorkType(WorkType.PRIVATE);


        DroolsConfiguration droolsConfiguration = new DroolsConfiguration();
        KieContainer container = droolsConfiguration.getKieContainer();

        // non retired gov person
        KieSession kieSession1 = container.newKieSession();
        ExecutionBase executionBase1 = new ExecutionBase();
        executionBase1.setCustomer(customer1);
        kieSession1.insert(executionBase1);
        kieSession1.fireAllRules();
        kieSession1.dispose();

        // retired gov person
        KieSession kieSession2 = container.newKieSession();
        ExecutionBase executionBase2 = new ExecutionBase();
        executionBase2.setCustomer(customer2);
        kieSession2.insert(executionBase2);
        kieSession2.fireAllRules();
        kieSession2.dispose();

        // private worker
        KieSession kieSession3 = container.newKieSession();
        ExecutionBase executionBase3 = new ExecutionBase();
        executionBase3.setCustomer(customer3);
        kieSession3.insert(executionBase3);
        kieSession3.fireAllRules();
        kieSession3.dispose();


    }
}

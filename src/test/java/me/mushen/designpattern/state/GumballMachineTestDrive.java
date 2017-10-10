package me.mushen.designpattern.state;

/**
 * @Desc
 * @Author Remilia
 * @Create 2017-10-10
 */
public class GumballMachineTestDrive {

    public static void main(String[] args){
        GumballMachine gumballMachine = new GumballMachine(8);
        System.out.println("GumballMachine: " + gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.dispense();
        System.out.println("GumballMachine: " + gumballMachine);
    }
}

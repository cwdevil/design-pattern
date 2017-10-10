package me.mushen.designpattern.state;

/**
 * @Desc
 * @Author Remilia
 * @Create 2017-10-10
 */
public class GumballMachine {
    // 状态
    private static final int SOLD_OUT = 0; // 售罄
    private static final int NO_QUARTER = 1; // 没有25分钱
    private static final int HAS_QUARTER = 2; // 有25分钱
    private static final int SOLD = 3; // 售出

    private int state = SOLD_OUT; // 初始状态: 售罄
    private int count = 0; // 初始数量: 0

    public GumballMachine(int count) {
        this.count = count;
        if(count > 0) { // 初始化糖果机, 如果糖果数量 > 0, 则切换状态 -> 等待投币
            state = NO_QUARTER;
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }

    /**
     * 投币
     */
    public void insertQuarter() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("You can't insert another quarter");
                break;
            case NO_QUARTER:
                state = HAS_QUARTER;
                System.out.println("You insert a quarter");
                break;
            case SOLD_OUT:
                System.out.println("You can't insert a quarter, the machine is sold out");
                break;
            case SOLD:
                System.out.println("Please wait, we're already giving you a gumball");
                break;
            default:
                System.out.println("ERROR!!!");
        }
    }

    /**
     * 退币
     */
    public void ejectQuarter() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("Quarter returned");
                state = NO_QUARTER;
                break;
            case NO_QUARTER:
                System.out.println("You haven't insert a quarter");
                break;
            case SOLD_OUT:
                System.out.println("You can't eject, you haven't insert a quarter yet");
                break;
            case SOLD:
                System.out.println("Sorry, you already turned the crank");
                break;
            default:
                System.out.println("ERROR!!!");
        }
    }

    /**
     * 转动曲柄
     */
    public void turnCrank() {
        switch (state) {
            case SOLD:
                System.out.println("Turning twice dosen't get you another gumball");
                break;
            case NO_QUARTER:
                System.out.println("You turned, but there's no quarter");
                break;
            case SOLD_OUT:
                System.out.println("You turned, but there are no gumballs");
                break;
            case HAS_QUARTER:
                System.out.println("You turned...");
                state = SOLD;
                dispense();
                break;
            default:
                System.out.println("ERROR!!!");
        }
    }

    /**
     * 发放糖果
     */
    public void dispense() {
        switch (state) {
            case SOLD:
                System.out.println("A gumball comes rolling out the slot");
                count--;
                if(count == 0) {
                    System.out.println("Oops, out of gumballs");
                    state = SOLD_OUT;
                }else {
                    state = NO_QUARTER;
                }
                break;
            case NO_QUARTER:
                System.out.println("You need to pay first");
                break;
            case SOLD_OUT:
                System.out.println("No gumball dispensed, because sold out");
                break;
            case HAS_QUARTER:
                System.out.println("No gumball dispensed, because error state");
                break;
            default:
                System.out.println("ERROR!!!");
        }
    }
}
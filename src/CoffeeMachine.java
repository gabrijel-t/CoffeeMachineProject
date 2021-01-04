import java.util.Scanner;
public class CoffeeMachine {

    int water =400;
    int milk = 540;
    int beans = 120;
    int disposableCup =9;
    int money = 550;

    public static void main(String[] args) {;
        CoffeeMachine machine = new CoffeeMachine();

        machine.manager();


    }

    public void manager(){
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scan.nextLine();
            System.out.println("");
            if (action.equals("buy")) {
                buy();
            } else if (action.equals("fill")) {
                fill();
            } else if (action.equals("take")) {
                take();
            } else if (action.equals("remaining")) {
                display();
            } else if (action.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid operation");
            }
        }while(true);
    }

    public void display(){
        System.out.println("The coffee machine has: ");
        System.out.println(water+ " of water");
        System.out.println(milk+" of milk");
        System.out.println(beans+" of coffee beans");
        System.out.println(disposableCup+" of disposable cups");
        System.out.println("$"+money+" of money\n");
    }

    public void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        Scanner s = new Scanner(System.in);
        String option = s.nextLine();
        if(option.equals("1") && checkResources(option)){
            water -= 250;
            beans -= 16;
            money +=4;
            disposableCup--;
        }else if(option.equals("2") && checkResources(option)){
            water -= 350;
            milk -= 75;
            beans -= 20;
            money+= 7;
            disposableCup--;
        }else if(option.equals("3") && checkResources(option)){
            water -= 200;
            milk -= 100;
            beans-= 12;
            money+=6;
            disposableCup--;
        }else if(option.equals("back")){
            // go back to main menu;

        }
    }

    public void fill(){
        Scanner s = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water+= s.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += s.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += s.nextInt();
        System.out.println("Write how many disposable cups do you want to add:");
        disposableCup+= s.nextInt();
        System.out.println();
        //display();
    }

    public void take(){
        System.out.println("I gave you $"+money);
        money =0;
        //display();
    }

    public boolean checkResources(String option){
        boolean result = false;
        if(disposableCup>=1) {
            if (option.equals("1")) {
                if (water >= 250) {
                    if (beans >= 16) {
                        System.out.println("I have enough resources, making you a coffee!");
                        result = true;
                    } else {
                        System.out.println("Sorry, not enough beans!");
                    }
                } else {
                    System.out.println("Sorry, not enough water!");
                }
            } else if (option.equals("2")) {
                if (water >= 350) {
                    if (milk >= 75) {
                        if (beans >= 20) {
                            System.out.println("I have enough resources, making you a coffee!");
                            result = true;
                        } else {
                            System.out.println("Sorry, not enough beans!");
                        }
                    } else {
                        System.out.println("Sorry, not enough milk!");
                    }

                }else{
                    System.out.println("Sorry, not enough water!");
                }

            } else if (option.equals("3")) {
                if (water >= 200) {
                    if (milk >= 100) {
                        if (beans >= 12) {
                            System.out.println("I have enough resources, making you a coffee!");
                            result = true;
                        } else {
                            System.out.println("Sorry, not enough beans!");
                        }
                    } else {
                        System.out.println("Sorry, not enough milk!");
                    }
                }else {
                    System.out.println("Sorry, not enough water!");
                }

            }
        }else {
            System.out.println("Sorry, not enough disposable cups!");
        }
        return result;
    }
}

import java.time.LocalDate;

/*
 * In Java, implement a simple ceiling fan which has two pull cords and the following characteristics:
    * One cord increases the speed each time it is pulled. There are 3 speed settings, and an “off” (speed 0) setting. If the cord is pulled on speed 3, the fan returns to the “off” setting.
    * One cord reverses the direction of the fan at the current speed setting. Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.
    * The ceiling fan should be “off” on December 25th all day even if the cords are pulled.
    * You can assume the unit is always powered (no wall switch)
 */

 public class Fan {
    private int fanSpeed;
    private boolean isReversed;
    
    // constructor
    public Fan() {
        this.fanSpeed = 0;
        this.isReversed = false;
    }
    
    // check if today is Christmas
    private boolean isChristmas() {
        // var since multiple occurrences
        LocalDate today = LocalDate.now();
        return today.getMonthValue() == 12 && today.getDayOfMonth() == 25;
    }
    
    // increase the speed (speeds range from 0 - 3)
    public void increaseSpeed() {
        if (!isChristmas()) {
            fanSpeed = (fanSpeed + 1) % 4;
        }
    }
    
    // change the fan's direction
    public void changeDirection() {
        if (!isChristmas()) {
            isReversed = !isReversed;
        }
    }
    
    // returns the result as a string
    public String toString() {
        String direction = isReversed ? "counter clockwise" : "clockwise";
        return "speed: " + fanSpeed + " | " + "direction: " + direction;
    }
    
    // main
    public static void main(String[] args) {
        Fan fan = new Fan();
        
        // tests
        if (fan.isChristmas()) {
            System.out.println("It's Christmas - the fan is off");

            fan.increaseSpeed();
            System.out.println(fan);
            // output: 0, clockwise

            fan.increaseSpeed();
            System.out.println(fan);
            // output: 0, clockwise

            fan.changeDirection();
            System.out.println(fan);
            // output: 0, clockwise
        } else {
            System.out.println(fan);
            // output: 0, clockwise
                    
            fan.increaseSpeed();
            System.out.println(fan);
            // output: 1, clockwise

            fan.increaseSpeed();
            System.out.println(fan);
            // output: 2, clockwise

            fan.increaseSpeed();
            System.out.println(fan);
            // output: 3, clockwise

            fan.increaseSpeed();
            System.out.println(fan + "\n");
            // output: 0, clockwise

            fan.changeDirection();
            System.out.println(fan);
            // output: 0, counter clockwise

            fan.increaseSpeed();
            System.out.println(fan);
            // output: 1, counter clockwise

            fan.changeDirection();
            System.out.println(fan);
            // output: 1, clockwise
        }
    }
}
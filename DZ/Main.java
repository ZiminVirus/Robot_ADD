import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

// import RobotMap.Direction;

public class Main {

    // Client <-> API <-> Model
    // Client_2

    /**
     * @param args
     * @throws PositionException
     */
    public static void main(String[] args) throws PositionException {
        // 1.
        // Карта с каким-то размером nxm.
        // На ней можно создать робов, указывая начальное положение.
        // Если начальное положение некорректное ИЛИ эта позиция занята другим робом, то кидаем исключение.
        // Робот имеет направление (вверх, вправо, вниз, влево). У роботов можно менять направление и передвигать их на 1 шаг вперед
        // 2.
        // Написать контроллер к этому коду, который будет выступать посредником между консолью (пользователем) и этой игрой.
        // (0,0)      ------------------            (0, m)
        // ...
        // (n, 0)    -----------------------        (n, m)

        // Robot, Map, Point

        // Домашнее задание:
        // Реализовать чтение команд с консоли и выполнить их в main методе
        // Список команд:
        // create-map 3 5 -- РЕАЛИЗОВАНО!
        // create-robot 2 7 -- РЕАЛИЗОВАНО
        // move-robot id
        // change-direction id LEFT

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите команду для создания карты:");
        RobotMap map = null;
        while (true) {
            String command = sc.nextLine();
            if (command.startsWith("create-map")) {
                String[] split = command.split(" "); // [create-map 3 5]
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [3 5]

                try {
                    map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }
        }


        System.out.println("ИГРАЕМ...");
        

        while (true) {
        System.out.println("Чтобы создать робота введите 1, чтобы закончить создание роботов 0");
        String command = sc.nextLine();
        if (command.equals("1")){
            System.out.println("Введите команду для создания робота:");
            command = sc.nextLine();
            if (command.startsWith("create-robot")) {
                String[] split = command.split(" "); // [create-robot 2 7]
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [2 7]
                try {
                    RobotMap.Robot robot = map.createRobot (new Point (Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
                    System.out.println("Успешно создан робот " + robot.getId() + " на позиции " + robot.getPosition());
                } 
                catch (IllegalArgumentException e) {
                    System.out.println("При создании робота возникло исключение: " + e.getMessage() + "." +" Попробуйте еще раз");
                }}
            else {
                System.out.println("Введена не верная команда, введите еще раз");
            }}
        else if (command.equals("0")) {
            System.out.println("Роботы созданы");
            break;
        }
        else {
            System.out.println("Вы ввели не верную команду, поробуйте еще раз");
        }
    }


     while (true){       
        System.out.println("Введите команду роботу"); //например move-robot id, или change-direction id LEFT
    String command = sc.nextLine();
    String[] split = command.split(" "); // [move-robot id]
    String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [id]
        if (command.startsWith("change-direction")) {
        UUID robotId = UUID.fromString(arguments[0]);
        RobotMap.Direction direction = RobotMap.Direction.valueOf(arguments[1]);
        RobotMap.Robot robotById = map.findRobotById(robotId);
            if (robotById != null) {
                try {
                robotById.changeDirection(direction);
                System.out.println("Робот с идентификатором " + robotId + " смотрит в сторону " + direction);
                } catch (Exception e) {
                    System.out.println("Робот с идентификатором " + robotId + " не найден");
                }
                
            } }

        else if (command.startsWith("move-robot")){
        UUID robotId = UUID.fromString(arguments[0]);
        RobotMap.Robot robotById = map.findRobotById(robotId);
            if (robotById != null) {
                try {
                    robotById.move();
                System.out.println("Робот " + robotId + " сделал шаг");
  
                } catch (Exception e) {
                    System.out.println("Робот " + robotId + " не может двигаться в данном направлении, позиция занята");
                }
                
        }
    }
    // sc.close();


        }
        

  
    
    }}


    
    

            

        // try {
        //     RobotMap.Robot robot = map.createRobot (new Point (Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
        //     System.out.println("Успешно создан робот " + robot.getId() + " на позиции " + robot.getPosition());
        //     } 
        // catch (IllegalArgumentException e) {
        //     System.out.println("При создании робота возникло исключение: " + e.getMessage() + "." +" Попробуйте еще раз");
        // }
    
    // else {
    //     System.out.println("Введена не верная команда, введите еще раз");
    // }




        

//        RobotMap.Robot robot1 = null;
//        RobotMap.Robot robot2 = null;
//        try {
//            robot1 = map.createRobot(new Point(2, 5));
//            robot2 = map.createRobot(new Point(4, 5));
//
//            System.out.println(robot1);
//            System.out.println(robot2);
//        } catch (PositionException e) {
//            System.out.println("Во время создания робота случилось исключение: " + e.getMessage());
//        }
//
//        if (robot2 != null) {
//            try {
//                robot2.move();
//            } catch (PositionException e) {
//                System.out.println("Не удалось переместить робота: " + e.getMessage());
//            }
//        }

        // create robot (3, 5)

    



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for(int i = 1; i<=3; i++){
            System.out.println("Введите название машины № " + i);
            String name = scanner.next();
            System.out.println("Введите скорость машины № " + i);

            int speed = scanner.nextInt();
            if(speed<0 || speed>250){
                while (speed<0 || speed>250){
                    System.out.println("Вы указали неправильную скорость");
                    System.out.println("Введите скорость машины № " + i);
                    speed = scanner.nextInt();
                }
            }

            carList.add(new Car(name,speed));
        }

        Race race = new Race();
        Car winner = race.calculateAndRememberWinner(carList);

        System.out.println("Победитель: " + winner.name + " Дистанция: " + winner.distance);
    }
}

class Car {
    String name;
    int speed;

    int distance;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public int getDistance(){
        return this.distance;
    }
}

class Race {
    int time = 24;
    public Car calculateAndRememberWinner(ArrayList<Car> carList) {
        for (Car car : carList) {
            car.distance = time * car.speed;
        }

        carList.sort(Comparator.comparingInt(Car::getDistance).reversed());

        return carList.get(0);
    }
}

/*
Итак, нам предстоит определить лидера гонки:
Запрашиваем у пользователя 3 автомобиля, каждый из которых имеет два параметра: название и скорость.
После ввода данных пользователем проверяем, что введённая скорость >0 и ⩽250. Если скорость ввели неверно, программа должна запросить эти данные заново.
После успешного ввода рассчитываем, сколько километров за 24 часа смог проехать каждый участник гонки (автомобиль), и запоминаем лидера.
Выводим название автомобиля-лидера в консоль в любом понятном формате. Например: Самая быстрая машина: Москвич.G


Обратите внимание, что в задании нужно использовать разные классы. Предлагаем разделить весь код на три класса:
Автомобиль — объект, содержащий в себе параметры «название» и «скорость».
Гонка – класс, в котором рассчитывается и запоминается лидер.
Main – класс, в котором происходит считывание пользовательского ввода и коммуникация с остальными классами.
 */
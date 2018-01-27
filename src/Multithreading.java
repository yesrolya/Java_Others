import java.lang.*;
import java.io.*;
import java.util.Scanner;
//для времени
import java.text.SimpleDateFormat;
import java.util.Calendar;

class ThreadSin implements Runnable {
    Thread thrd;
    double start;
    int number;
    double step;
    int delay;

    ThreadSin (double x, int n, double s, int d) {
        thrd = new Thread(this);
        start = x;
        number = n;
        step = s;
        delay = d;
        //запускается при создании
        thrd.start();
    }
    public void run() {
        System.out.println("Запуск потока SIN.");
        try {
            FileWriter fw = new FileWriter("D://sin.txt", true);
            BufferedWriter out = new BufferedWriter(fw);
            //запись текущей даты и времени в файл
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            out.write( sdf.format(cal.getTime()) );
            out.newLine();

            double currentX = start;
            for (int i = 0; i < number; i++) {
                Calendar cal1 = Calendar.getInstance();
                SimpleDateFormat sdd = new SimpleDateFormat("HH:mm:ss");
                String str = " SIN(" + currentX + ") = " + Math.sin(currentX);
                System.out.println(str);
                currentX += step;
                out.write(sdd.format(cal1.getTime()) + str);
                out.newLine();
                Thread.sleep(delay);
            }
            out.close();
            fw.close();
        }
        catch (InterruptedException exc) {
            System.out.println("Поток SIN прерван с кодом ошибки: " + exc);
        } catch (IOException ex) {
            System.out.println("Поток SIN прерван с кодом ошибки ввода-вывода: " + ex);
        }
        System.out.println("Завершение потока SIN.");
    }
}

class ThreadCos implements Runnable {
    Thread thrd;
    double start;
    int number;
    double step;
    int delay;

    ThreadCos(double x, int n, double s, int d) {
        thrd = new Thread(this);
        start = x;
        number = n;
        step = s;
        delay = d;
        //запускается при создании
        thrd.start();
    }

    public void run(){
        System.out.println("Запуск потока COS.");
        try {
            FileWriter fw = new FileWriter("D://cos.txt", true);
            BufferedWriter out = new BufferedWriter(fw);
            //запись текущей даты и времени в файл
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            out.write( sdf.format(cal.getTime()) );
            out.newLine();

            double currentX = start;
            for (int i = 0; i < number; i++) {
                Calendar cal1 = Calendar.getInstance();
                SimpleDateFormat sdd = new SimpleDateFormat("HH:mm:ss");
                String str = (" COS(" + currentX + ") = " + Math.cos(currentX));
                System.out.println(str);
                currentX += step;
                out.write(sdd.format(cal1.getTime()) + str);
                out.newLine();
                Thread.sleep(delay);
            }
            out.close();
            fw.close();
        } catch (InterruptedException exc) {
            System.out.println("Поток COS прерван с кодом ошибки: " + exc);
        } catch (IOException ex) {
            System.out.println("Поток COS прерван с кодом ошибки ввода-вывода: " + ex);
        }
        System.out.println("Завершение потока COS.");
    }
}

public class Multithreading {
    public static void main(String args[]) {
        double x1, x2, s1, s2;
        int n, d1, d2;

        //считывание исходных данных
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество шагов.");
        n = in.nextInt();

        System.out.println("Введите данные для функции SIN. ");
        System.out.println("Начальную координату, задержку, шаг. ");
        x1 = in.nextDouble();
        d1 = in.nextInt();
        s1 = in.nextDouble();
        System.out.println("Введите данные для функции COS.");
        System.out.println("Начальную координату, задержку, шаг. ");
        x2 = in.nextDouble();
        d2 = in.nextInt();
        s2 = in.nextDouble();

        ThreadSin ThrdSin = new ThreadSin(x1, n, s1, d1);
        ThreadCos ThrdCos = new ThreadCos(x2, n, s2, d2);

    }
}
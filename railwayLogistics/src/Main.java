public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        SortStation station = new SortStation();
        Input input = new Input(station, 10);
        Unloading[] unloadings = new Unloading[3];
        input.start();
        for (int i = 0; i < 3; i++) {
            unloadings[i] = new Unloading(station, i, String.valueOf("DIMAS " + i));
            unloadings[i].start();
        }
        input.join();
        for (int i = 0; i < 3; i++) unloadings[i].join();

        System.out.println("End of the programm");
    }
}

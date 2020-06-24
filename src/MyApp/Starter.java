package MyApp;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) {

        int startYear = 1990;
        int endYear = 2020;
        try {

            System.out.println("app v.1.13");
            proceedOperation(startYear, endYear);

        } catch (IOException e) {
            e.getStackTrace();
        }catch (NullPointerException e) {
            System.out.println("File path is null.");
        }catch (NumberFormatException ex){
            System.out.println("Parsing exception. Please check file data.");
        }

    }

    private static void proceedOperation(int startYear, int endYear) throws IOException {

        for (int i = startYear; i < endYear; i++) {
            int sum = 0;
            String y = i + "";
            MyApp app = new MyApp(y);
            sum = app.loadData(sum);
            double counter = MyApp.getLoadEntranceCounter();

            double devResult = sum > 0 ? (double) sum / counter : 0;
            if (devResult > 0) {
                System.out.println(i + " " + devResult);
            }
            app.saveData(i, devResult);
        }
        System.out.println("");
    }
}

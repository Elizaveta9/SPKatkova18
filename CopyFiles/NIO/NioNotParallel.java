import java.io.IOException;
import java.nio.file.*;


class NioCopyNotParallel {
    public static void main(String[] args) {
        //объявление начального и конечного пути для копирования первого файла
        Path srcFileFirst = Paths.get("C:\\Users\\Elizaveta\\IdeaProjects\\title\\src\\com\\company\\files\\dosage_norm_name.txt");
        Path trgFileFirst = Paths.get("src/com/company/FirstFileToCopy2.txt");

        //объявление начального и конечного пути для копирования второго файла
        Path srcFileSecond = Paths.get("C:\\Users\\Elizaveta\\IdeaProjects\\title\\src\\com\\company\\files\\trade_names.txt");
        Path trgFileSecond = Paths.get("src/com/company/SecondFileToCopy2.txt");

        long startTime = System.currentTimeMillis();

        //копирование
        try {
            Files.copy(srcFileFirst, trgFileFirst, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(srcFileSecond, trgFileSecond, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}
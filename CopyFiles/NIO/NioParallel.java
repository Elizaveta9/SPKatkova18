import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class NioCopyParallel {
    public static void main(String[] args) {
        //объявление начального и конечного пути для копирования первого файла
        Path srcFileFirst = Paths.get("C:\\Users\\Elizaveta\\IdeaProjects\\title\\src\\com\\company\\files\\dosage_norm_name.txt");
        Path trgFileFirst = Paths.get("src/com/company/FirstFileToCopy2.txt");

        //объявление начального и конечного пути для копирования второго файла
        Path srcFileSecond = Paths.get("C:\\Users\\Elizaveta\\IdeaProjects\\title\\src\\com\\company\\files\\trade_names.txt");
        Path trgFileSecond = Paths.get("src/com/company/SecondFileToCopy2.txt");

        long startTime = System.currentTimeMillis();

        //запуск потоков
        FileCopyTreadNio copyFirstFile = new FileCopyTreadNio(srcFileFirst, trgFileFirst);
        copyFirstFile.start();
        FileCopyTreadNio copySecondFile = new FileCopyTreadNio(srcFileSecond, trgFileSecond);
        copySecondFile.start();

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}

//создание класса потоков
class FileCopyTreadNio extends Thread{
    private Path src;
    private Path trg;

    FileCopyTreadNio(Path src, Path trg) {
        this.src = src;
        this.trg = trg;
    }

    @Override
    public void run() {
        try {
            Files.copy(src, trg, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
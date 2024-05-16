package LifeGame;

public class LifeGame {

    final int habitatSatir = 19;
    final int habitatSutun = 19;

    int hucreHabitat[][];
    int hucreHabitatTmp[][];

    public LifeGame() {
        hucreHabitat = new int[habitatSatir][habitatSutun];
        hucreHabitatTmp = new int[habitatSatir][habitatSutun];

        // Başlangıç durumu için bir örnek desen ekleyebilirsiniz.
        // Örneğin, bir örüntüyü belirli bir bölgeye eklemek:
        // hucreHabitat[5][5] = 1;
        // hucreHabitat[5][6] = 1;
        // hucreHabitat[5][7] = 1;

        resetHabitat();
    }

    public void resetHabitat() {
        for (int i = 0; i < habitatSatir; i++) {
            for (int j = 0; j < habitatSutun; j++) {
                hucreHabitat[i][j] = 0;
                hucreHabitatTmp[i][j] = 0;
            }
        }
    }

    public void drawHabitat() {
        for (int i = 1; i < habitatSatir - 1; i++) {
            for (int j = 1; j < habitatSutun - 1; j++) {
                System.out.print(hucreHabitat[i][j] == 1 ? "#" : "-");
            }
            System.out.println();
        }
    }

    public int countAliveNeighbors(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i != row || j != col) {
                    count += hucreHabitat[i][j];
                }
            }
        }
        return count;
    }

    public void applyRules() {
        for (int i = 1; i < habitatSatir - 1; i++) {
            for (int j = 1; j < habitatSutun - 1; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                if (hucreHabitat[i][j] == 1) {
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        hucreHabitatTmp[i][j] = 0;
                    } else {
                        hucreHabitatTmp[i][j] = 1;
                    }
                } else {
                    if (aliveNeighbors == 3) {
                        hucreHabitatTmp[i][j] = 1;
                    } else {
                        hucreHabitatTmp[i][j] = 0;
                    }
                }
            }
        }

        copyHabitat();
    }

    public void copyHabitat() {
        for (int i = 1; i < habitatSatir - 1; i++) {
            for (int j = 1; j < habitatSutun - 1; j++) {
                hucreHabitat[i][j] = hucreHabitatTmp[i][j];
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LifeGame lg = new LifeGame();

        System.out.println("Initial State:");
        lg.drawHabitat();
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println("Iteration " + (i + 1) + ":");
            lg.applyRules();
            lg.drawHabitat();
            System.out.println();
            Thread.sleep(1000);
        }
    }
}

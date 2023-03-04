public class MovieManager {
    private String[] movieDatabase = new String[0];
    private int resultLength = 10;

    public MovieManager() {
    }

    public MovieManager(int resultLength) {
        this.resultLength = resultLength;
    }

    public String[] addMovieToDB(String newMovieEntry) {
        String[] bufferDatabase = new String[movieDatabase.length + 1];
        for (int pos = 0; pos < movieDatabase.length; pos++) {
            bufferDatabase[pos] = movieDatabase[pos];
        }
        bufferDatabase[bufferDatabase.length - 1] = newMovieEntry;
        movieDatabase = bufferDatabase;
        return movieDatabase;
    }

    public String[] getMovieDatabase() {
        return movieDatabase;
    }

    public String[] findAll() { /** выводит все фильмы в порядке добавления*/
        return movieDatabase;
    }

    public String[] findLast() { /** Выводит максимальный лимит последних добавленных фильмов в обратном порядке*/
        String[] resultDatabase = new String[resultLength];
        /** следует учитывать, что
         а) позиции массива нумеруются с нуля,
         б) число результатов может быть равно одному */

        int posResult = 0;
        /** итеративная переменная для выбора позиции в новом массиве (с результатами) перед записью из основного*/

        for (int pos = movieDatabase.length - 1; pos > (movieDatabase.length - resultLength - 1); pos--) {

            resultDatabase[posResult] = movieDatabase[pos];
            posResult = posResult + 1;
        }
        return resultDatabase;
    }
}

public class MovieManager {
    private String[] movieDatabase = new String[0];
    private int resultLength = 10;

    public MovieManager() {
    }

    public MovieManager(int resultLength) {
        this.resultLength = resultLength;
    }

    public String[] resultDatabase = new String[0];

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
        if (resultLength > movieDatabase.length) {/** проверяет, не превышвет ли число результатов длину массива фильмов */
            resultLength = movieDatabase.length;
        }
        String[] bufferDatabase = new String[resultLength];
        int posResult = 0;

            for (int pos = movieDatabase.length - 1; pos > (movieDatabase.length - resultLength - 1); pos--) {
                bufferDatabase[posResult] = movieDatabase[pos];
                posResult++;
                resultDatabase = bufferDatabase;
            }
        return resultDatabase;
    }
}

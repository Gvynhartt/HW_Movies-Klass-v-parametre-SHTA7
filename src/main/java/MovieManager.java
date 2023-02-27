public class MovieManager {
    private String[] movieDatabase = new String[0];
    private int resultLength = 10;
    private String[] resultDatabase = new String[resultLength];

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

    public String[] findAllMoviesAdded(String newMovieEntry) {
        /** Ну кагбэ логика, реализованная в первом пункте задания, и без того
         * возвращает все фильмы, добавленные в базу данных, в порядке добавления.
         * Зачем под это нужен ещё один метод, неясно. Сделать ссылку внутри метода
         * на другой метод, принимающий непонятно что из отдельного класса MovieEntry
         * (если делать всё ИМЕННО так, как показано в видео, по аналогии с Purchase Item[])
         * в качестве параметра, я не могу. Или не сообразил как. Возможно, задача была бы проще,
         * если бы нам объяснили, например, что такое интерфейсы. Однако этого не произошло.
         * Нам на лекции в принципе не объяснили, как это можно так ловко добавить ссылку на
         * класс в параметр и какое для этого требуется оформление, а также какие у этого
         * издержки. \_(^~^)_/
         * */

        movieDatabase = addMovieToDB(newMovieEntry);
        return movieDatabase;
    }

    public String[] findLastNmoviesAddedInReverse(int resultLength) {
        String[] resultDatabase = new String[resultLength];
        /** следует учитывать, что
         а) позиции массива нумеруютсяс нуля,
         б) число результатов может быть равно одному */

        int posResult = 0;
        /** итеративная переменная для выбора позиции в новом массиве (с результатами) перед записью из основного*/

                    for (int pos = movieDatabase.length - 1; pos > (movieDatabase.length - resultLength - 1); pos--) {

                resultDatabase[posResult] = movieDatabase[pos];
                posResult = posResult + 1;
            }
        return resultDatabase;
    }

    public String[] getResultDatabase() {
        return resultDatabase;
    }
}

public class MovieManager {
    private MovieRepository movieRepo;

    public MovieManager(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    public MovieEntry[] findAllMoviesAdded() {
        MovieEntry[] movieDatabase = movieRepo.getMovieDatabase();
        return movieDatabase;
    }

    public MovieEntry[] saveMovieInDatabase(MovieEntry newEntry) {
        MovieEntry[] movieDatabase = movieRepo.getMovieDatabase();
        MovieEntry[] bufferDatabase = new MovieEntry[movieDatabase.length + 1];
        for (int pos = 0; pos < movieDatabase.length; pos++) {
            bufferDatabase[pos] = movieDatabase[pos];
        }
        bufferDatabase[bufferDatabase.length - 1] = newEntry;
        movieDatabase = bufferDatabase;
        return movieDatabase;
    }

    public MovieEntry[] findInDatabaseById(int targetId) {
        MovieEntry[] movieDatabase = movieRepo.getMovieDatabase();
        MovieEntry[] bufferDatabase = new MovieEntry[movieDatabase.length];
        int pos = 0;
        int matchCount = 0;
        for (MovieEntry newEntry : movieDatabase) {
            if (newEntry.getMovieId() == targetId) {
                bufferDatabase[pos] = newEntry;
                pos++;
                matchCount++;
            } else {
                pos++;
            }
        }
        MovieEntry[] dynamicDatabase = new MovieEntry[matchCount];
        int posDynamic = 0;

        for (pos = 0; pos < bufferDatabase.length; pos++) {
            if (bufferDatabase[pos] != null) {
                dynamicDatabase[posDynamic] = bufferDatabase[pos];
                pos++;
                posDynamic++;
            } else {
                pos++;
            }
        }
        return dynamicDatabase;
    }

    public MovieEntry[] removeFromDatabaseById(int removeId) {
        MovieEntry[] movieDatabase = movieRepo.getMovieDatabase();
        MovieEntry[] bufferDatabase = new MovieEntry[movieDatabase.length - 1];
        int pos = 0;
        for (MovieEntry newEntry : movieDatabase) {
            if (newEntry.getMovieId() != removeId) {
                bufferDatabase[pos] = newEntry;
                pos++;
            }
        }
        movieDatabase = bufferDatabase;
        return movieDatabase;
    }

    public MovieEntry[] removeAllMoviesFromDB() {
        MovieEntry[] movieDatabase = movieRepo.getMovieDatabase();
        MovieEntry[] clearedDatabase = new MovieEntry[0];
        movieDatabase = clearedDatabase;
        return movieDatabase;
    }
}

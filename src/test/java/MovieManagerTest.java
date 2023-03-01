import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class MovieManagerTest {

    MovieRepository movieRepo = Mockito.mock(MovieRepository.class);
    MovieManager movieMngr = new MovieManager(movieRepo);

    MovieEntry movie1 = new MovieEntry("Прибытие поезда", 1703);
    MovieEntry movie2 = new MovieEntry("Путешествие на Луну (1902)", 1337);
    MovieEntry movie3 = new MovieEntry("Генерал (1926)", 1453);
    MovieEntry movie4 = new MovieEntry("Метрополис", 1666);
    MovieEntry movie5 = new MovieEntry("Тайны одной души", 1138);
    MovieEntry movie6 = new MovieEntry("Унесённые ветром (1939)", 1984);
    MovieEntry movie7 = new MovieEntry("Александр Невский (1938)", 2011);
    MovieEntry movie8 = new MovieEntry("Гражданин Кейн", 2112);
    MovieEntry movie9 = new MovieEntry("Окно во двор", 2049);
    MovieEntry movie10 = new MovieEntry("2001: Космическая одиссея", 2077);
    MovieEntry movie11 = new MovieEntry("Чужой", 1612);
    MovieEntry movie12 = new MovieEntry("Бегущий по лезвию (1982)", 1917);
    MovieEntry movie13 = new MovieEntry("Матрица (1999)", 1138);
    MovieEntry movie14 = new MovieEntry("Властелин колец", 1789);
    MovieEntry movie15 = new MovieEntry("Интерстеллар", 1492);

    @Test
    public void shdSaveMovieInDB() {
        MovieEntry[] movieDatabase = {};
        doReturn(movieDatabase).when(movieRepo).getMovieDatabase();

        MovieEntry[] expected = {movie15};
        MovieEntry[] actual = movieMngr.saveMovieInDatabase(movie15);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdFindAllMoviesInDB() {
        MovieEntry[] movieDatabase = { movie1, movie3, movie5, movie8, movie13};
        doReturn(movieDatabase).when(movieRepo).getMovieDatabase();

        MovieEntry[] expected = {movie1, movie3, movie5, movie8, movie13};
        MovieEntry[] actual = movieMngr.findAllMoviesAdded();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdFindMovieById() {
        MovieEntry[] movieDatabase = { movie1, movie3, movie5, movie8, movie13};
        doReturn(movieDatabase).when(movieRepo).getMovieDatabase();


        MovieEntry[] expected = {movie1};
        MovieEntry[] actual = movieMngr.findInDatabaseById(1703);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdFindMovieByIdIfNonexistent() {
        MovieEntry[] movieDatabase = { movie1, movie3, movie5, movie8, movie13};
        doReturn(movieDatabase).when(movieRepo).getMovieDatabase();

        MovieEntry[] expected = {}; /** насколько я понял, ожидаемый массив в принципе нельзя прописать как null;
         можно ли считать пустой массив сооответствующим заданию? */
        MovieEntry[] actual = movieMngr.findInDatabaseById(5928);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdFindMovieByIdIfDuplicate() {
        MovieEntry[] movieDatabase = { movie1, movie3, movie5, movie8, movie13};
        doReturn(movieDatabase).when(movieRepo).getMovieDatabase();

        MovieEntry[] expected = {movie5, movie13};
        MovieEntry[] actual = movieMngr.findInDatabaseById(1138);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdRemoveFromDatabaseById() {
        MovieEntry[] movieDatabase = { movie1, movie3, movie5, movie8, movie13};
        doReturn(movieDatabase).when(movieRepo).getMovieDatabase();

        MovieEntry[] expected = {movie1, movie3, movie5, movie13};
        MovieEntry[] actual = movieMngr.removeFromDatabaseById(2112);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdRemoveAllMovies() {
        MovieEntry[] movieDatabase = { movie1, movie3, movie5, movie8, movie13};
        doReturn(movieDatabase).when(movieRepo).getMovieDatabase();

        MovieEntry[] expected = {};
        MovieEntry[] actual = movieMngr.removeAllMoviesFromDB();

        Assertions.assertArrayEquals(expected, actual);
    }
}

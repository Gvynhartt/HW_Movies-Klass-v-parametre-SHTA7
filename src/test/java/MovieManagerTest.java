import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

//    MovieManager movie1 = new MovieManager("Прибытие поезда");
//    MovieManager movie2 = new MovieManager("Путешествие на Луну (1902)");
//    MovieManager movie3 = new MovieManager("Генерал (1926)");
//    MovieManager movie4 = new MovieManager("Метрополис");
//    MovieManager movie5 = new MovieManager("Тайны одной души");
//    MovieManager movie6 = new MovieManager("Унесённые ветром (1939)");
//    MovieManager movie7 = new MovieManager("Александр Невский (1938)");
//    MovieManager movie8 = new MovieManager("Гражданин Кейн");
//    MovieManager movie9 = new MovieManager("Окно во двор");
//    MovieManager movie10 = new MovieManager("2001: Космическая одиссея");
//    MovieManager movie11 = new MovieManager("Чужой");
//    MovieManager movie12 = new MovieManager("Бегущий по лезвию (1982)");
//    MovieManager movie13 = new MovieManager("Матрица (1999)");

    @Test
    public void shdAddToMDB() {
        MovieManager wutToWatch = new MovieManager();
        wutToWatch.addMovieToDB("Матрица (1999)");
        wutToWatch.addMovieToDB("Чужой");
        wutToWatch.addMovieToDB("Александр Невский (1938)");
        wutToWatch.addMovieToDB("Метрополис");
        wutToWatch.addMovieToDB("Тайны одной души");

        String[] expected = {"Матрица (1999)", "Чужой", "Александр Невский (1938)", "Метрополис", "Тайны одной души"};
        String[] actual = wutToWatch.getMovieDatabase();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdAddToMDBifZero() {
        MovieManager wutToWatch = new MovieManager();

        String[] expected = {};
        String[] actual = wutToWatch.getMovieDatabase();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdAddToMDBifSingle() {
        MovieManager wutToWatch = new MovieManager();
        wutToWatch.addMovieToDB("Чужой");

        String[] expected = {"Чужой"};
        String[] actual = wutToWatch.getMovieDatabase();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdReturnAllMoviesInDB() {
        MovieManager wutToWatch = new MovieManager();
        wutToWatch.addMovieToDB("Матрица (1999)");
        wutToWatch.addMovieToDB("Чужой");
        wutToWatch.addMovieToDB("Александр Невский (1938)");
        wutToWatch.addMovieToDB("Метрополис");
        wutToWatch.addMovieToDB("Тайны одной души");

        String[] expected = {"Матрица (1999)", "Чужой", "Александр Невский (1938)", "Метрополис", "Тайны одной души"};
        String[] actual = wutToWatch.getMovieDatabase();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdReturnLastNmoviesDefault() {
        MovieManager wutToWatch = new MovieManager();
        wutToWatch.addMovieToDB("Матрица (1999)");
        wutToWatch.addMovieToDB("Чужой");
        wutToWatch.addMovieToDB("Александр Невский (1938)");
        wutToWatch.addMovieToDB("Метрополис");
        wutToWatch.addMovieToDB("Тайны одной души");
        wutToWatch.addMovieToDB("Окно во двор");
        wutToWatch.addMovieToDB("Генерал");
        wutToWatch.addMovieToDB("1984");
        wutToWatch.addMovieToDB("Клеопатра");
        wutToWatch.addMovieToDB("Большие гонки");
        wutToWatch.addMovieToDB("Война и мир");
        wutToWatch.addMovieToDB("Солярис");

        String[] expected = {"Солярис", "Война и мир", "Большие гонки", "Клеопатра", "1984", "Генерал", "Окно во двор",
                "Тайны одной души", "Метрополис", "Александр Невский (1938)"};
        String[] actual = wutToWatch.findLastNmoviesAddedInReverse();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdReturnLastNmoviesCustomMulti() {
        MovieManager wutToWatch = new MovieManager(5);
        wutToWatch.addMovieToDB("Матрица (1999)");
        wutToWatch.addMovieToDB("Чужой");
        wutToWatch.addMovieToDB("Александр Невский (1938)");
        wutToWatch.addMovieToDB("Метрополис");
        wutToWatch.addMovieToDB("Тайны одной души");
        wutToWatch.addMovieToDB("Окно во двор");
        wutToWatch.addMovieToDB("Генерал");
        wutToWatch.addMovieToDB("1984");
        wutToWatch.addMovieToDB("Клеопатра");
        wutToWatch.addMovieToDB("Большие гонки");
        wutToWatch.addMovieToDB("Война и мир");
        wutToWatch.addMovieToDB("Солярис");

        String[] expected = {"Солярис", "Война и мир", "Большие гонки", "Клеопатра", "1984"};
        String[] actual = wutToWatch.findLastNmoviesAddedInReverse();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdReturnLastNmoviesCustomZero() {
        MovieManager wutToWatch = new MovieManager(0);
        wutToWatch.addMovieToDB("Матрица (1999)");
        wutToWatch.addMovieToDB("Чужой");
        wutToWatch.addMovieToDB("Александр Невский (1938)");
        wutToWatch.addMovieToDB("Метрополис");
        wutToWatch.addMovieToDB("Тайны одной души");
        wutToWatch.addMovieToDB("Окно во двор");
        wutToWatch.addMovieToDB("Генерал");
        wutToWatch.addMovieToDB("1984");
        wutToWatch.addMovieToDB("Клеопатра");
        wutToWatch.addMovieToDB("Большие гонки");
        wutToWatch.addMovieToDB("Война и мир");
        wutToWatch.addMovieToDB("Солярис");

        String[] expected = {};
        String[] actual = wutToWatch.findLastNmoviesAddedInReverse();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shdReturnLastNmoviesCustomSingle() {
        MovieManager wutToWatch = new MovieManager(1);
        wutToWatch.addMovieToDB("Матрица (1999)");
        wutToWatch.addMovieToDB("Чужой");
        wutToWatch.addMovieToDB("Александр Невский (1938)");
        wutToWatch.addMovieToDB("Метрополис");
        wutToWatch.addMovieToDB("Тайны одной души");
        wutToWatch.addMovieToDB("Окно во двор");
        wutToWatch.addMovieToDB("Генерал");
        wutToWatch.addMovieToDB("1984");
        wutToWatch.addMovieToDB("Клеопатра");
        wutToWatch.addMovieToDB("Большие гонки");
        wutToWatch.addMovieToDB("Война и мир");
        wutToWatch.addMovieToDB("Солярис");

        String[] expected = {"Солярис"};
        String[] actual = wutToWatch.findLastNmoviesAddedInReverse();

        Assertions.assertArrayEquals(expected, actual);
    }
}

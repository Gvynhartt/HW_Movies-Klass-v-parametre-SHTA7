public class MovieRepository {

    private MovieEntry[] movieDatabase = new MovieEntry[0];

    public MovieEntry[] getMovieDatabase() {
        return movieDatabase;
    }

//    public MovieEntry[] addNewEntry(MovieEntry newEntry) {/** Возможно, я дегенерат,
//     но в лекции метод сохранения нового объекта в массиве создавался в репозитории,
//     а не в менеджере. Однако во втором задании ВНЕЗАПНО потребовалось сделать данный
//     метод именно внутри менеджера. Так репозиторий в общем сферически-вакуумном виде
//     обладает собственной логикой? Или в нём просто имеется некое поле, куда мы
//     сохраняем нашу дичь через менагер? В любом случае, я продублирую эту логику
//     в репозиторий, потому как не надо умножать сущности в головах у слушателей курса,
//     особенно если последние клинические
//     гуманитарии*/
//
//        MovieEntry[] bufferDatabase = new MovieEntry[movieDatabase.length + 1];
//        for ( int pos = 0; pos < movieDatabase.length; pos++ ) {
//            bufferDatabase[pos] = movieDatabase[pos];
//        }
//        bufferDatabase[bufferDatabase.length - 1] = newEntry;
//        movieDatabase = bufferDatabase;
//        return movieDatabase;
//    }
}

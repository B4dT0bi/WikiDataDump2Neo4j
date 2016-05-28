package de.badtobi.wikidatadump2neo4j.helper;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public enum InstanceOf {
    COUNTRY("Country", new String[]{"Q6256"}),
    HUMAN("Person", new String[]{"Q5"}),
    FICTIONAL_HUMAN("FictionalPerson", new String[]{"Q15632617"}),
    GENDER("Gender", new String[]{"Q48277", "Q4369513", "Q48264"}),
    PROFESSION("Profession", new String[]{"Q28640", "Q12737077", "Q131512"}),
    MUSIC_CLASSIC("ClassicalMusic", new String[]{"Q9734", "Q207628", "Q1546995", "Q6770891"}),
    THEATRE_PLAY("TheatrePlay", new String[]{"Q25379"}),
    THEATRICAL_GENRE("TheatricalGenre", new String[]{"Q15850590"}),
    PAINTING("Painting", new String[]{"Q3305213"}),
    PAINTING_GENRE("PaintingGenre", new String[]{"Q16743958"}),
    SCULPTURE("Sculpture", new String[]{"Q860861"}),
    OPERA("Opera", new String[]{"Q1344"}),
    CONTINENT("Continent", new String[]{"Q5107"}),
    MUSIC_SONG("Song", new String[]{"Q7366", "Q23691"}),
    MUSIC_SINGLE("Single", new String[]{"Q134556"}),
    MUSIC_BAND("Band", new String[]{"Q215380", "Q5741069"}),
    MUSIC_ALBUM("Album", new String[]{"Q482994"}),
    LANGUAGE("Language", new String[]{"Q34770"}),
    TYPE_OF_SPORT("Sport", new String[]{"Q31629"}),
    THEORY("Theory", new String[]{"Q17737"}),
    FILM("Film", new String[]{"Q11424", "Q226730"}),
    FILM_GENRE("FilmGenre", new String[]{"Q201658"}),
    MUSIC_GENRE("MusicGenre", new String[]{"Q188451"}),
    VIDEO_GAME("VideoGame", new String[]{"Q7889", "Q7058673"}),
    VIDEO_GAME_GENRE("VideoGameGenre", new String[]{"Q659563"}),
    SKYSCRAPER("Skyscraper", new String[]{"Q11303"}),
    ARCHITECTURAL_STYLE("ArchitecturalStyle", new String[]{"Q32880"}),
    CURRENCY("Currency", new String[]{"Q8142"}),
    GAME_PLATFORM("GamePlatform", new String[]{"Q8076", "Q941818"}),
    BOOK("Book", new String[]{"Q1667921", "Q277759", "Q8261"}),
    CITY("City", new String[]{"Q1549591", "Q515", "Q22865"});

    private String[] ids;
    private String intName;

    InstanceOf(String intName, String[] ids) {
        this.intName = intName;
        this.ids = ids;
    }

    public String[] getIds() {
        return ids;
    }

    public String getIntName() {
        return intName;
    }

    public static InstanceOf getById(String idToFind) {
        for (InstanceOf instanceOf : InstanceOf.values()) {
            for (String id : instanceOf.getIds()) {
                if (id.equals(idToFind)) return instanceOf;
            }
        }
        return null;
    }
}

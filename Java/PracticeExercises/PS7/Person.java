public class Person {
    private String username;
    private String name;
    private int age;
    private String gender;
    private String crush;
    private String favoriteMovie;
    private String favoriteColor;
    private String favoriteSubject;
    private String motto;


    public Person(String username, String name, int age, String gender, String crush, String favoriteMovie, String favoriteColor, String favoriteSubject, String motto) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.crush = crush;
        this.favoriteMovie = favoriteMovie;
        this.favoriteColor = favoriteColor;
        this.favoriteSubject = favoriteSubject;
        this.motto = motto;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCrush() {
        return crush;
    }

    public String getFavMovie() {
        return favoriteMovie;
    }
    
    public String getFavColor() {
        return favoriteColor;
    }

    public String getFavSub() {
        return favoriteSubject;
    }

    public String getMotto() {
        return motto;
    }
}
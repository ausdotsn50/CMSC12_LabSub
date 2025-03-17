public class Person {
    // instance variables
    private String name;
    private int age;
    private String gender;
    private String crush;
    private String favMovie;
    private String favColor;
    private String favSub;
    private String motto;

    // constructor
    public Person (String name, int age, String gender, String crush, String favMovie, String favColor, String favSub, String motto) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.crush = crush;
        this.favMovie = favMovie;
        this.favColor = favColor;
        this.favSub = favSub;
        this.motto = motto;
    }

    // methods
    public String getName() {
        return name;
    }

    // sample
    public void setName(String newName) {
        this.name = newName;
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
        return favMovie;
    }

    public String getFavColor() {
        return favColor;
    }
    
    public String getFavSub() {
        return favSub;
    }

    public String getMotto() {
        return motto;
    }
}
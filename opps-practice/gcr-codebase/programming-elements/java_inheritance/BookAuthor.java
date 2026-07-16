
class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }

    public static void main(String[] args) {
        Author a = new Author("Java Programming", 2025, "John Doe", "Software Developer");
        a.displayInfo();
    }
}

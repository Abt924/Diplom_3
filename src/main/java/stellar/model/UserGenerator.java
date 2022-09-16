package stellar.model;

import com.github.javafaker.Faker;

public class UserGenerator {

    public static User createDefault() {
        return new User("Fedor", "Fedor@fedora.com", "123456");
    }

    public static User createRandom() {
        Faker faker = new Faker();
        return new User(
                faker.name().name(),
                faker.internet().emailAddress(),
                faker.internet().password(6,64)
        );
    }
}

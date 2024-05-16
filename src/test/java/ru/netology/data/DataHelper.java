package ru.netology.data;

import java.util.Locale;
import com.github.javafaker.Faker;
import lombok.Value;


public class DataHelper {
    private static final Faker Faker = new Faker(new Locale("en"));

    private DataHelper() {
    }
    @Value
    public static class AuthInfo{
        String login;
        String password;
    }
    public static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }
    public static String generateRandomLogin() {
        return Faker.name().username();
    }
    public static String generateRandomPassword(){
        return Faker.internet().password();
    }
    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }
    @Value
    public static class VerificationCode{
        String code;
    }
    public static VerificationCode generateRandomVC() {
        return new VerificationCode(Faker.numerify("######"));
    }
}
package utils;

import com.github.javafaker.Faker;

public class RandomTestData {
    private static final Faker faker = new Faker();

    public static String getFirstName(){
        return faker.name().firstName();
    }
    public static String getLastName(){
        return faker.name().lastName();
    }
    public static String getUserEmail(){
        return faker.internet().emailAddress();
    }
    public static String getUserNumber(){
        return faker.phoneNumber().subscriberNumber(10);
    }
    public static String getGender(){
        return faker.options().option("Male", "Female", "Other");
    }
    public static String getAddress(){
        return faker.address().streetAddress();
    }
    public static String getHobbies(){
        return faker.options().option("Sports", "Reading", "Music");
    }
    public static String getSubjects(){
        return faker.options().option("Maths", "Hindi", "History", "Arts");
    }
    public static String getDay(){
        return String.format("%s", faker.number().numberBetween(10, 28));
    }
    public static String getMonth(){
        return faker.options().option("January", "February", "March", "April","May", "June", "July", "August", "September", "October", "November", "December");
    }
    public static String getYear(){
        return String.format("%s", faker.number().numberBetween(1900, 2100));
    }
    public static String getState(){
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }
    public static String getCity(String state) {
        switch (state) {
            case "NCR" -> {
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            }
            case "Uttar Pradesh" -> {
                return faker.options().option("Agra", "Lucknow", "Merrut");
            }
            case "Haryana" -> {
                return faker.options().option("Karnal", "Panipat");
            }
            case "Rajasthan" -> {
                return faker.options().option("Jaipur", "Jaiselmer");
            }
            default -> {
                return null;
            }
        }
    }
}

package com.lamda.ex;


import java.util.Scanner;

public class UserRegistrationTest
{
    public static void main(String[] args)
    {
      
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name you want to check");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last name you want to check");
        String lastName = scanner.nextLine();
        System.out.println("Enter email you want to check");
        String email = scanner.nextLine();
        System.out.println("Enter mobile number you want to check");
        String mobile = scanner.nextLine();
        System.out.println("Enter password you want to check");
        String password = scanner.nextLine();

        // Defining pattern of the various inputs
        String first_Name_Pattern = "^[A-Z ][a-z]{3,}";
        String last_Name_Pattern = "^[A-Z ][a-z]{3,}";
        String mobile_Number_Pattern = "^[0-9]{2}\\s{1}[0-9]{10}$";
        String password_Pattern = "(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}";
        String email_Pattern = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*" + "@([a-zA-Z0-9][-]?)+[.][a-zA-Z]{2,4}([.]{2,4})?$";

        // Using lambda expression to validate inputs here we are calling interface of UserValidator
        UserValidation validateFirstName = (firstNameValid) -> firstNameValid.matches(first_Name_Pattern);
        UserValidation validateLastName = (lastNameValid) -> lastNameValid.matches(last_Name_Pattern);
        UserValidation validateMobileNumber = (mobileNumberValid) -> mobileNumberValid.matches(mobile_Number_Pattern);
        UserValidation validatePassword = (passwordValid) -> passwordValid.matches(password_Pattern);
        UserValidation validateEmail = (emailValid) -> emailValid.matches(email_Pattern);

        boolean checkFirstName = validateFirstName.validate(firstName);
        if (checkFirstName == true)
            System.out.println("First name is Valid");
        else
            System.out.println("First name is Invalid");

        boolean checkLastName = validateLastName.validate(lastName);
        if (checkLastName == true)
            System.out.println("Last name is Valid");
        else
            System.out.println("Last name is Invalid");

        boolean checkMobileNumber = validateMobileNumber.validate(mobile);
        if (checkMobileNumber == true)
            System.out.println("Mobile number is Valid");
        else
            System.out.println("Mobile number is Invalid");

        boolean checkPassword = validatePassword.validate(password);
        if (checkPassword == true)
            System.out.println("Password is Valid");
        else
            System.out.println("Password is Invalid");

        boolean checkEmail = validateEmail.validate(email);
        if (checkEmail == true)
            System.out.println("Email Id is Valid");
        else
            System.out.println("Email Id is Invalid");
    }
}
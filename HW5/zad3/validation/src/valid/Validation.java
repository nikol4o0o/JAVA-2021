package valid;

public class Validation
{
    // Проверяваме дали са празни всичките  string-ове
    public  boolean checkEmpty(String username, String password, String confirmPassword, String email, String phone)
    {
        return username.equals("") && phone.equals("") && email.equals("")
                && password.equals("") && confirmPassword.equals("");
    }

    // Проверяваме Username
    public  boolean checkUsername(String username)
    {
        return username.matches("[a-zA-Z]{2,}");
    }

    // Проверяваме телефона дали е валиден
    public  boolean checkPhone(String phone)
    {
        return phone.matches("[(]\\d{4}[)]\\s[(]\\d{7}[)]");
    }

    // Проверяваме електронната поща
    public  boolean checkEmail(String email)
    {
        return email.matches("([a-z]+([.]|[a-z]*))+[@][a-z]+[.][a-z]+");
    }

    // Проверяваме паролата
    public  boolean checkPassword(String password)
    {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^*@&]).{5,}$");
    }

    // Проверяваме дали двете пароли съвпадат
    public  boolean checkConfirmingPassword(String password, String confirmPassword)
    {
        return password.equals(confirmPassword);
    }
}

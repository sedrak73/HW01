public class Main {
    public static int calculateN(String firstName, String lastName) {
        return firstName.length() + lastName.length() + (lastName.charAt(0) - 'A');
    }

    public static int calculateId(int n) {
        return Math.round(-0.00165f * (float)Math.pow(n, 3) + 0.12384f * (float)Math.pow(n, 2) - 2.33779f * n + 14.1165f);
    }

    public static void main(String[] args) {
        String firstName = "Sedrak";
        String lastName = "Yerznkyan";

        int n = calculateN(firstName, lastName);

        int id = calculateId(n);

        System.out.println("n: " + n);
        System.out.println("id: " + id);
    }
}

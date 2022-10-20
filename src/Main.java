import java.util.Scanner;

public class Main {

    /**
     * Перевіряє чи закінчується рядок на "ed"
     * @param string
     * @return true, якщо закінчується на "ed", в противному випадку - false
     */
    public static boolean stringEnd(String string) {
        String endToCheck = "ed";
        String endOfString = string.substring((string.length() - 2));
        return (endOfString.equals(endToCheck));
    }

    /**
     * Знаходить цифру у рядку та рахує сумму цифр
     * @param string
     * @return сумму цифр, якщо вони наявні у рядку, якщо ні - 0
     */
    public static int sumOfNumbers(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                sum += Character.getNumericValue(string.charAt(i));
            }
        }
        return sum;
    }

    /**
     * Знаходить максимальну кількість однакових символів поруч
     * @param string
     * @return максимальну кількість
     */
    public static int maxBlockLength(String string) {
        int maxLength = 1;
        int blockLength = 1;
        for (int i = 0; i < string.length() - 1; i++) {

            if (string.charAt(i) == string.charAt(i + 1)) {
                blockLength++;
            } else {
                blockLength = 1;
            }
            if (blockLength > maxLength) {
                maxLength = blockLength;
            }
        }
        return maxLength;
    }

    /**
     * Створює символьний масив, у який додає посимвольно додає слова, виводить слова
     * @param string
     */
    public static void findWords(String string) {

        int wordsCounter = 1;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                wordsCounter++;
            }
        }

        String[] words = new String[wordsCounter];
        for (int i = 0; i < words.length; i++) {
            words[i] = "";
        }

        int i = 0, start = 0;
        while (i < words.length) {
            for (int index = start; index < string.length(); index++) {
                if (string.charAt(index) == ' ') {
                    start = index + 1;
                    break;
                }
                words[i] += string.charAt(index);
            }
            i++;
        }

        for (String oneWord : words) {
            System.out.println(oneWord);
        }
    }

    /**
     * Почергово додає у новий рядок символи вхідних рядків;
     * якщо один рядок закінчився, додає у кінець символи другого рядка, які залишилися
     * @param stringFirst
     * @param stringSecond
     * @return новий рядок
     */
    public static String toOneString(String stringFirst, String stringSecond) {
        int counter = 0;
        String commonString = "";
        int smallestLength = (Math.min(stringFirst.length(), stringSecond.length()));

        for (int i = 0; i < smallestLength; i++) {
            commonString += stringFirst.charAt(i);
            commonString += stringSecond.charAt(i);
            counter++;
        }
        if (stringFirst.length() > stringSecond.length()) {
            commonString += stringFirst.substring(counter);
        } else {
            commonString += stringSecond.substring(counter);
        }
        return commonString;
    }


    /**
     * "Точка входу" додатку
     * Викликає створені методи та виводить результати
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string:");
        String string = input.nextLine();
        System.out.println("The string ends with \"ed\" : "+stringEnd(string));
        System.out.println("Sum of numbers: "+sumOfNumbers(string));
        System.out.println("The longest block length: "+maxBlockLength(string));
        System.out.println("Words from the string:");
        findWords(string);
        System.out.println("Enter second string");
        String stringSecond = input.nextLine();
        System.out.println("Connected strings: \n"+toOneString(string, stringSecond));
    }
}
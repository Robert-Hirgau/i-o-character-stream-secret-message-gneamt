/*By using CharacterStream, please discover the secret message from the given "secret.txt" file considering the following instructions:

Take into consideration only capital letters from the input text
Consider capital X as space between words
The secret message need to be readed from a file

 */

package ro.iteahome.secret;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;

        try {
            inputStream = new FileReader("secret.txt");

            String secretMessaage = "";
            int codeOfCharacterWeRead;
            char characterFromCode;
            char space = 'X';
            while ((codeOfCharacterWeRead = inputStream.read()) != -1) {
                characterFromCode = (char)codeOfCharacterWeRead;
                if (Character.isUpperCase(characterFromCode) && characterFromCode == space)
                    secretMessaage = secretMessaage + " ";
                else if (Character.isUpperCase(characterFromCode))
                    secretMessaage = secretMessaage + characterFromCode;
            }
            System.out.println(secretMessaage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}

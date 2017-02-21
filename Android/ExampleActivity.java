
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
 * MIT License
 *
 * Copyright (c) 2017 Kavin Varnan

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            String plainText = "this is my plain text";
            String key = "simplekey";
            String iv = "1234123412341234";

            CryptLib cryptLib = new CryptLib();

            String encryptedString = cryptLib.encryptSimple(plainText, key, iv);
            System.out.println("encryptedString " + encryptedString);

            String decryptedString = cryptLib.decryptSimple(encryptedString, key, iv);
            System.out.println("decryptedString " + decryptedString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

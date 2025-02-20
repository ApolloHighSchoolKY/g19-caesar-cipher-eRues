/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet = {'a','b','c','d','e','f','g','h', 'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char[] shifted;
	private int shift;

    public CaesarCipher() {
        shift = 1;
        shifter(shift);
    }

    public CaesarCipher(int num){
        shift = num;
        shifter(shift);
    }

    public String encrypt(String message){
        String fMessage = "";
        char addChar = ' ';
        
        for(int i = 0; i < message.length(); i++)
        {
            addChar = message.charAt(i);

            for(int j = 0; j < alphabet.length; j++)
            {
                if(message.charAt(i) == alphabet[j])
                {
                    addChar = shifted[j];
                }
            }

            fMessage += "" + addChar;
        }
        
        return fMessage;
    }

    public String decrypt(String message){

        String fMessage = "";
        char addChar = ' ';
        
        for(int i = 0; i < message.length(); i++)
        {
            addChar = message.charAt(i);

            for(int j = 0; j < alphabet.length; j++)
            {
                if(message.charAt(i) == shifted[j])
                {
                    addChar = alphabet[j];
                }
            }

            fMessage += "" + addChar;
        }
        
        return fMessage;
    }

    public void shifter(int num){
        shifted = new char[alphabet.length];
        
        for(int i = 0; i < alphabet.length; i++)
        {
            shifted[i] = alphabet[((i + num*(num+2)) - (num-2))%26];
        }
    }

    //temporary print method
    public String toString()
    {
        String output = "";

        output += "Alphabet Array: ";
        for(int i = 0; i < alphabet.length; i++)
        {
            output += alphabet[i] + " ";
        }

        output += " \n\nShifted Array: ";
        for(int i = 0; i < alphabet.length; i++)
        {
            output += shifted[i] + " ";
        }

        return "" + output;
    }


}
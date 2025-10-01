/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pt.ipp.estg.pp.si1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;

public class Main {

    public static void main(String[] args) throws Exception {
        String encrypt;

        encrypt = menu();

        // Generate a new RSA key pair for the sender
        KeyPair senderKeypair = generateRSAKeyPair();
        // Generate a new RSA key pair for the receiver
        KeyPair receiverKeypair = generateRSAKeyPair();

        String plainText = encrypt;
        byte[] cipherText = do_RSAEncryption(plainText, receiverKeypair.getPublic());
        System.out.println("The Receiver's Public Key is: " + Base64.getEncoder().encodeToString(receiverKeypair.getPublic().getEncoded()));
        System.out.println("The Encrypted Text is: " + Base64.getEncoder().encodeToString(cipherText));

        String decryptedText = do_RSADecryption(cipherText, receiverKeypair.getPrivate());
        System.out.println("The decrypted text is: " + decryptedText);

        plainText = "Recebido";
        cipherText = do_RSAEncryption(plainText, senderKeypair.getPublic());
        System.out.println("The Sender's Public Key is: " + Base64.getEncoder().encodeToString(senderKeypair.getPublic().getEncoded()));
        System.out.println("The Encrypted Response is: " + Base64.getEncoder().encodeToString(cipherText));

        decryptedText = do_RSADecryption(cipherText, senderKeypair.getPrivate());
        System.out.println("The decrypted response is: " + decryptedText);
    }

    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] do_RSAEncryption(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String do_RSADecryption(byte[] cipherText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(cipherText));
    }

    public static int cessar_key() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key: ");
        int public_key = scanner.nextInt();
        return public_key;
    }

    public static int cessar_decryption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key: ");
        int public_key = scanner.nextInt();
        return -public_key;
    }

    public static String menu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        String encrypt = "RSA";
        int deslocamento = 3;
        int choose = 1;
        do {
            option = menu("+------------+\n|Encriptacao|\n+------------+\n"
                    + "(1)-Cessar\n"
                    + "(2)-Costum cessar key\n"
                    + "(3)-Bruteforce Cessar\n"
                    + "(0)-RSA encryptation", 0, 3);

            switch (option) {
                case 0:
                    break;
                case 1:
                    deslocamento = 3;

                    System.out.println("Using the default cessar key");
                    encrypt = cessar(deslocamento);
                    break;
                case 2:
                    System.out.println("Choose an option: \n1. Encrypt\n2. Decrypt");
                    choose = scanner.nextInt();
                    if (choose == 1) {
                        deslocamento = cessar_key();
                        encrypt = cessar(deslocamento);
                    } else {
                        if (deslocamento != 4) {
                            deslocamento = cessar_decryption();
                            encrypt = cessar(deslocamento);
                        } else {
                            System.out.println("No text available");
                        }
                    }
                    break;
                case 3:
                    if (encrypt != "") {
                        bruteforceCessar(encrypt);
                    } else {
                        System.out.println("No text available to bruteforce");
                    }
                    break;
                default:
                    break;
            }
        } while (option != 0);
        scanner.close();
        return encrypt;

    }

    public static int menu(String menu, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println(menu);
            option = scanner.nextInt();
            if (option < min || option > max) {
                System.out.println("Invalid option, try again.");
            }
        } while (option < min || option > max);
        return option;
    }

    public static String cessar(int deslocamento) {
        System.out.println("Enter your text: ");
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();
        String incrypt = "";

        // Recommend spaces if missing
        if (!texto.contains(" ")) {
            System.out.println("Text without spaces.");
        }

        // Encrypt text with spaces
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (letra == ' ') {
                incrypt += ' ';
            } else if (letra >= 'A' && letra <= 'Z') {
                incrypt += (char) (letra - 'A' + deslocamento + ('Z' - 'A') % ('Z' - 'A') + 'A');
            } else if (letra >= 'a' && letra <= 'z') {
                incrypt += (char) (letra - 'a' + deslocamento + ('z' - 'a') % ('z' - 'a') + 'a');
            } else {
                incrypt += letra;
            }
        }

        System.out.print("Mensagem atual: ");
        System.out.println(incrypt);
        return incrypt;
    }

    public static void bruteforceCessar(String texto) {
        int deslocamento = 0;
        String incrypt = "";

        for (deslocamento = 0; deslocamento < 26; deslocamento++) {
            for (int i = 0; i < texto.length(); i++) {
                char letra = texto.charAt(i);
                if (letra >= 'A' && letra <= 'Z') {
                    incrypt += (char) (letra - 'A' - deslocamento + ('Z' - 'A') % ('Z' - 'A') + 'A');
                } else if (letra >= 'a' && letra <= 'z') {
                    incrypt += (char) (letra - 'a' - deslocamento + ('z' - 'a') % ('z' - 'a') + 'a');
                } else {
                    incrypt += letra;
                }
            }
            incrypt += "   ";
            System.out.println(incrypt);
        }
    }
}

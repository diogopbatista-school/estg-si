# 🔐 Encryption System Project

This project consists of the development of an **encryption system**, a **report**, and a **presentation**.  
The system demonstrates different approaches to **symmetric** and **asymmetric encryption**, highlighting their functionalities, advantages, and limitations.  

The application allows the user to **encrypt** and **decrypt** messages using different algorithms, with a focus on both simplicity (Caesar Cipher) and security (RSA).  

---

## ✨ Features

- **Option 1: Caesar Cipher with Fixed Shift**
  - Shifts each letter by a fixed number (default = 3).
  - Example: `ABC → DEF`.

- **Option 2: Caesar Cipher with Custom Shift**
  - User chooses the shift (key between 1–26).
  - Supports both **encryption** and **decryption**.
  - Example:  
    - Key = 5  
    - Original: `Diogo` → Encrypted: `Intlt`.

- **Option 3: Brute Force Attack on Caesar Cipher**
  - Demonstrates the **vulnerability** of Caesar Cipher.  
  - Tests all possible shifts (1–26) and shows all variants.

- **Option 0: RSA Algorithm**
  - Implements **asymmetric encryption** with 2048-bit keys.  
  - Uses public/private key pairs for secure communication.  
  - Example:  
    - Person A encrypts a message with Person B’s **public key**.  
    - Person B decrypts it with their **private key**.

---

## 🔑 Workflow

Correct program execution order:
1. Use **Option 1 (Fixed Caesar)** or **Option 2 (Custom Caesar)** to encrypt a message.  
2. (Optional) Use **Option 3 (Brute Force)** if the message is still encrypted.  
3. Finally, run **Option 0 (RSA)** to demonstrate secure asymmetric communication.

⚠️ **Important Notes**
- RSA uses pre-defined messages in the code (for demonstration).  
- When using **Option 2 (Custom Caesar)**, the same key must be used for encryption and decryption.  
- Recommended Caesar shift: between 1–10 (to avoid unrecognized console characters).

---

## 🛠️ Tech Details

- **Algorithms Implemented:**
  - Symmetric: Caesar Cipher (fixed, custom, brute force).
  - Asymmetric: RSA (2048-bit keys).  
- **Security Considerations:**
  - Symmetric encryption is fast but vulnerable if the shared key is compromised.  
  - RSA provides stronger security but is computationally slower.

---

## 📊 Comparison

| Algorithm            | Type        | Pros ✅                                   | Cons ❌                            |
|----------------------|------------|-------------------------------------------|------------------------------------|
| Caesar (Fixed)       | Symmetric  | Simple, fast                              | Extremely vulnerable to brute force |
| Caesar (Custom)      | Symmetric  | Flexible, customizable                    | Still weak if key is guessed        |
| Caesar (Brute Force) | Attack     | Demonstrates weaknesses                   | Not a secure method itself          |
| RSA                  | Asymmetric | Secure, key distribution via public keys  | Slower, key management required     |

---

## 📖 Report & Presentation
- **Report (PDF):** Explains encryption processes, development, results, and conclusions.  
- **Presentation:** Scheduled for **June 7**, duration **5 minutes**.  
- Includes demonstration of all implemented algorithms.  

---

## 👥 Authors
Developed by:  
- **Diogo Batista**  

---

## 📚 References
- Caesar Cipher: Simplicity and vulnerabilities  
- RSA Algorithm: Mathematical complexity and security  
- RSA implementation and concepts inspired by [Blackbox.ai]  

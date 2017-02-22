# Cross platform 256bit AES encryption / decryption

This project contains the implementation of (iOS Objective C, iOS Swift, Android, Java, Javascript, NodeJS, Web)

## Platforms supported 

1. iOS
2. Android
3. Javascript/NodeJS/Web

## Features:

1. Cross platform support. Encryption-Decryption works across iOS, Android and Node.js. 

2. Support for Random IV (initialization vector) for encryption and decryption. Randomization is crucial for encryption schemes to achieve semantic security, a property whereby repeated usage of the scheme under the same key does not allow an attacker to infer relationships between segments of the encrypted message.

3.  Support for SHA-256 for hashing the key. Never use plain text as encryption key. Always hash the plain text key and then use for encryption. AES permits the use of 256-bit keys. Breaking a symmetric 256-bit key by brute force requires 2^128 times more computational power than a 128-bit key. A device that could check a billion billion (10^18) AES keys per second would in theory require about 3×10^51 years to exhaust the 256-bit key space.

## One of the key objective is to make AES work on all the platforms with simple implementation. 
Complex logics such as generating IV and sha256 the key are done within the library. 

## Simple Approach
### All Platforms
Pass in the plainText as String, Pass in the key as String, Pass in the IV as String. Both the encrypted and decrypted data are also String. <b> key is converted to 256-bit </b>within the library for Android and iOS

### iOS / Swift 3
Add a bridging header. [Apple documentation](https://developer.apple.com/library/content/documentation/Swift/Conceptual/BuildingCocoaApps/MixandMatch.html)
```objc
#import "CryptLib.h"
```
```swift
let plainText = "this is my plain text"
let key = "simplekey"
let iv = "1234123412341234"

let cryptoLib = CryptLib();

let encryptedString = cryptoLib.encryptPlainText(with: plainText, key: key, iv: iv)
print("encryptedString \(encryptedString! as String)")

let decryptedString = cryptoLib.decryptCipherText(with: encryptedString, key: key, iv: iv)
print("decryptedString \(decryptedString! as String)")
```

### iOS / Objective-C
```objc
NSString *plainText = @"this is my plain text";
NSString *key = @"simplekey";
NSString *iv = @"1234123412341234";

CryptLib *cryptoLib = [[CryptLib alloc] init];

NSString *encryptedString = [cryptoLib encryptPlainTextWith:plainText key:key iv:iv];
NSLog(@"encryptedString %@", encryptedString);

NSString *decryptedString = [cryptoLib decryptCipherTextWith:encryptedString key:key iv:iv];
NSLog(@"decryptedString %@", decryptedString);
```

### Android
```java
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
```

### Javascript / NodeJS / Web
Download the library
```shell
npm install cryptlib --save
```

```javascript
var plainText = "this is my plain text";
var key = "simplekey";
var iv = "1234123412341234";

var cryptoLib = require('cryptlib');

shaKey = cryptoLib.getHashSha256(key, 32); // This line is not needed on Android or iOS. Its already built into CryptLib.m and CryptLib.java

var encryptedString = cryptoLib.encrypt(plainText, shaKey, iv);
console.log('encryptedString %s', encryptedString);

var decryptedString = cryptoLib.decrypt(encryptedString, shaKey, iv);
console.log('decryptedString %s', decryptedString);
```

### Output
```
encryptedString rKzNsa7Qzk9TExJ6aHg49tGDiritTUJ08RMPm48S0o4=
decryptedString this is my plain text
```

## Advance Approach
Refer the source code

Thanks to [Cross-platform-AES-encryption](https://github.com/Pakhee/Cross-platform-AES-encryption)

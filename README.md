# Cross platform 256bit AES encryption / decryption

This project contains the implementation of (iOS Objective C, iOS Swift, Android, Java, Javascript, NodeJS)

## Platforms supported 

1. iOS
2. Android
3. NodeJS
4. PHP

## Features:

1. Cross platform support. Encryption-Decryption works across iOS, Android and Node.js. 

2. Automatically RandomIV is added while encryption and remove first randomized blocks while decryption.

3. Support for Random IV (initialization vector) for encryption and decryption. Randomization is crucial for encryption schemes to achieve semantic security, a property whereby repeated usage of the scheme under the same key does not allow an attacker to infer relationships between segments of the encrypted message.

4.  Support for SHA-256 for hashing the key. Never use plain text as encryption key. Always hash the plain text key and then use for encryption. AES permits the use of 256-bit keys. Breaking a symmetric 256-bit key by brute force requires 2^128 times more computational power than a 128-bit key. A device that could check a billion billion (10^18) AES keys per second would in theory require about 3×10^51 years to exhaust the 256-bit key space.

## One of the key objective is to make AES work on all the platforms with simple implementation. 
Complex logics such as generating IV and sha256 the key are done within the library. 

## Simple Approach
### All Platforms
Pass in the plainText as String, Pass in the key as String. Both the encrypted and decrypted data are also String. <b> key is converted to 256-bit </b>within the library for Android, iOS and NodeJS

### iOS / Swift 3, 4
Add a bridging header. [Apple documentation](https://developer.apple.com/library/content/documentation/Swift/Conceptual/BuildingCocoaApps/MixandMatch.html)
```objc
#import "CryptLib.h"
```
```swift
let plainText = "this is my plain text"
let key = "your key"

let cryptLib = CryptLib()

let cipherText = cryptLib.encryptPlainTextRandomIV(withPlainText: plainText, key: key)
print("cipherText \(cipherText! as String)")

let decryptedString = cryptLib.decryptCipherTextRandomIV(withCipherText: cipherText, key: key)
print("decryptedString \(decryptedString! as String)")
```


### Android
```kotlin
val plainText = "this is my plain text"
val key = "your key"

val cryptLib = CryptLib()

val cipherText = cryptLib.encryptPlainTextWithRandomIV(plainText, key)
println("cipherText $cipherText")

val decryptedString = cryptLib.decryptCipherTextWithRandomIV(cipherText, key)
println("decryptedString $decryptedString")
```

### Javascript / NodeJS / Web
Download the library
```shell
npm install @skavinvarnan/cryptlib --save
```

```javascript
const plainText = "this is my plain text";
const key = "your key";

const cryptLib = require('@skavinvarnan/cryptlib');

const cipherText = cryptLib.encryptPlainTextWithRandomIV(plainText, key);
console.log('cipherText %s', cipherText);

const decryptedString = cryptLib.decryptCipherTextWithRandomIV(cipherText, key);
console.log('decryptedString %s', decryptedString);
```

### PHP
Download the package
```shell
composer require ahsankhatri/cryptolib-php
```

```php
$string     = 'this is my plain text';
$secretyKey = 'BlVssQKxzAHFAUNZbqvwS+yKw/m';

$encryption = new \MrShan0\CryptoLib\CryptoLib();

$cipher  = $encryption->encryptPlainTextWithRandomIV($string, $secretyKey);
echo 'encryptedString: ' . $cipher . PHP_EOL;

$plainText = $encryption->decryptCipherTextWithRandomIV($cipher, $secretyKey);
echo 'decryptedString: ' . $plainText . PHP_EOL;
```

### Output
```
encryptedString ___Cipher Text will be generated here___
decryptedString this is my plain text
```

### Few Tests
Here are few cipher texts. Try decrypting with iOS or Android or NodeJS. 
#### Basic Example:
```
Cipher Text: "GfTE0IK4zk039+042LwPvsTjr0A8LqBDcxDWAc41YmwxNjZVJ3CcuDxWXsulbUjE"
Cipher Text: "53zydKWD3CJCoSm9YBYaV+pwwGtSP/f36nIfUnRV3GwTFsQXgX84nh0Tu6JpsHkf"
Cipher Text: "h0PMUJhigwVnJZD43i9q98b/AG7GUg8T2BdsQ4Yun2dQHPqSE5QF0RSiHUW0wguc"
Cipher Text: "EhYJzR5oaziXCSJ2ha63Oun6HXLkCILWuJWVUAl64JpU3OdvKNyoA3rKuOj+qfEO"

key: "your key"

Output Plain Text: "this is my plain text"
```

#### Example special characters:
```
Cipher Text: "71g9R98ALCvYD0AVCtNJhEik/00jvon+ductEBlt601Er6tqFrtH0kIB+62O2DPiEsKcSilUez2MXsyGzA2Z9KM8h/tiLmM6psaSLaFELXw="
Cipher Text: "f9ofx42+h5SzJI5sXa+NExyCpxXRdhLcYcuvAsX6qCkxEw10GMzYCnSslV5Ku3v5w96QlHVceLn6yBcUBeZHlpbcnKv38ZKCGxTTv95gIN0="
Cipher Text: "CvG+gJuY5mrcjQa5OfGSA39tQtgEK1fj/OMR8Jaw2XmBOGLWJvII6nNfSvhhGLYG31X65wSLTy6Naz/OTrkEA7KOlpM5PYPpjbY06JA7zHg="
Cipher Text: "C7Bc+bSC1cri0DJ6nLoGoslfMPb4nVea0xHla8nQaOilPTpAx5N8ziLZC7UhpdiSnzYqRmh0WiH5u0wJmAn0JEEFqsxhW6z0biFmT6p8x1s="

key: "%^^&&@(*&@##)@)@``~~"

Output Plain Text: "This is a my #&^&*#&^@@# PLAIN (.)(.) TEXT (@*&#(*^---"
```

## Advance Approach
Refer the source code

Thanks to [Cross-platform-AES-encryption](https://github.com/Pakhee/Cross-platform-AES-encryption)

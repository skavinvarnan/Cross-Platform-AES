## Installation

You can install the package via composer:

```bash
composer require ahsankhatri/cryptolib-php
```

## Dependencies

The bindings require the following extensions in order to work properly:

- [`openssl`](https://secure.php.net/manual/en/book.openssl.php)

If you use Composer, these dependencies should be handled automatically. If you install manually, you'll want to make sure that these extensions are available.

## Usage

#### With Random IV

``` php
$string     = 'The quick brown fox jumps over to the lazy dog.';
$secretyKey = 'BlVssQKxzAHFAUNZbqvwS+yKw/m';

$encryption = new \MrShan0\CryptoLib\CryptoLib();

$cipher  = $encryption->encryptPlainTextWithRandomIV($string, $secretyKey);
echo 'Cipher: ' . $cipher . PHP_EOL;

$plainText = $encryption->decryptCipherTextWithRandomIV($cipher, $secretyKey);
echo 'Decrypted: ' . $plainText . PHP_EOL;
```

#### With Generated IV

``` php
$string     = 'The quick brown fox jumps over to the lazy dog.';
$secretyKey = 'BlVssQKxzAHFAUNZbqvwS+yKw/m';

$encryption = new \MrShan0\CryptoLib\CryptoLib();
$iv         = $encryption->generateRandomIV();

$cipher = $encryption->encrypt($string, $secretyKey, $iv);
echo 'Cipher: ' . $cipher . PHP_EOL;

$plainText = $encryption->decrypt($cipher, $secretyKey, $iv);
echo 'Decrypted: ' . $plainText . PHP_EOL;
```
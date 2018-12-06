<?php

require 'vendor/autoload.php';

$string     = 'The quick brown fox jumps over to the lazy dog.';
$secretyKey = 'BlVssQKxzAHFAUNZbqvwS+yKw/m';

$encryption = new \MrShan0\CryptoLib\CryptoLib();

$cipher  = $encryption->encryptPlainTextWithRandomIV($string, $secretyKey);
echo 'Cipher: ' . $cipher . PHP_EOL;

$plainText = $encryption->decryptCipherTextWithRandomIV($cipher, $secretyKey);
echo 'Decrypted: ' . $plainText . PHP_EOL;
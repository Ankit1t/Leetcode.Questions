class Solution {
  public int kthDigit(long k) {

    if (k <= 9) {
        return (int) k;
    }
    k -= 9;

    long startBlock = 1;
    int digits = 2;

    while (true) {

        long blocks = 9 * startBlock;
        long blockLength = 10L * digits;
        long totalDigits = blocks * blockLength;

        if (k > totalDigits) {
            k -= totalDigits;
            startBlock *= 10;
            digits++;
        } else {
            break;
        }
    }

    long blockIndex = (k - 1) / (10L * digits);
    long b = startBlock + blockIndex;
    long pos = (k - 1) % (10L * digits);
    int numberIndex = (int) (pos / digits);
    int digitIndex = (int) (pos % digits);

    long number;

    if (b % 2 == 0) {
        number = 10 * b + numberIndex;
    } else {
        number = 10 * b + (9 - numberIndex);
    }

    String str = String.valueOf(number);
    return str.charAt(digitIndex) - '0';
}  
    
}
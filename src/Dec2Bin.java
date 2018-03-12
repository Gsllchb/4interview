import java.math.BigDecimal;
import java.util.HashSet;

class Dec2Bin {
  static final BigDecimal ZERO = new BigDecimal(0);
  static final BigDecimal ONE = new BigDecimal(1);
  static final BigDecimal TWO = new BigDecimal(2);
  static final String ERROR = "ERROR";

  static String dec2Bin(String dec) {
    BigDecimal num = new BigDecimal(dec);
    BigDecimal fraction = num.remainder(ONE);
    BigDecimal integer = num.divideToIntegralValue(ONE);
    String res1 = integer2Bin(integer);
    String res2 = fraction2Bin(fraction);
    return res2.equals(ERROR) ? ERROR : res1 + res2;
  }

  static String integer2Bin(BigDecimal integer) {
    StringBuilder sb = new StringBuilder();
    while (integer.compareTo(ZERO) != 0) {
      sb.append(integer.remainder(TWO).compareTo(ONE) == 0 ? '1' : '0');
      integer = integer.divideToIntegralValue(TWO);
    }
    return sb.toString();
  }

  static String fraction2Bin(BigDecimal fraction) {
    StringBuilder sb = new StringBuilder().append('.');
    HashSet<BigDecimal> set = new HashSet<>();
    while (fraction.compareTo(ZERO) != 0) {
      BigDecimal temp = fraction.multiply(TWO);
      fraction = temp.remainder(ONE);
      if (set.contains(fraction)) {
        return ERROR;
      }
      set.add(fraction);
      sb.append(temp.divideToIntegralValue(ONE).compareTo(ONE) == 0 ? '1' : '0');
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    assert dec2Bin("3.72").equals("ERROR");
    assert dec2Bin("3.25").equals("11.01");
    assert dec2Bin("3.75").equals("11.11");
  }
}

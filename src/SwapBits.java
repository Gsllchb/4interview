class SwapBits {

  static int swapEvenOddBits(int num) {
    int res = num;
    for (int i = 0; i < 32 / 2; ++i) {
      int even = num & (1 << (2 * i));
      int odd = num & (1 << (2 * i + 1));
      res &= ~(1 << (2 * i));
      res += (odd >> 1);
      res &= ~(1 << (2 * i + 1));
      res += (even << 1);
    }
    return res;
  }

  public static void main(String[] args) {
    assert swapEvenOddBits(0b0000) == 0b0000;
    assert swapEvenOddBits(0b1111) == 0b1111;
    assert swapEvenOddBits(0b101010) == 0b010101;
    assert swapEvenOddBits(0b111001011001) == 0b110110100110;
  }
}

class copyBitRange {
  static int copyBitRange(int n, int m, int i, int j) {
    assert j >= i;
    assert j < 32;
    assert i >= 0;
    int mask = ~((1 << (j + 1)) - 1) + (1 << i) - 1;
    return (n & mask) + (m & ~mask);
  }

  public static void main(String[] args) {
    assert copyBitRange(0b111111111111, 0b111111111, 1, 3) == 0b111111111111;
    assert copyBitRange(0b0, 0b1, 0, 0) == 0b1;
    assert copyBitRange(0b10000000000, 0b111111010111, 2, 6) == 0b10001010100;
  }
}

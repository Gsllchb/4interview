import java.util.Scanner;


public class HemaDelivery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.next().split(",");
        assert strs.length == 2;
        int x = Integer.valueOf(strs[0]);
        int y = Integer.valueOf(strs[1]);
        strs = in.next().split(",");
        int length = strs.length / 2;
        int[] xs = new int[length];
        int[] ys = new int[length];
        for (int i = 0; i < length; ++i) {
            xs[i] = Integer.valueOf(strs[2 * i]);
            ys[i] = Integer.valueOf(strs[2 * i + 1]);
        }
        
        int[] isLeft = new int[length];
        for (int i = 0; i < length - 1; ++i) {
            isLeft[i] = inLeft(xs[i], ys[i], xs[i + 1], ys[i + 1], x, y);
        }
        isLeft[length - 1] = inLeft(xs[length - 1], ys[length - 1], xs[0], ys[0], x, y);

        if (hasZero(isLeft) || allNegative(isLeft) || allPositive(isLeft)) {
            System.out.println("yes,0");
            return;
        }

        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < length; ++i) {
            double temp = distance(xs[i], ys[i], x, y);
            if (temp < minDistance) {
                minDistance = temp;
            }
        }
        for (int i = 0; i < length - 1; ++i) {
            if (!canReach(xs[i], ys[i], xs[i + 1], ys[i + 1], x, y)) {
                continue;
            }
            double temp = distance(xs[i], ys[i], xs[i + 1], ys[i + 1], x, y);
            if (temp < minDistance) {
                minDistance = temp;
            }
        }
        if (canReach(xs[length - 1], ys[length - 1], xs[0], ys[0], x, y)) {
            double temp = distance(xs[length - 1], ys[length - 1], xs[0], ys[0], x, y);
            if (temp < minDistance) {
                minDistance = temp;
            }
        }
        System.out.println("no," + Math.round(minDistance));
    }

    private static boolean canReach(int x0, int y0, int x1, int y1, int x, int y) {
        double a = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
        double b = Math.sqrt((x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1));
        double c = Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0));
        return (b * b + c * c - a * a) / (2 * b * c) > 0 && (a * a + b * b - c * c) / (2 * a * b) > 0;
    }

    private static double distance(int x0, int y0, int x1, int y1) {
        return Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
    }

    private static double distance(int x0, int y0, int x1, int y1, int x, int y) {
        return 1.0 * inLeft(x0, y0, x1, y1, x, y) / Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
    }

    private static int inLeft(int x0, int y0, int x1, int y1, int x, int y) {
        return (x1 -x0) * (y - y0) - (x - x0) * (y1 - y0);
    }

    private static boolean hasZero(int[] arr) {
        for (int i: arr) {
            if (i == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean allPositive(int[] arr) {
        for (int i: arr) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean allNegative(int[] arr) {
        for (int i: arr) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}

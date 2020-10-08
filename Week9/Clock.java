/**
 * Clock
 */
public class Clock {
  private int h0;
  private int m0;
  private static final int HOURS_PER_DAY = 24;
  private static final int MINUTES_PER_HOUR = 60;

  // Creates a clock whose initial time is h hours and m minutes.
  public Clock(int h, int m) {
    if (!(h >= 0 && h < HOURS_PER_DAY))
      throw new IllegalArgumentException("Hours must be between 0 and 23");
    if (!(m >= 0 && m < MINUTES_PER_HOUR))
      throw new IllegalArgumentException("Minutes must be between 0 and 59");

    h0 = h;
    m0 = m;
  }

  // Creates a clock whose initial time is specified as a string, using the format
  // HH:MM.
  public Clock(String s) {
    if (s.length() != 5 || !s.contains(":") || s.charAt(2) != ':')
      throw new IllegalArgumentException("Time format must be -> 00:00");
    String[] clock = s.split(":");
    int hours = Integer.parseInt(clock[0]);
    int minutes = Integer.parseInt(clock[1]);
    if (!(hours >= 0 && hours < HOURS_PER_DAY))
      throw new IllegalArgumentException("Hours must be between 0 and 23");
    if (!(minutes >= 0 && minutes < MINUTES_PER_HOUR))
      throw new IllegalArgumentException("Minutes must be between 0 and 59");

    h0 = hours;
    m0 = minutes;
  }

  // Returns a string representation of this clock, using the format HH:MM.
  public String toString() {
    if (h0 < 10 && m0 < 10)
      return "0" + h0 + ":0" + m0;
    if (h0 < 10)
      return "0" + h0 + ":" + m0;
    if (m0 < 10)
      return h0 + ":0" + m0;

    return h0 + ":" + m0;
  }

  // Is the time on this clock earlier than the time on that one?
  public boolean isEarlierThan(Clock that) {
    return (this.h0 < that.h0) || (this.h0 == that.h0 && this.m0 < that.m0);
  }

  // Adds 1 minute to the time on this clock.
  public void tic() {
    this.m0 += 1;
    if (this.m0 >= MINUTES_PER_HOUR) {
      this.m0 = this.m0 % MINUTES_PER_HOUR;
      this.h0 += 1;
    }
    if (this.h0 >= HOURS_PER_DAY) {
      this.h0 = 0;
    }
  }

  // Adds delta minute to the time on this clock
  public void toc(int delta) {
    if (delta < 0)
      throw new IllegalArgumentException("Delta must be >= 0");
    if (this.m0 + delta >= MINUTES_PER_HOUR) {
      int hour = (this.m0 + delta) / MINUTES_PER_HOUR;
      int min = (this.m0 + delta) % MINUTES_PER_HOUR;
      this.h0 += hour;
      this.m0 = min;
    } else {
      this.m0 += delta;
    }
    if (this.h0 >= HOURS_PER_DAY) {
      this.h0 = this.h0 % HOURS_PER_DAY;
    }
  }

  // Test client(see below)
  public static void main(String[] args) {
    Clock a = new Clock("14:52");
    Clock b = new Clock(23, 59);
    a.tic();
    a.toc(100);
    StdOut.println(a.isEarlierThan(b));
    StdOut.println(b.isEarlierThan(a));
    StdOut.println(a);
    StdOut.println(b);
  }
}

package sample;

public enum ActivityLevelWomen {
  SEDENTARY(1.1), LIGHTLY_ACTIVE(1.275), MODERATELY_ACTIVE(1.35), VERY_ACTIVE(1.525);

  private final double value;

  ActivityLevelWomen(final double newValue) {
    value = newValue;
  }

  public double getValue() {
    return value;
  }
}

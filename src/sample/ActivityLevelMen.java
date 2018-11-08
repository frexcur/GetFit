package sample;

public enum ActivityLevelMen {
  SEDENTARY(1.2), LIGHTLY_ACTIVE(1.375), MODERATELY_ACTIVE(1.55), VERY_ACTIVE(1.725),
  EXTREMELY_ACTIVE(1.9);

  private final double value;

  ActivityLevelMen(final double newValue) {
    value = newValue;
  }

  public double getValue() {
    return value;
  }
}

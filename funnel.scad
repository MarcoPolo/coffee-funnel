union () {
  translate ([0, 0, 30]) {
    difference () {
      cylinder ($fn=120, h=4, r=26.0);
      cylinder ($fn=120, h=4, r=24.0);
    }
  }
  difference () {
    cylinder ($fn=120, h=30, r1=29.0, r2=26.0);
    cylinder ($fn=120, h=30, r1=25.0, r2=24.0);
  }
  translate ([0, 0, -10]) {
    difference () {
      cylinder ($fn=120, h=10, r=29.0);
      cylinder ($fn=120, h=10, r=25.0);
    }
  }
}

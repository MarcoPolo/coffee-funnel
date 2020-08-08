union () {
  translate ([0, 0, 30]) {
    difference () {
      cylinder ($fn=120, h=4, r=26.75);
      cylinder ($fn=120, h=4, r=24.75);
    }
  }
  difference () {
    cylinder ($fn=120, h=30, r1=67/2, r2=26.75);
    cylinder ($fn=120, h=30, r1=59/2, r2=24.75);
  }
  translate ([0, 0, -10]) {
    difference () {
      cylinder ($fn=120, h=10, r=67/2);
      cylinder ($fn=120, h=10, r=59/2);
    }
  }
}

union () {
  translate ([0, 0, 30]) {
    difference () {
      cylinder ($fn=120, h=4, r=20);
      cylinder ($fn=120, h=4, r=18);
    }
  }
  difference () {
    cylinder ($fn=120, h=30, r1=34, r2=20);
    cylinder ($fn=120, h=30, r1=30, r2=18);
  }
  translate ([0, 0, -4]) {
    difference () {
      cylinder ($fn=120, h=4, r=34);
      cylinder ($fn=120, h=4, r=30);
    }
  }
}

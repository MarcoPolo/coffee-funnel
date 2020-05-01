union () {
  translate ([0, 0, 10]) {
    difference () {
      cylinder ($fn=120, h=7, r=53/2);
      cylinder ($fn=120, h=7, r=45/2);
    }
  }
  difference () {
    cylinder ($fn=120, h=10, r1=67/2, r2=53/2);
    cylinder ($fn=120, h=10, r1=59/2, r2=45/2);
  }
  translate ([0, 0, -10]) {
    difference () {
      cylinder ($fn=120, h=10, r=67/2);
      cylinder ($fn=120, h=10, r=59/2);
    }
  }
}

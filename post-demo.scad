union () {
  sphere (r=100);
  translate ([90, 0, 90]) {
    color ([0.533, 0.176, 0.376, 1]) {
      sphere (r=50);
    }
  }
  translate ([-90, 0, 90]) {
    color ([0.533, 0.176, 0.376, 1]) {
      sphere (r=50);
    }
  }
  translate ([0, 70, -20]) {
    color ([0.153, 0.337, 0.42, 1]) {
      sphere (r=50);
    }
  }
  translate ([0, 120, -10]) {
    color ([0.153, 0.337, 0.42, 1]) {
      sphere (r=10);
    }
  }
  translate ([-40, 85, 30]) {
    rotate (a=90.0, v=[3, 1, 0]) {
      color ([0.153, 0.337, 0.42, 1]) {
        cylinder (h=20, r=15, center=true);
      }
    }
  }
  translate ([40, 85, 30]) {
    rotate (a=90.0, v=[-3, 1, 0]) {
      color ([0.153, 0.337, 0.42, 1]) {
        cylinder (h=20, r=15, center=true);
      }
    }
  }
}

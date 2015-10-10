// 装饰器模式
var Plane = {
  fire: function() {
    console.log("fire");
  }
};

var atomDecorator = function() {
  console.log("fire Atom");
};

var fire = Plane.fire;

plane.fire = function() {
  fire();
  atomDecorator();
}

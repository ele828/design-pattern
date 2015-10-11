// Aop方式的装饰器
// 以下代码重组了一下执行顺序
Function.prototype.after = function( aFn ) {
  var __self = this;
  return function() {
    var ret = __self.apply( this, arguments );
    aFn.apply( this, arguments );
    return ret;
  }
}

var func = function() {
  console.log( "first" );
}

func.after(function() {
  console.log("second")
})();

// 职责链模式
// After构成链

Function.prototype.after = function( fn ) {
  var __self = this;

  return function() {
        var ret = __self.apply( this, arguments );    // Previous func
        if ( ret === 'next' ) {
          return fn.apply( this, arguments );
        }

        return ret;
  }

}

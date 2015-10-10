// 职责链设计模式
var Chain = function( fn ) {
  this.fn = fn;
  this.successor = null;
}

Chain.prototype.setNextSuccessor= function( successor ) {
  return this.successor = successor;
}

Chain.prototype.passRequest = function() {
  var ret = this.fn.apply( this, arguments );

  if ( ret === 'next' ) {
    return this.successor && this.successor.passRequest.apply( this.successor, arguments );
  }

  return ret;
}

// 异步职责链

var Chain = function( __fn ) {
  this.fn = __fn;
  this.successor = null;
}


Chain.prototype.setNextSuccessor = function( __successor ) {
  this.successor = __successor;
}

Chain.prototype.passRequest = function() {
  var ret = this.fn.apply( this, arguments );

  if ( ret === 'next' ) {
    return this.successor && this.successor.passRequest.apply( this.successor, arguments );
  }

  return ret;
}

Chain.prototype.next = function() {
  return this.successor && this.successor.passRequest.apply( this.successor , arguments);
}


var fn = new Chain(function() {
  setTimeout(function(){
    this.next();
  }.bind(this), 0);
});

// 迭代器
var each = function( ary, cb ) {
  for( var i = 0, l = ary.length; i < l; i++ ) {
    cb.call( ary[i], i, ary[i] );
  }
}

each( [8, 3, 4, 2], function(i, k) {
  console.log(i, k)
});
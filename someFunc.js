// 函数节流方案
// 延迟函数执行，降低触发频率
var throttle = function(fn, intv) {
  var __self = fn    // 保存需要延迟的函数的引用
    , timer
    , firstTime = true;

    return function() {
      var args = arguments
        , __me = this;

      if( firstTime ) {
          __self.apply(__me, args);
          return firstTime = false;
      }

      if( timer ) {
        return false;
      }

      timer = setTimeout(function() {
        clearTimeout(timer);
        timer = null;
        __self.apply(__me, args);
      }, intv || 500);

    };
};

// 函数分时
// 将任务按照时间分块执行
// ary: 任务队列  fn: 处理队列的函数  count: 每批执行数量  intv: 执行间隔
var timeChunk = function(ary, fn, count, intv) {
  var obj
    , t;

  var start = function() {
      for( var i = 0; i < Math.min( count || 1, ary.length ); i++) {
        var obj = ary.shift();
        fn(obj);
      }
  };

  return function() {
    t = setInterval(function() {
      if( ary.length === 0 ) {
        return clearInterval(t);
      }
      start();
    }, intv || 200);
  }

};

// 一次绑定
// 此方法可能会延迟页面加载， 下面有更好的办法
var addEvent = (function() {
  return function(elem, type, handler) {
    elem[ window.addEventListener
            ? addEventListener(type, handler, false)
            : attachEvent('on' + type, handler, false) ];
  }
})();

// 惰性加载
var addEvent = function(elem, type, handler) {
    if( window.addEventListener ) {
      addEvent = function( elem, type, handler ) {
        elem.addEventListener(type, handler, false);
      }
    } else if( window.attachEvent ) {
      addEvent = function(elem, type, handler) {
        elem.attachEvent( 'on' + type, handler );
      }
    }
    // 直接将addEvent方法重写
    addEvent(elem, type, handler);
}

/**
 * 发布-订阅模式
 */

/**
 * 售楼处
 * @type {Array}
 */
var salesOffices = {};
salesOffices.clientList = [];    // 存放订阅者的回调函数

/**
 * 订阅消息
 * @param fn
 */
salesOffices.listen = function( fn ) {
    this.clientList.push( fn );
};

/**
 * 发布消息
 * 逐一调用订阅的消息函数
 */
salesOffices.trigger = function() {
    for( var i = 0, fn; fn = this.clientList[ i++ ]; ) {
        fn.apply( this, arguments );
    }
};

/**
 * 测试
 */

salesOffices.listen(function (price) {
    console.log('Price:', price);
});

salesOffices.trigger(2000);

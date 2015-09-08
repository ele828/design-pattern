/**
 * 发布订阅模式，增加key
 *
 */

var salesOffices = {};
salesOffices.clientList = [];

/**
 * 订阅函数
 * @param key
 * @param fn
 */
salesOffices.listen = function(key, fn) {
    // 未订阅该Key，增加一个缓存列表
    if( !this.clientList[ key ] ) {
        this.clientList[ key ] = [];
    }
    this.clientList[ key ].push( fn );
};

/**
 * 发布函数
 * @returns {boolean} 发布成功与否
 */
salesOffices.trigger = function() {

    var key = [].shift.call( arguments );    // 转换类对象为数组
    var fns = this.clientList[ key ];    // 根据key，找出回调函数集合

    // 没有订阅消息，返回
    if( !fns || fns.length === 0 ) {
        return false;
    }

    for( var i = 0, fn; fn = fns[ i++ ]; ) {
        fn.apply( this, arguments );    // 发布消息附带的参数
    }
    return true;

};

// 测试

salesOffices.listen( 'purchase',  function( price ) {
    console.log('价格为:', price);
});

salesOffices.listen( 'purchase',  function( price ) {
    console.log('另一栋价格为:', price);
});

salesOffices.listen( 'discount', function( price ) {
    console.log('促销价格为:', price);
});

salesOffices.trigger( 'purchase', 200 );
salesOffices.trigger( 'discount', 100 );


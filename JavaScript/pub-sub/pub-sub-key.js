/**
 * 发布订阅模式，增加key
 *
 */

var salesOffices = {};
salesOffices.clientList = [];

salesOffices.listen = function(key, fn) {
    // 未订阅该Key，增加一个缓存列表
    if( !this.clientList[ key ] ) {
        this.clientList[ key ] = [];
    }
    this.clientList[ key ].push( fn );
};

salesOffices.trigger = function() {
    // TODO
};
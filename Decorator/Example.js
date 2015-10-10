// 利用装饰器，不覆盖onload，添加功能

window.onload = function() {
  console.log("onload");
}

// 复制原函数
var _onload = window.onload || function() {};

window.onload = function() {
  _onload();
  console.log("new func");
}

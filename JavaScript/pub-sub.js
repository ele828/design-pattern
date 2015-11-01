var setCommand = function( button, command ) {
    button.addEventListner('click', function() {
        command.execute();
    });
}

var MenuBar = {
    refresh: function() {
        console.log("Refresh menu");
    }
}

var RefreshMenuBarCommand = function(r) {
    this.receiver = r;
}

RefreshMenuBarCommand.prototype.execute = function() {
    this.receiver.refresh();
}

var refreshCommand = new RefreshMenuBarCommand(MenuBar);
setCommand( $("button"), refreshCommand );

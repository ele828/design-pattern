var EditorMemento = (function() {
    var _stack = [];
    var _pointer = -1;

    return {
        setState: function( state ) {
            _stack[ ++_pointer ] = state;
        },

        getState: function() {
            return _stack[ _pointer ];
        },

        undo: function() {
            --_pointer;
        },

        redo: function() {
            ++_pointer;
        },

        print: function() {
            console.log(_stack)
        }
    }
})();
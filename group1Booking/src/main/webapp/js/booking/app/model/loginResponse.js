Ext.define('layout.model.loginResponse', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
            name: 'userId',
            type: 'int'
        },
        {
            name: 'role',
            type: 'string'
        },
        {
            name: 'userName',
            type: 'string'
        },
        {
            name: 'isSuccess',
            type: 'string'
        }
    ]
});
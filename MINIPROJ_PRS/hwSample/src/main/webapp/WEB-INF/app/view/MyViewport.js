/*
 * File: app/view/MyViewport.js
 *
 * This file was generated by Sencha Architect
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('ExampleHW.view.MyViewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.form.Panel',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Fill',
        'Ext.button.Button'
    ],

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    id: 'formPanel',
                    itemId: 'formPanel',
                    bodyPadding: 10,
                    title: 'Sample HW',
                    items: [
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'txtValue',
                            itemId: 'txtValue',
                            fieldLabel: 'Test String'
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'bottom',
                            items: [
                                {
                                    xtype: 'tbfill'
                                },
                                {
                                    xtype: 'button',
                                    id: 'btnInsert',
                                    text: 'Insert',
                                    listeners: {
                                        click: {
                                            fn: me.onButtonClick,
                                            scope: me
                                        }
                                    }
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    },

    onButtonClick: function(button, e, eOpts) {
        var txtVal = Ext.getCmp("txtValue");
        var txt = txtVal.getValue();

        Ext.define('testClass',{
            testId:'123',
            testValue:''
        });

        var test = Ext.create('testClass');
        test.testId = 123;
        test.testValue = txt;

        Ext.Ajax.request({
            url: 'create',
            success: function(response){
                var result = Ext.decode(response.responseText);
                alert('Success');
            },
            failure: function(){
                alert('Fail');
            },
            params : { test : Ext.encode(test)}
        });


    }

});
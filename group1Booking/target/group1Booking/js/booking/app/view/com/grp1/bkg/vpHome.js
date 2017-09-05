/*
 * File: app/view/com/grp1/bkg/vpHome.js
 *
 * This file was generated by Sencha Architect version 3.0.4.
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

Ext.define('layout.view.com.grp1.bkg.vpHome', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Fill',
        'Ext.tab.Panel',
        'Ext.tab.Tab',
        'Ext.form.Panel',
        'Ext.form.field.Date',
        'Ext.grid.Panel',
        'Ext.grid.column.Number',
        'Ext.grid.column.Date',
        'Ext.grid.column.Boolean',
        'Ext.grid.View'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    height: 30,
                    width: 10,
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'toolbar',
                            flex: 1,
                            items: [
                                {
                                    xtype: 'tbfill'
                                },
                                {
                                    xtype: 'textfield',
                                    disabled: true,
                                    fieldLabel: 'Username'
                                },
                                {
                                    xtype: 'textfield',
                                    disabled: true,
                                    fieldLabel: 'UserID'
                                },
                                {
                                    xtype: 'button',
                                    text: 'Logout'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'container',
                    flex: 1,
                    width: 400,
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'tabpanel',
                            flex: 1,
                            id: 'pnlMain',
                            itemId: 'pnlMain',
                            activeTab: 0,
                            items: [
                                {
                                    xtype: 'panel',
                                    id: 'pnlTabHome',
                                    itemId: 'pnlTabHome',
                                    title: 'Home',
                                    items: [
                                        {
                                            xtype: 'form',
                                            bodyPadding: 10,
                                            title: 'Search Booking',
                                            items: [
                                                {
                                                    xtype: 'container',
                                                    layout: {
                                                        type: 'vbox',
                                                        align: 'stretch'
                                                    },
                                                    items: [
                                                        {
                                                            xtype: 'container',
                                                            flex: 1,
                                                            layout: {
                                                                type: 'hbox',
                                                                align: 'stretch'
                                                            },
                                                            items: [
                                                                {
                                                                    xtype: 'container',
                                                                    flex: 1,
                                                                    layout: {
                                                                        type: 'vbox',
                                                                        align: 'stretch',
                                                                        pack: 'end'
                                                                    },
                                                                    items: [
                                                                        {
                                                                            xtype: 'textfield',
                                                                            id: 'com.grp1.txtf',
                                                                            width: 150,
                                                                            fieldLabel: 'Booking No:'
                                                                        },
                                                                        {
                                                                            xtype: 'textfield',
                                                                            fieldLabel: 'Created By:'
                                                                        }
                                                                    ]
                                                                },
                                                                {
                                                                    xtype: 'container',
                                                                    flex: 1,
                                                                    layout: {
                                                                        type: 'vbox',
                                                                        align: 'stretch'
                                                                    },
                                                                    items: [
                                                                        {
                                                                            xtype: 'datefield',
                                                                            fieldLabel: 'FromDate:'
                                                                        },
                                                                        {
                                                                            xtype: 'datefield',
                                                                            fieldLabel: 'To Date:'
                                                                        }
                                                                    ]
                                                                }
                                                            ]
                                                        },
                                                        {
                                                            xtype: 'container',
                                                            flex: 1,
                                                            layout: {
                                                                type: 'hbox',
                                                                align: 'stretch'
                                                            }
                                                        },
                                                        {
                                                            xtype: 'toolbar',
                                                            flex: 1,
                                                            items: [
                                                                {
                                                                    xtype: 'tbfill'
                                                                },
                                                                {
                                                                    xtype: 'button',
                                                                    text: 'Search',
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
                                                },
                                                {
                                                    xtype: 'container',
                                                    layout: {
                                                        type: 'vbox',
                                                        align: 'stretch'
                                                    },
                                                    items: [
                                                        {
                                                            xtype: 'gridpanel',
                                                            flex: 1,
                                                            title: 'Bookings',
                                                            columns: [
                                                                {
                                                                    xtype: 'gridcolumn',
                                                                    dataIndex: 'string',
                                                                    text: 'String'
                                                                },
                                                                {
                                                                    xtype: 'numbercolumn',
                                                                    dataIndex: 'number',
                                                                    text: 'Number'
                                                                },
                                                                {
                                                                    xtype: 'datecolumn',
                                                                    dataIndex: 'date',
                                                                    text: 'Date'
                                                                },
                                                                {
                                                                    xtype: 'booleancolumn',
                                                                    dataIndex: 'bool',
                                                                    text: 'Boolean'
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                }
                                            ],
                                            dockedItems: [
                                                {
                                                    xtype: 'toolbar',
                                                    dock: 'bottom',
                                                    frame: true,
                                                    layout: {
                                                        type: 'hbox',
                                                        align: 'bottom'
                                                    },
                                                    items: [
                                                        {
                                                            xtype: 'tbfill',
                                                            frame: false
                                                        },
                                                        {
                                                            xtype: 'button',
                                                            iconAlign: 'right',
                                                            text: 'Reset'
                                                        }
                                                    ]
                                                }
                                            ]
                                        }
                                    ]
                                },
                                {
                                    xtype: 'panel',
                                    title: 'Tab 2'
                                },
                                {
                                    xtype: 'panel',
                                    title: 'Tab 3'
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
        var x = Ext.create('layout.view.MyViewport1');
        x.show();
    }

});
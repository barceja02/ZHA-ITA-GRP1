/*
 * File: app/view/com/grp1/bkg/CreateBooking.js
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

Ext.define('layout.view.com.grp1.bkg.CreateBooking', {
    extend: 'Ext.window.Window',

    alternateClassName: [
        'createbooking'
    ],
    requires: [
        'Ext.form.Panel',
        'Ext.form.field.ComboBox',
        'Ext.form.RadioGroup',
        'Ext.form.field.Radio',
        'Ext.form.field.TextArea',
        'Ext.button.Button'
    ],

    border: 5,
    draggable: false,
    id: 'CreateBooking',
    itemId: 'CreateBooking',
    layout: 'fit',
    bodyBorder: true,
    title: 'Create Booking',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    id: 'createBkgContainer',
                    itemId: 'createBkgContainer',
                    layout: {
                        type: 'vbox',
                        align: 'center',
                        pack: 'center'
                    },
                    items: [
                        {
                            xtype: 'form',
                            id: 'createBkgForm',
                            itemId: 'createBkgForm',
                            layout: 'vbox',
                            bodyBorder: true,
                            bodyPadding: 10,
                            title: '',
                            items: [
                                {
                                    xtype: 'textfield',
                                    disabled: true,
                                    id: 'txtBkgNum',
                                    itemId: 'txtBkgNum',
                                    width: 307,
                                    fieldLabel: 'Booking  Number',
                                    name: 'txtBkgNum'
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'txtCntrNum',
                                    itemId: 'txtCntrNum',
                                    width: 424,
                                    fieldLabel: 'Container  Number:',
                                    name: 'txtCntrNum'
                                },
                                {
                                    xtype: 'combobox',
                                    flex: 1,
                                    id: 'cntrTypeComboBox',
                                    itemId: 'cntrTypeComboBox',
                                    fieldLabel: 'Container Type',
                                    name: 'cntrTypeComboBox',
                                    store: [
                                        '20GP',
                                        '40GP',
                                        '20HQ',
                                        '40HQ',
                                        '45HQ'
                                    ]
                                },
                                {
                                    xtype: 'radiogroup',
                                    flex: 1,
                                    id: 'cgoNatureRadioGrp',
                                    itemId: 'cgoNatureRadioGrp',
                                    fieldLabel: 'Cargo Nature',
                                    allowBlank: false,
                                    columns: 'auto',
                                    layout: {
                                        type: 'hbox',
                                        align: 'stretchmax',
                                        pack: 'center'
                                    },
                                    items: [
                                        {
                                            xtype: 'radiofield',
                                            id: 'GCRadioButton',
                                            itemId: 'GCRadioButton',
                                            name: 'cargoTypeRadioButton',
                                            value: 'GC',
                                            boxLabel: 'GC'
                                        },
                                        {
                                            xtype: 'radiofield',
                                            id: 'RFRadioButton',
                                            itemId: 'RFRadioButton',
                                            name: 'cargoTypeRadioButton',
                                            value: 'RF',
                                            boxLabel: 'RF'
                                        },
                                        {
                                            xtype: 'radiofield',
                                            id: 'DGRadioButton',
                                            itemId: 'DGRadioButton',
                                            name: 'cargoTypeRadioButton',
                                            value: 'DG',
                                            boxLabel: 'DG'
                                        },
                                        {
                                            xtype: 'radiofield',
                                            id: 'AWRadioButton',
                                            itemId: 'AWRadioButton',
                                            name: 'cargoTypeRadioButton',
                                            value: 'AW',
                                            boxLabel: 'AW'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'textareafield',
                                    id: 'txtCgoDesc',
                                    itemId: 'txtCgoDesc',
                                    width: 439,
                                    fieldLabel: 'Cargo Description:',
                                    name: 'txtCgoDesc'
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'txtGrossWeight',
                                    itemId: 'txtGrossWeight',
                                    fieldLabel: 'Gross Weight',
                                    name: 'txtGrossWeight'
                                },
                                {
                                    xtype: 'combobox',
                                    flex: 1,
                                    id: 'gUnitComboBox',
                                    itemId: 'gUnitComboBox',
                                    fieldLabel: 'Gross Unit',
                                    name: 'gUnitComboBox',
                                    store: [
                                        'KG',
                                        'LBS'
                                    ]
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'txtNetWeight',
                                    itemId: 'txtNetWeight',
                                    fieldLabel: 'Net Weight:',
                                    name: 'txtNetWeight'
                                },
                                {
                                    xtype: 'combobox',
                                    id: 'nUnitComboBox',
                                    itemId: 'nUnitComboBox',
                                    fieldLabel: 'Net Unit',
                                    name: 'nUnitComboBox',
                                    store: [
                                        'KG',
                                        'LBS'
                                    ]
                                },
                                {
                                    xtype: 'combobox',
                                    id: 'fromCityComboBox',
                                    itemId: 'fromCityComboBox',
                                    width: 437,
                                    fieldLabel: 'From City',
                                    name: 'fromCityComboBox',
                                    store: [
                                        'HKG',
                                        'LGB',
                                        'MNL',
                                        'SIN',
                                        'PUS',
                                        'RTM'
                                    ]
                                },
                                {
                                    xtype: 'combobox',
                                    id: 'toCityComboBox',
                                    itemId: 'toCityComboBox',
                                    width: 436,
                                    fieldLabel: 'To City',
                                    name: 'toCityComboBox',
                                    store: [
                                    	'HKG',
                                        'LGB',
                                        'MNL',
                                        'SIN',
                                        'PUS',
                                        'RTM'
                                    ]
                                },
                                {
                                    xtype: 'combobox',
                                    id: 'txtShipper',
                                    itemId: 'txtShipper',
                                    width: 440,
                                    fieldLabel: 'Shipper',
                                    name: 'txtShipper',
                                    displayField: 'companyName',
                                    store: 'ShipperConsigneeStore',
                                    valueField: 'id'
                                },
                                {
                                    xtype: 'combobox',
                                    id: 'txtConsignee',
                                    itemId: 'txtConsignee',
                                    width: 440,
                                    fieldLabel: 'Consignee',
                                    name: 'txtConsignee',
                                    displayField: 'companyName',
                                    store: 'ShipperConsigneeStore',
                                    valueField: 'id'
                                },
                                {
                                    xtype: 'checkboxgroup',
                                    flex: 1,
                                    width: 400,
                                    layout: 'fit',
                                    fieldLabel: 'Validations',
                                    items: [
                                        {
                                            xtype: 'checkboxfield',
                                            id: 'chkWtValid',
                                            itemId: 'chkWtValid',
                                            boxLabel: 'Weight Valid?'
                                        },
                                        {
                                            xtype: 'checkboxfield',
                                            id: 'chkGoodCust',
                                            itemId: 'chkGoodCust',
                                            boxLabel: 'Good Customer'
                                        },
                                        {
                                            xtype: 'checkboxfield',
                                            id: 'chkDocsApproved',
                                            itemId: 'chkDocsApproved',
                                            boxLabel: 'Documents Approved'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'button',
                                    id: 'btnCreateBkg',
                                    itemId: 'btnCreateBkg',
                                    text: 'Save'
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});
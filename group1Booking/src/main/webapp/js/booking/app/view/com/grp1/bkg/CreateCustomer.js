/*
 * File: app/view/com/grp1/bkg/CreateCustomer.js
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

Ext.define('layout.view.com.grp1.bkg.CreateCustomer', {
    extend: 'Ext.window.Window',

    alternateClassName: [
        'createcustomer'
    ],
    requires: [
        'Ext.form.Panel',
        'Ext.form.field.Text',
        'Ext.form.field.Checkbox',
        'Ext.button.Button'
    ],

    border: 5,
    draggable: true,
    id: 'CreateCustomer',
    itemId: 'CreateCustomer',
    layout: 'fit',
    bodyBorder: true,
    title: 'Create Customer',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    id: 'createCustContainer1',
                    itemId: 'createCustContainer',
                    layout: {
                        type: 'vbox',
                        align: 'center',
                        pack: 'center'
                    },
                    items: [
                        {
                            xtype: 'form',
                            id: 'createCustForm1',
                            itemId: 'createCustForm',
                            layout: 'vbox',
                            bodyBorder: true,
                            bodyPadding: 10,
                            title: '',
                            items: [
                                {
                                    xtype: 'textfield',
                                    disabled: true,
                                    id: 'customertxtfCustomerId',
                                    itemId: 'customertxtfCustomerId',
                                    width: 307,
                                    fieldLabel: 'Booking  Number',
                                    name: 'txtBkgNum'
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'customertxtfFirstName',
                                    itemId: 'customertxtfFirstName',
                                    width: 424,
                                    fieldLabel: 'First Name',
                                    name: 'txtCntrNum'
                                },
                                {
                                    xtype: 'textfield',
                                    flex: 1,
                                    id: 'customertxtfLastName',
                                    itemId: 'customertxtfLastName',
                                    fieldLabel: 'Last Name',
                                    name: 'txtGrossWeight'
                                },
                                {
                                    xtype: 'textfield',
                                    flex: 1,
                                    id: 'customerwindowtxtfAddress',
                                    itemId: 'customerwindowtxtfAddress',
                                    fieldLabel: 'Address',
                                    name: 'txtGrossWeight'
                                },
                                {
                                    xtype: 'textfield',
                                    flex: 1,
                                    id: 'customertxtfContactNumber',
                                    itemId: 'customertxtfContactNumber',
                                    fieldLabel: 'Contact Number',
                                    name: 'txtGrossWeight'
                                },
                                {
                                    xtype: 'textfield',
                                    flex: 1,
                                    id: 'customerwindowtxtfCompanyName',
                                    itemId: 'customerwindowtxtfCompanyName',
                                    fieldLabel: 'Company Name',
                                    name: 'txtGrossWeight'
                                },
                                {
                                    xtype: 'textfield',
                                    flex: 1,
                                    id: 'customertxtfEmail',
                                    itemId: 'customertxtfEmail',
                                    fieldLabel: 'Email Address',
                                    name: 'txtGrossWeight'
                                },
                                {
                                    xtype: 'textfield',
                                    flex: 1,
                                    disabled: true,
                                    id: 'customertxtfRole',
                                    itemId: 'customertxtfRole',
                                    fieldLabel: 'Role',
                                    name: 'txtGrossWeight',
                                    value: 'CUSTOMER',
                                    emptyText: 'CUSTOMER'
                                },
                                {
                                    xtype: 'checkboxfield',
                                    flex: 1,
                                    id: 'customerchkboxActive',
                                    itemId: 'customerchkboxActive',
                                    fieldLabel: 'Active',
                                    boxLabel: ''
                                },
                                {
                                    xtype: 'textfield',
                                    flex: 1,
                                    id: 'customertxtfUsername',
                                    itemId: 'customertxtfUsername',
                                    fieldLabel: 'Username',
                                    name: 'txtGrossWeight'
                                },
                                {
                                    xtype: 'textfield',
                                    flex: 1,
                                    id: 'customertxtfPassword',
                                    itemId: 'customertxtfPassword',
                                    fieldLabel: 'Password',
                                    name: 'txtGrossWeight',
                                    inputType: 'password'
                                },
                                {
                                    xtype: 'button',
                                    id: 'customerbtnCreate',
                                    itemId: 'customerbtnCreate',
                                    text: 'Create'
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
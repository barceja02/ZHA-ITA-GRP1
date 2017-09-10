/*
 * File: app/model/CustomerCreationModel.js
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

Ext.define('layout.model.CustomerCreationModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
            name: 'customerId',
            type: 'int'
        },
        {
            name: 'companyName',
            type: 'string'
        },
        {
            name: 'firstname',
            type: 'string'
        },
        {
            name: 'lastname',
            type: 'string'
        },
        {
            name: 'address',
            type: 'string'
        },
        {
            name: 'role',
            type: 'string'
        },
        {
            name: 'contactNumber',
            type: 'string'
        },
        {
            name: 'mailAddress',
            type: 'string'
        },
        {
            name: 'isActive',
            type: 'int'
        },
        {
            name: 'username',
            type: 'string'
        },
        {
            name: 'password',
            type: 'string'
        },
        {
            name: 'acctId',
            type: 'int'
        }
    ]
});